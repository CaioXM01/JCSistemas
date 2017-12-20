/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.util.Date;

/**
 *
 * @author victor
 */
public class Cliente extends PessoaFisica{
    
    public Cliente(String cpf, String rg, long id, String nome, Date nascimento, Long endereco) {
        super(cpf, rg, id, nome, "cliente", nascimento, endereco);
    }
    
}
