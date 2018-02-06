/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsistemas.persistencia;

import br.edu.ifnmg.jcsistemas.aplicacao.Servico;
import br.edu.ifnmg.jcsistemas.aplicacao.ServicoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio
 */
public class ServicoDAO extends DAOGenerico<Servico> implements ServicoRepositorio{

  @Override
    protected String consultaAbrir() {
        return "select id, nome, descricao, tipo, venda from servicos where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into servicos(nome, descricao, tipo, venda) values(?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update Clientes set nome = ?, cpf = ?, nascimento = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from servicos where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id, nome, descricao, tipo, venda from servicos "; 
    }

    @Override
    protected void carregaParametros(Servico obj, PreparedStatement consulta) {
        try {
            
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getDescricao());
            consulta.setString(3, obj.getTipo());
            consulta.setBigDecimal(4, obj.getValorVenda());
            
            /*consulta.setDate(3, new Date(obj.getNascimento().getTime()));*/
            
            if(obj.getId() > 0)
                consulta.setLong(5, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Servico obj){
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
    protected Servico carregaObjeto(ResultSet dados) {
        try {
            Servico obj = new Servico(); 
                obj.setDescricao(dados.getString("descricao")); 
                obj.setTipo(dados.getString("tipo")); 
               // obj.setId(dados.getLong("id")); 
                obj.setNome(dados.getString("nome"));
                obj.setValorVenda(dados.getBigDecimal("venda"));

            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
