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
public class Produto extends ProdutoGenerico implements Entidade{
    private BigDecimal valorCusto;
    private long percentualLucro, estoque;
    
    public Produto(){
    
    }

    public Produto(BigDecimal valorCusto, long percentualLucro, long estoque, long id, BigDecimal valorVenda, String nome, String descricao, String tipo) {
        super(id, valorVenda, nome, descricao, tipo);
        this.valorCusto = valorCusto;
        this.percentualLucro = percentualLucro;
        this.estoque = estoque;
    }

    public BigDecimal getValorCusto() {
        return valorCusto;
    }
    
    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }

    public long getPercentualLucro() {
        return percentualLucro;
    }

    public void setPercentualLucro(long percentualLucro) {
        this.percentualLucro = percentualLucro;
    }

    public long getEstoque() {
        return estoque;
    }

    public void setEstoque(long estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" + "valorCusto=" + valorCusto + ", percentualLucro=" + percentualLucro + ", estoque=" + estoque + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.valorCusto);
        hash = 29 * hash + (int) (this.percentualLucro ^ (this.percentualLucro >>> 32));
        hash = 29 * hash + (int) (this.estoque ^ (this.estoque >>> 32));
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
        final Produto other = (Produto) obj;
        if (this.percentualLucro != other.percentualLucro) {
            return false;
        }
        if (this.estoque != other.estoque) {
            return false;
        }
        if (!Objects.equals(this.valorCusto, other.valorCusto)) {
            return false;
        }
        return true;
    }
    
    
}
