package com.vendas.vendas.exceptions;

public class EnderecoNotFoundException extends RuntimeException {
    public EnderecoNotFoundException(Long id) {
        super("Endereço não encontrado com o id: " + id);
    }
}
