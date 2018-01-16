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
    private String cargo, senha;
    private Double salario;

    public Funcionario(String cargo, Double salario, String cpf, String rg, long id, String nome, Date nascimento, long endereco, String email, String telefone, String senha) {
        super(cpf, rg, id, nome, nascimento, endereco, email, telefone);
        this.cargo = cargo;
        this.salario = salario;
        this.senha = senha;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cargo=" + cargo + ", salario=" + salario + '}';
    }
    
    
}
