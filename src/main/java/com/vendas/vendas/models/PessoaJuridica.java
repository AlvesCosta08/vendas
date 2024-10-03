package com.vendas.vendas.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Cliente {

    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    @Column(name = "inscricao_estadual", length = 20)
    private String inscricaoEstadual;

    @Column(name = "nome_fantasia", nullable = false, length = 100)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 150)
    private String razaoSocial;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long id, String nome, String email, String telefone, String cnpj,
                          String inscricaoEstadual, String nomeFantasia, String razaoSocial, Endereco endereco) {
        super(id, nome, email, telefone, endereco); // Passa o endereço para a superclasse
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
