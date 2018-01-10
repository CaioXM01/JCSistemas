/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.util.Date;
import java.util.regex.Pattern;
import java.util.Objects;


/**
 *
 * @author victor
 */
public class Pessoa {
    private long id;
    private String nome, registro, cadastro, tipo, relacao;
    private Date nascimento;
    private long endereco;
    public Pessoa(){}
    public Pessoa(String nome, String registro, String cadastro, String tipo, String relacao, Date nascimento, Long endereco) {
        this.nome = nome;
        this.registro = registro;
        this.cadastro = cadastro;
        this.tipo = tipo;
        this.relacao = relacao;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Long getEndereco() {
        return endereco;
    }

    public void setEndereco(Long endereco) {
        this.endereco = endereco;
    }
    
}
