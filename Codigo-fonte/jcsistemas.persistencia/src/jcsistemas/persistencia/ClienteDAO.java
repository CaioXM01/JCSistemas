/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsistemas.persistencia;

import br.edu.ifnmg.jcsistemas.aplicacao.Cliente;
import br.edu.ifnmg.jcsistemas.aplicacao.Endereco;
import br.edu.ifnmg.jcsistemas.aplicacao.ClienteRepositorio;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class ClienteDAO extends DAOGenerico<Cliente> implements ClienteRepositorio {
    @Override
    protected String consultaAbrir() {
        return "select id, nome, cpf, nascimento from Clientes where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into Clientes(nome, cpf, nascimento) values(?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update Clientes set nome = ?, cpf = ?, nascimento = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from Clientes where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id, nome, cpf, nascimento from Clientes "; 
    }

    @Override
    protected void carregaParametros(Cliente obj, PreparedStatement consulta) {
        try {
            
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
            consulta.setDate(3, new Date(obj.getNascimento().getTime()));
            
            if(obj.getId() > 0)
                consulta.setLong(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Cliente obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());
        
        if(obj.getCpf() != null && !obj.getCpf().isEmpty())
            sql = this.filtrarPor(sql, "cpf", obj.getCpf().replace(".", "").replace("-", ""));        
        
        return sql;
    }

    @Override
    protected Cliente carregaObjeto(ResultSet dados) {
        try {
            Cliente obj = new Cliente(
                dados.getString("cpf"), 
                dados.getString("rg"),
                dados.getLong("id"), 
                dados.getString("nome"), 
                dados.getDate("nascimento"),
                dados.getLong("idEndereco")
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
