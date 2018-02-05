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
public class Servico extends ProdutoGenerico implements Entidade{
   private String tipoServico;

   public Servico() {
    }

    public Servico(String tipoServico, long id, BigDecimal valorVenda, String nome, String descricao, String tipo) {
        super(id, valorVenda, nome, descricao, "servico");
        this.tipoServico = tipoServico;
    }

    
    
    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.tipoServico);
        return hash;
    }

    @Override
    public String toString() {
        return "Servico{" + "tipoServico=" + tipoServico + '}';
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.tipoServico, other.tipoServico)) {
            return false;
        }
        return true;
    }
   
}
