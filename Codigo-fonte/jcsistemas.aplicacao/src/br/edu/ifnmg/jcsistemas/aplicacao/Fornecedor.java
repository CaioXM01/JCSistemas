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

    public Fornecedor(String cnpj, String inscriEstadual, String nome, String relacao, Date nascimento, Long endereco) {
        super(cnpj, inscriEstadual, nome, "fornecedor", nascimento, endereco);
    }
    
}
