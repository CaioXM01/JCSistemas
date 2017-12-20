/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.math.BigDecimal;

/**
 *
 * @author victor
 */
public class Produto extends ProdutoGenerico implements Entidade{
    private BigDecimal valorCusto;
    private long percentualLucro, estoque;

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
    
    
}
