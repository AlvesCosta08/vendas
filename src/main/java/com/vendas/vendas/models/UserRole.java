package com.vendas.vendas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mudança de AUTO para IDENTITY
    @Column(name = "id") // Ajustando para corresponder à coluna
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public UserRole() {
    }

    public UserRole(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
