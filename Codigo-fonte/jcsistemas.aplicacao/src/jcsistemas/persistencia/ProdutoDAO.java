/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsistemas.persistencia;

import br.edu.ifnmg.jcsistemas.aplicacao.Produto;
import br.edu.ifnmg.jcsistemas.aplicacao.ProdutoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author caio
 */
public class ProdutoDAO extends DAOGenerico<Produto> implements ProdutoRepositorio {
    @Override
    protected String consultaAbrir() {
        return "select id, nome, descricao, tipo, estoque, custo, venda from produtos where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into produtos(nome, descricao, tipo, custo, venda) values(?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update produtos set nome=?, descricao=?, tipo=?, estoque=?, custo=?, venda=?  where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from Clientes where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id, nome, descricao, tipo, estoque, custo, venda from produtos "; 
    }

    @Override
    protected void carregaParametros(Produto obj, PreparedStatement consulta) {
        try {
            
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getDescricao());
            consulta.setString(3, obj.getTipo());
            consulta.setLong(4, obj.getEstoque());
            consulta.setBigDecimal(5, obj.getValorCusto());
            consulta.setBigDecimal(6, obj.getValorVenda());
            
            /*consulta.setDate(3, new Date(obj.getNascimento().getTime()));*/
            
            if(obj.getId() > 0)
                consulta.setLong(7, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Produto obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());
        
        if(obj.getDescricao() != null && !obj.getDescricao().isEmpty())
            sql = this.filtrarPor(sql, "descicao", obj.getDescricao());  
        
        if(obj.getTipo() != null && !obj.getTipo().isEmpty())
            sql = this.filtrarPor(sql, "tipo", obj.getTipo());
        
        return sql;
    }

    @Override
    protected Produto carregaObjeto(ResultSet dados) {
        try {
            Produto obj = new Produto(); 
                obj.setDescricao(dados.getString("descricao")); 
                obj.setTipo(dados.getString("tipo")); 
                obj.setId(dados.getLong("id")); 
                obj.setEstoque(dados.getLong("estoque")); 
                obj.setNome(dados.getString("nome"));
              
                obj.setValorCusto(dados.getBigDecimal("custo"));
                obj.setValorVenda(dados.getBigDecimal("venda"));

            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
