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


public class NotaVenda extends NotaGenerico implements Entidade {
    
    private Cliente cliente;

     public NotaVenda() {
        
    }
     
    public NotaVenda(Cliente cliente, long id, int parcelas, ArrayList itens, String descricao, String metodo, BigDecimal valorTotal, BigDecimal jurus, Date dataVenda, Date dataEmissao, Date dataQuite) {
        super(id, parcelas, itens, descricao, metodo, valorTotal, jurus, dataVenda, dataEmissao, dataQuite);
        this.cliente = cliente;
    }

   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        final NotaVenda other = (NotaVenda) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NotaVenda{" + "cliente=" + cliente + '}';
    }

   
    
}
