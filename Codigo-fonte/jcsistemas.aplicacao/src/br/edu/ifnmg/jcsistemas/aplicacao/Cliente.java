/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.util.Date;


public class Cliente extends PessoaFisica {

    public Cliente(){
        
    }

    public Cliente(String cpf, String rg, long id, String nome, String registro, String cadastro, String tipo, String relacao, String email, String telefone, Date nascimento, long endereco) {
        super(cpf, rg, id, nome, registro, cadastro, tipo, relacao, email, telefone, nascimento, endereco);
    }
    

    public Cliente(String string, String string0, long aLong, String string1, java.sql.Date date, long aLong0, String string2, String string3) {

    }
    
}
