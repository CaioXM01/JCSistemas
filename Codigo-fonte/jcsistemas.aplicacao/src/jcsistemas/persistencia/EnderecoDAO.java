/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsistemas.persistencia;
import br.edu.ifnmg.jcsistemas.aplicacao.Endereco;
import br.edu.ifnmg.jcsistemas.aplicacao.EnderecoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
public class EnderecoDAO extends DAOGenerico<Endereco> implements EnderecoRepositorio{
    @Override
    protected String consultaAbrir() {
        return "select idEndereco, cidade, rua, complemento, numero, bairro, estado, cep from enderecos where idEndereco = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into enderecos(cidade, rua, complemento, numero, bairro, estado, cep) values(?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update enderecos set cidade = ?, rua = ?, complemento = ?, numero = ?, bairro = ?, estado = ?, cep = ? where idEndereco = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from enderecos where idEndereco = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select idEndereco, cidade, rua, comlemento, numero, bairro, estado, cep from enderecos"; 
    }

    @Override
    protected void carregaParametros(Endereco obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getCidade());
            consulta.setString(2, obj.getRua());
            consulta.setString(3, obj.getComplemento());           
            consulta.setLong(4, obj.getNumero());
            consulta.setString(5, obj.getBairro());
            consulta.setLong(6, obj.getEstado());
            consulta.setString(7, obj.getCep());
           // consulta.setString(6, obj.getEstado());
            if(obj.getId() > 0)
                consulta.setLong(8, obj.getId());
             
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Endereco obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
   //trocar atributos
        if(obj.getBairro() != null && !obj.getBairro().isEmpty())
            sql = this.filtrarPor(sql, "bairro", obj.getBairro());
        if(obj.getCidade() != null && !obj.getCidade().isEmpty())
            sql = this.filtrarPor(sql, "cidade", obj.getCidade());
        if(obj.getComplemento() != null && !obj.getComplemento().isEmpty())
            sql = this.filtrarPor(sql,"complemento", obj.getComplemento());
       /* if(obj.getEstado()!= null && !obj.getEstado().isEmpty())
            sql = this.filtrarPor(sql, "estado", obj.getEstado());*/
        if(obj.getCep()!= null && !obj.getCep().isEmpty())
            sql = this.filtrarPor(sql, "cep", obj.getCep());
        if(obj.getRua() != null && !obj.getRua().isEmpty())
            sql = this.filtrarPor(sql, "rua", obj.getRua());
        if(obj.getNumero() > 0 )
            sql = this.filtrarPor(sql, "numero", Long.toString(obj.getNumero()));        
        return sql;
    }

    @Override
    protected Endereco carregaObjeto(ResultSet dados) {
        try {
            Endereco obj = new Endereco(
                dados.getLong("idEndereco"), 
                dados.getLong("estado"), 
                dados.getLong("numero"),
                dados.getString("rua"),
                dados.getString("bairro"), 
                dados.getString("complemento"),
                dados.getString("cidade") ,
                dados.getString("cep")     
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
