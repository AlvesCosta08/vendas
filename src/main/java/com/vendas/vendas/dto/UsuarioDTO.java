package com.vendas.vendas.dto;

public class UsuarioDTO {

    private Long idUsuario;
    private String nome;
    private String email;
    private String tipoRole;
    private Boolean ativo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long idUsuario, String nome, String email, String tipoRole, Boolean ativo) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
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
}
