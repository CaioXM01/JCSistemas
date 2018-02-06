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


public class NotaCompra extends NotaGenerico implements Entidade {
    
    private Fornecedor fornecedor;

     public NotaCompra() {
        
    }
      public NotaCompra(String generic) {
          super("generic");
        
    }
     
    public NotaCompra(Fornecedor fornecedor, long id, int parcelas, ArrayList itens, String descricao, String metodo, BigDecimal valorTotal, BigDecimal jurus, Date dataVenda, Date dataEmissao, Date dataQuite) {
        super(id, parcelas, itens, descricao, metodo, valorTotal, jurus, dataVenda, dataEmissao, dataQuite);
        this.fornecedor = fornecedor;
    }

   

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final NotaCompra other = (NotaCompra) obj;
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaCompra{" + "forncedor=" + fornecedor + '}';
    }

   
    
}
