package com.vendas.vendas.utils;

import com.vendas.vendas.exceptions.UsuarioAlreadyExistsException;
import com.vendas.vendas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void verificarEmailDuplicado(String novoEmail) {
        if (usuarioRepository.findByEmail(novoEmail).isPresent()) {
            throw new UsuarioAlreadyExistsException("O e-mail " + novoEmail + " já está em uso.");
        }
    }

    public void verificarEmailDuplicado(String novoEmail, String emailAtual) {
        if (!novoEmail.equals(emailAtual) && usuarioRepository.findByEmail(novoEmail).isPresent()) {
            throw new UsuarioAlreadyExistsException("O e-mail " + novoEmail + " já está em uso.");
        }
    }
}
