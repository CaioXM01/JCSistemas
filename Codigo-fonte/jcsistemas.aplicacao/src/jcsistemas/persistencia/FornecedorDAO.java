/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsistemas.persistencia;

import br.edu.ifnmg.jcsistemas.aplicacao.Fornecedor;
import br.edu.ifnmg.jcsistemas.aplicacao.FornecedorRepositorio;
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
public class FornecedorDAO extends DAOGenerico<Fornecedor> implements FornecedorRepositorio {
    @Override
    protected String consultaAbrir() {
        return "select idFornecedor, nomeFornecedor, cnpj, registro, email, telefone, endereco from fornecedores where idFornecedor = ?";
    }

    @Override
    protected String consultaInsert() {/*dataNascimento,*/ 
        return "insert into fornecedores (nomeFornecedor, cnpj, registro, email, telefone, endereco) values(?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update fornecedores set nomeFornecedor = ?, cnpj = ?, registro = ?, email = ?, telefone = ? where idFornecedor = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from fornecedores where idFornecedor = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select idFornecedor, nomeFornecedor, cnpj, registro, email, telefone, endereco from fornecedores "; 
    }

    @Override
    protected void carregaParametros(Fornecedor obj, PreparedStatement consulta) {
        try {
            
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getCnpj());
            consulta.setString(3, obj.getInscriEstadual());
            consulta.setString(4, obj.getEmail());
            consulta.setString(5, obj.getTelefone());
            if(obj.getId() == 0)
            consulta.setLong(6, obj.getEndereco());
            //consulta.setDate(3, new Date(obj.getNascimento().getTime()));
         if(obj.getId() > 0)
                consulta.setLong(6, obj.getId());
                
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Fornecedor obj){
        String sql = "";
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "idFornecedor", Long.toString( obj.getId() ));
        if(obj.getEndereco() > 0)
            sql = this.filtrarPor(sql, "endereco", Long.toString( obj.getEndereco() ));
        if(obj.getInscriEstadual() != null && !obj.getInscriEstadual().isEmpty())
            sql = this.filtrarPor(sql, "registro", obj.getInscriEstadual());
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nomeFornecedor", obj.getNome());
        if(obj.getCnpj() != null && !obj.getCnpj().isEmpty())
            sql = this.filtrarPor(sql, "cnpj", obj.getCnpj());        
        
        return sql;
    }

    @Override
    protected Fornecedor carregaObjeto(ResultSet dados) {
        try {
            Fornecedor obj = new Fornecedor(
                dados.getString("cnpj"), 
                dados.getString("registro"),
                dados.getString("nomeFornecedor"), 
                dados.getDate("dataNascimento"),
                dados.getLong("endereco"),    
                dados.getLong("idFornecedor"), 
                dados.getString("email"), 
                dados.getString("telefone")    
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
@Override
public boolean Salvar(Fornecedor obj) {
       long id = obj.getId();
       if(id == 0){

           try {
               String pegaid = "select max(idEndereco) from enderecos";

               PreparedStatement consultaid = BD.getConexao().prepareStatement(pegaid);
               ResultSet retorno = consultaid.executeQuery();

               retorno.next();
               id = retorno.getLong(1);
               
               
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
       
       obj.setEndereco(id);
       if(obj.getId() == 0){
       try {
                String sql = consultaInsert();
                PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
                this.carregaParametros(obj, consulta);
                consulta.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       }else{
           try {
                String sql = consultaUpdate();
                PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
                this.carregaParametros(obj, consulta);
                consulta.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        return false;
  }
}
