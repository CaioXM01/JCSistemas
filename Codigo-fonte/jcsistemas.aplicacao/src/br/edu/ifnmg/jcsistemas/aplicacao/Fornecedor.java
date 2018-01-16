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
public class Fornecedor extends PessoaJuridica {
    public Fornecedor(){}
    public Fornecedor(String cnpj, String inscriEstadual, String nome,  Date nascimento, long endereco, long id, String email, String telefone) {
        super(cnpj, inscriEstadual, nome, nascimento, endereco, id, email, telefone);
    }
    
}
