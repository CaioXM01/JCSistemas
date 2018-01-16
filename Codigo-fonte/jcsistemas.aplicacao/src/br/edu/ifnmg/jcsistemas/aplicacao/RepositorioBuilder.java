/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 *
 * @author victor
 */
public class RepositorioBuilder {
    private static InputStream arquivo;
    private static Properties prop;
  
    
 static{
        try{
           arquivo = RepositorioBuilder.class.getResourceAsStream("/config.properties");
           prop = new Properties();
           prop.load(arquivo);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        }
 private static ClienteRepositorio cliente;
    
    public static ClienteRepositorio getClienteRepositorio(){
        
        if(cliente == null){
         
            try {    
                // Carrega a classe
                  Class obj = Class.forName(prop.getProperty("ClienteRepositorio"));
            
                  cliente = (ClienteRepositorio)obj.newInstance();
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }   
            catch (InstantiationException | IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
           
        }
        return cliente;
    }
    
        //Endereco
    private static EnderecoRepositorio endereco;
    
    public static EnderecoRepositorio getEnderecoRepositorio(){
        
        if(endereco == null){
         
            try {    
                // Carrega a classe
                  Class obj = Class.forName(prop.getProperty("EnderecoRepositorio"));
            
                  endereco = (EnderecoRepositorio)obj.newInstance();
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }   
            catch (InstantiationException | IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
           
        }
        return endereco;
    }
    
    
    
    //Fornecedor
    private static FornecedorRepositorio fornecedor;
    
    public static FornecedorRepositorio getFornecedorRepositorio(){
        
        if(fornecedor == null){
         
            try {    
                // Carrega a classe
                  Class obj = Class.forName(prop.getProperty("FornecedorRepositorio"));
            
                  fornecedor = (FornecedorRepositorio)obj.newInstance();
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }   
            catch (InstantiationException | IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
           
        }
        return fornecedor;
    }
    
    
    
     //Funcionario
    private static FuncionarioRepositorio funcionario;
    
    public static FuncionarioRepositorio getFuncionarioRepositorio(){
        
        if(funcionario == null){
         
            try {    
                // Carrega a classe
                  Class obj = Class.forName(prop.getProperty("FuncionarioRepositorio"));
            
                  funcionario = (FuncionarioRepositorio)obj.newInstance();
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }   
            catch (InstantiationException | IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(RepositorioBuilder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
           
        }
        return funcionario;
    }
 
}
