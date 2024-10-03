package com.vendas.vendas.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Cliente {

    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {
        super(id, nome, email, telefone, endereco); // Passa o endereço para a superclasse
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
