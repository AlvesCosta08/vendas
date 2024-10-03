package com.vendas.vendas.exceptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
