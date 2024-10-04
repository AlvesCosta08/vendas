package com.vendas.vendas.dto;


public class AuthRequestDTO {

    private String username;
    private String password;

    // Construtor padrão
    public AuthRequestDTO() {
    }

    // Construtor com argumentos
    public AuthRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Implementação manual do padrão Builder
    public static Builder builder() {
        return new Builder();
    }

    // Classe Builder
    public static class Builder {
        private String username;
        private String password;

        public Builder() {
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public AuthRequestDTO build() {
            return new AuthRequestDTO(username, password);
        }
    }
}




