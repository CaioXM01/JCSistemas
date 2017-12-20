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
public class Funcionario extends PessoaFisica{
    private String funcao;
    private Double salario;

    public Funcionario(String funcao, Double salario, String cpf, String rg, long id, String nome, Date nascimento, Long endereco) {
        super(cpf, rg, id, nome, "funcionario", nascimento, endereco);
        this.funcao = funcao;
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "funcao=" + funcao + ", salario=" + salario + '}';
    }
    
    
}
