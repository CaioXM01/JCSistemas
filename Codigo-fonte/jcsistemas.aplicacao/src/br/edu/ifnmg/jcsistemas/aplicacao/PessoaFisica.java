/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.jcsistemas.aplicacao;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author victor
 */
public class PessoaFisica extends Pessoa implements Entidade{
    private String cpf, rg;
    private static Pattern regex_cpf = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");

    public PessoaFisica() {
        
    }


    public PessoaFisica(String cpf, String rg, long id, String nome, String registro, String cadastro, String tipo, String relacao, String email, String telefone, Date nascimento, long endereco) {
        super(id, nome, registro, cadastro, tipo, relacao, email, telefone, nascimento, endereco);
        this.cpf = cpf;
        this.rg = rg;
    }
    
  
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ViolacaoRegraNegocioException {
        Matcher verificador = regex_cpf.matcher(cpf);
       if(cpf == null || cpf.isEmpty() || ! verificador.matches())
           throw new ViolacaoRegraNegocioException("O CPF deve estar no formato ###.###.###-##!");
       this.cpf = cpf.replace(".", "").replace("-", "");
    }
    public void setCpfSimples(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", rg=" + rg + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cpf);
        hash = 59 * hash + Objects.hashCode(this.rg);
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
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }

}
