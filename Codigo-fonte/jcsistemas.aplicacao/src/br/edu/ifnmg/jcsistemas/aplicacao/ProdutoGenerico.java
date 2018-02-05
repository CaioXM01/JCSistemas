/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author victor
 */
public class ProdutoGenerico {
    private long id;
    private BigDecimal valorVenda;
    private String nome, descricao, tipo;
    
    public ProdutoGenerico(){
    
    }

    public ProdutoGenerico(long id, BigDecimal valorVenda, String nome, String descricao, String tipo) {
        this.id = id;
        this.valorVenda = valorVenda;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ProdutoGenerico{" + "id=" + id + ", valorVenda=" + valorVenda + ", nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.valorVenda);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoGenerico other = (ProdutoGenerico) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.valorVenda, other.valorVenda)) {
            return false;
        }
        return true;
    }
    
}
