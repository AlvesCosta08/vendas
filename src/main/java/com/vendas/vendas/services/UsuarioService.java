package com.vendas.vendas.services;

import com.vendas.vendas.exceptions.UsuarioAlreadyExistsException;
import com.vendas.vendas.exceptions.UsuarioNotFoundException;
import com.vendas.vendas.models.Usuario;
import com.vendas.vendas.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioAlreadyExistsException("Usuário com email " + usuario.getEmail() + " já existe.");
        }
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário com email " + email + " não foi encontrado.")));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException("Usuário com ID " + id + " não foi encontrado.");
        }
        usuarioRepository.deleteById(id);
    }
}
