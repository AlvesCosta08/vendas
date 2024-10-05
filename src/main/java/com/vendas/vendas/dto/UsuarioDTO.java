package com.vendas.vendas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {
    private Long idUsuario;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Tipo de Role é obrigatório")
    private String tipoRole;

    private Boolean ativo;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    public UsuarioDTO() {}

    public UsuarioDTO(Long idUsuario, String nome, String email, String senha, String tipoRole, Boolean ativo) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha; // Novo campo
        this.tipoRole = tipoRole;
        this.ativo = ativo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getTipoRole() {
        return tipoRole;
    }

    public void setTipoRole(String tipoRole) {
        this.tipoRole = tipoRole;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
