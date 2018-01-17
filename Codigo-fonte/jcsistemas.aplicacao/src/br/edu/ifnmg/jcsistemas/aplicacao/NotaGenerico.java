/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author caio
 */
public class NotaGenerico {
    private long id; 
    private int parcelas;
    private ArrayList<NotaItem> itens;
    private String descricao, metodo;
    private BigDecimal valorTotal, jurus;
    private Date dataVenda, dataEmissao, dataQuite;

    public NotaGenerico() {
        
    }

    
  
    public NotaGenerico(long id, int parcelas, ArrayList<NotaItem> itens, String descricao, String metodo, BigDecimal valorTotal, BigDecimal jurus, Date dataVenda, Date dataEmissao, Date dataQuite) {
        this.id = 0;
        this.parcelas = 0;
        this.itens = new ArrayList<>();
        this.descricao = "";
        this.metodo = "";
        this.valorTotal = new BigDecimal("0.00");
        this.jurus = new BigDecimal("0.00");
        this.dataVenda = new Date();
        this.dataEmissao = new Date();
        this.dataQuite = new Date();
    }

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public ArrayList<NotaItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<NotaItem> itens) {
        this.itens = itens;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getJurus() {
        return jurus;
    }

    public void setJurus(BigDecimal jurus) {
        this.jurus = jurus;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataQuite() {
        return dataQuite;
    }

    public void setDataQuite(Date dataQuite) {
        this.dataQuite = dataQuite;
    }
    
    
    
     public void addItem(NotaItem item){
        if(!this.itens.contains(item)){
            item.setVenda((NotaVenda) this);
            itens.add(item);
            this.valorTotal = this.valorTotal.add(item.getValorTotal());
        }
    }
    
    public void removeItem(NotaItem item){
        if(this.itens.contains(item)){
            itens.remove(item);
            this.valorTotal = this.valorTotal.subtract(item.getValorTotal());
        }
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + Objects.hashCode(this.descricao);
        hash = 61 * hash + Objects.hashCode(this.metodo);
        hash = 61 * hash + Objects.hashCode(this.valorTotal);
        hash = 61 * hash + Objects.hashCode(this.dataVenda);
        hash = 61 * hash + Objects.hashCode(this.dataEmissao);
        hash = 61 * hash + Objects.hashCode(this.dataQuite);
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
        final NotaGenerico other = (NotaGenerico) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.metodo, other.metodo)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        if (!Objects.equals(this.dataEmissao, other.dataEmissao)) {
            return false;
        }
        if (!Objects.equals(this.dataQuite, other.dataQuite)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaGenerico{" + "id=" + id + ", parcelas=" + parcelas + ", itens=" + itens + ", descricao=" + descricao + ", metodo=" + metodo + ", valorTotal=" + valorTotal + ", jurus=" + jurus + ", dataVenda=" + dataVenda + ", dataEmissao=" + dataEmissao + ", dataQuite=" + dataQuite + '}';
    }

   
    
    

}
