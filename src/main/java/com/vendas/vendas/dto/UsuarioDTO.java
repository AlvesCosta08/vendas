package com.vendas.vendas.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {
    private Long idUsuario;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
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
        this.tipoRole = tipoRole;
        this.ativo = ativo;
        this.senha = senha;  // Atribuindo senha
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Email é obrigatório") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Tipo de Role é obrigatório") String getTipoRole() {
        return tipoRole;
    }

    public void setTipoRole(@NotBlank(message = "Tipo de Role é obrigatório") String tipoRole) {
        this.tipoRole = tipoRole;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public @NotBlank(message = "Senha é obrigatória") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatória") String senha) {
        this.senha = senha;
    }
}
