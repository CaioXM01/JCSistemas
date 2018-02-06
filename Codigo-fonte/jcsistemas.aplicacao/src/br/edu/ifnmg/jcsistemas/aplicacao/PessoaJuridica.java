/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author victor
 */
public class PessoaJuridica extends Pessoa implements Entidade{
    private String cnpj, inscriEstadual;
    public PessoaJuridica(){}
    public PessoaJuridica(String cnpj, String inscriEstadual, String nome, Date nascimento, long endereco, long id, String email, String telefone) {
        super(nome, nascimento, endereco, id, email, telefone);
        this.cnpj = cnpj;
        this.inscriEstadual = inscriEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscriEstadual() {
        return inscriEstadual;
    }

    public void setInscriEstadual(String inscriEstadual) {
        this.inscriEstadual = inscriEstadual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cnpj);
        hash = 97 * hash + Objects.hashCode(this.inscriEstadual);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.inscriEstadual, other.inscriEstadual)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.getNome() + " CNPJ: " + cnpj + "     Insc. Estadual: " + inscriEstadual;
    }
    
    
    
}
