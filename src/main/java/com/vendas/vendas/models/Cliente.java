package com.vendas.vendas.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Usa uma única tabela para os dois tipos
@DiscriminatorColumn(name = "tipo_cliente") // Coluna para discriminar Pessoa Física e Jurídica
@Table(name = "cliente")
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "fk_cliente_endereco"))
    private Endereco endereco; // Referência ao endereço

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String telefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco; // Inicializa a referência ao endereço
    }

    // Getters e Setters comuns
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco; // Getter para o endereço
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco; // Setter para o endereço
    }
}


