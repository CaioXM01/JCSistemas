/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsistemas.persistencia;

import br.edu.ifnmg.jcsistemas.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.jcsistemas.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.jcsistemas.aplicacao.NotaCompra;
import br.edu.ifnmg.jcsistemas.aplicacao.NotaCompraRepositorio;
import br.edu.ifnmg.jcsistemas.aplicacao.NotaItem;
import br.edu.ifnmg.jcsistemas.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.jcsistemas.aplicacao.RepositorioBuilder;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class NotaCompraDAO  extends DAOGenerico<NotaCompra> implements NotaCompraRepositorio {
    
    FornecedorRepositorio fornecedor = RepositorioBuilder.getFornecedorRepositorio();
    ProdutoRepositorio produtos = RepositorioBuilder.getProdutoRepositorio();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");


  @Override
    protected String consultaAbrir() {
        return "select id, id_fornecedor, dataCompra, valorTotal from compras where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into compras(id_fornecedor, dataCompra, valorTotal) values(?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update vendas set id_cliente=?, datavenda=?, valortotal=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete vendas where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id, id_cliente, datavenda, valortotal from vendas ";
    }

    @Override
    protected void carregaParametros(NotaCompra obj, PreparedStatement consulta) {
        try {
            consulta.setLong(1, obj.getCliente().getId());
            consulta.setDate(2, new Date(obj.getDataVenda().getTime()));
            consulta.setBigDecimal(3, obj.getValorTotal());

        } catch (SQLException ex) {
            Logger.getLogger(NotaVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected NotaVenda carregaObjeto(ResultSet dados) {
        try {

            NotaVenda obj = new NotaVenda();
            obj.setId(dados.getLong("id"));
            obj.setCliente(clientes.Abrir(dados.getLong("id_cliente")));
            obj.setDataVenda(new java.util.Date(dados.getDate("datavenda").getTime()));
            obj.setValorTotal(dados.getBigDecimal("valortotal"));

            obj.setItens((ArrayList) AbrirItens(obj));

            return obj;

        } catch (SQLException ex) {
            Logger.getLogger(NotaVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<NotaItem> AbrirItens(NotaVenda obj) {
        try {
            // Utilizando a conexão aberta, cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(
                    "select id, id_venda, id_produto, quantidade, valorunitario from vendasitens where id_venda = ?");

            // Coloca o parâmetro da consulta (id)
            consulta.setLong(1, obj.getId());

            // Executa a consulta select e recebe os dados de retorno
            ResultSet dados = consulta.executeQuery();

            List<NotaItem> itens = new ArrayList<>();
            while (dados.next()) {
                itens.add(carregaObjetoItem(obj, dados));
            }

            return itens;

        } catch (SQLException ex) {
            Logger.getLogger(NotaVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    private NotaItem carregaObjetoItem(NotaVenda venda, ResultSet dados) {
        try {
            NotaItem item = new NotaItem();
            item.setId(dados.getLong("id"));
            item.setVenda(venda);
            item.setProduto(produtos.Abrir(dados.getLong("id_produto")));
            item.setQuantidade(dados.getInt("quantidade"));
            item.setValorUnitario(dados.getBigDecimal("valorunitario"));

            return item;
        } catch (SQLException ex) {
            Logger.getLogger(NotaVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected String carregaParametrosBusca(NotaVenda obj) {
        String sql = "";
        if (obj.getId() > 0) {
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        }

        if (obj.getDataVenda() != null) {
            sql = this.filtrarPor(sql, "datavenda", df.format(obj.getDataVenda()));
        }

        if (obj.getCliente() != null) {
            sql = this.filtrarPor(sql, "id_cliente", Long.toString(obj.getCliente().getId()));
        }

        return sql;
    }

    @Override
    public boolean Salvar(NotaVenda obj) {
        if (super.Salvar(obj)) {
            
            long id = obj.getId();
            
            if(id == 0){
            
                try {
                    String pegaid = "select max(id) from vendas where id_cliente = ? and datavenda = ?";
                    
                    PreparedStatement consultaid = BD.getConexao().prepareStatement(pegaid);
                    
                    consultaid.setLong(1, obj.getCliente().getId());
                    consultaid.setDate(2, new java.sql.Date(obj.getDataVenda().getTime()));
                    
                    ResultSet retorno = consultaid.executeQuery();
                    
                    retorno.next();
                    
                    id = retorno.getLong(1);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(NotaVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            try {
                String sql = "insert into vendasitens(id_venda, id_produto, quantidade, valorunitario) values(?,?,?,?)";

                for (NotaItem i : obj.getItens()) {

                    PreparedStatement consulta = BD.getConexao().prepareStatement(sql);

                    consulta.setLong(1, id);
                    consulta.setLong(2, i.getProduto().getId());
                    consulta.setInt(3, i.getQuantidade());
                    consulta.setBigDecimal(4, i.getValorUnitario());
                    
                    consulta.executeUpdate();

                }

                return true;
            } catch (SQLException ex) {
                Logger.getLogger(NotaVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    protected void carregaParametros(NotaCompra obj, PreparedStatement consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String carregaParametrosBusca(NotaCompra obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
