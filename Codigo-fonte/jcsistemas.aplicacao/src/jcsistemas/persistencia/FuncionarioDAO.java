/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcsistemas.persistencia;

import br.edu.ifnmg.jcsistemas.aplicacao.Funcionario;
import br.edu.ifnmg.jcsistemas.aplicacao.FuncionarioRepositorio;
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
public class FuncionarioDAO extends DAOGenerico<Funcionario> implements FuncionarioRepositorio {
    @Override
    protected String consultaAbrir() {
        return "select idFuncionario, nomeFuncionario, cpf, registro, dataNascimento, email, telefone, senha, cargo, salario, endereco from funcionarios where idFuncionario = ?";
    }

    @Override   
    protected String consultaInsert() {/*dataNascimento,*/ 
        return "insert into funcionarios(nomeFuncionario, cpf, registro, email, telefone, senha, cargo, salario, endereco) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update funcionarios set nomeFuncionario = ?, cpf = ?, registro = ?, email = ?, telefone = ?, senha = ?, cargo = ?, salario = ? where idFuncionario = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from funcionarios where idFuncionario = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select idFuncionario, nomeFuncionario, cpf, registro, dataNascimento, email, telefone, senha, cargo, salario endereco from funcionarios "; 
    }

    @Override
    protected void carregaParametros(Funcionario obj, PreparedStatement consulta) {
        try {
            
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
            consulta.setString(3, obj.getRg());
            consulta.setString(4, obj.getEmail());
            consulta.setString(5, obj.getTelefone());
            consulta.setString(6, obj.getSenha());
            consulta.setString(7, obj.getCargo());
            consulta.setDouble(8, obj.getSalario());
            if(obj.getId() == 0)
            consulta.setLong(9, obj.getEndereco());
            //consulta.setDate(3, new Date(obj.getNascimento().getTime()));
         if(obj.getId() > 0)
                consulta.setLong(9, obj.getId());
                
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Funcionario obj){
        String sql = "";
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "idFuncionario", Long.toString( obj.getId() ));
        if(obj.getEndereco() > 0)
            sql = this.filtrarPor(sql, "endereco", Long.toString( obj.getEndereco() ));
        if(obj.getRg() != null && !obj.getRg().isEmpty())
            sql = this.filtrarPor(sql, "rg", obj.getRg());
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nomeFuncionario", obj.getNome());
        if(obj.getCpf() != null && !obj.getCpf().isEmpty())
            sql = this.filtrarPor(sql, "cpf", obj.getCpf().replace(".", "").replace("-", ""));        
        
        return sql;
    }

    @Override
    protected Funcionario carregaObjeto(ResultSet dados) {
        try {
            Funcionario obj = new Funcionario(
                dados.getString("cargo"), 
                dados.getDouble("salario"),  
                dados.getString("cpf"), 
                dados.getString("registro"),
                dados.getLong("idFuncionario"), 
                dados.getString("nomeFuncionario"), 
                dados.getDate("dataNascimento"),
                dados.getLong("endereco"),
                dados.getString("email"),
                dados.getString("telefone"),
                dados.getString("senha")   
            );
            return obj;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
@Override
public boolean Salvar(Funcionario obj) {
       long id = obj.getId();
       if(id == 0){

           try {
               String pegaid = "select max(idEndereco) from enderecos";

               PreparedStatement consultaid = BD.getConexao().prepareStatement(pegaid);
               ResultSet retorno = consultaid.executeQuery();

               retorno.next();
               id = retorno.getLong(1);
               
               
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       }else{
           try {
                String sql = consultaUpdate();
                PreparedStatement consulta = BD.getConexao().prepareStatement(sql);
                this.carregaParametros(obj, consulta);
                consulta.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        return false;
  }
}
