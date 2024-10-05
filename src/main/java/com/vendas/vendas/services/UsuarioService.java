package com.vendas.vendas.services;

import com.vendas.vendas.dto.UsuarioDTO;
import com.vendas.vendas.exceptions.UsuarioNotFoundException;
import com.vendas.vendas.models.Usuario;
import com.vendas.vendas.repository.UsuarioRepository;
import com.vendas.vendas.utils.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;
    private final UsuarioValidator usuarioValidator;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,
                          PasswordService passwordService,
                          UsuarioValidator usuarioValidator) {
        this.usuarioRepository = usuarioRepository;
        this.passwordService = passwordService;
        this.usuarioValidator = usuarioValidator;
    }

    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        // Verifica se o e-mail já está cadastrado
        usuarioValidator.verificarEmailDuplicado(usuarioDTO.getEmail());


        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTipoRole(usuarioDTO.getTipoRole());
        usuario.setSenha(passwordService.hashPassword(usuarioDTO.getSenha()));
        usuario.setAtivo(true);
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setDataAtualizacao(LocalDateTime.now());

        usuario = usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), null, usuario.getTipoRole(), usuario.getAtivo());

    }


    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário com ID " + idUsuario + " não encontrado."));
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário com e-mail " + email + " não encontrado."));
    }

    public Usuario atualizarUsuario(Long idUsuario, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(idUsuario);
        usuarioValidator.verificarEmailDuplicado(usuarioAtualizado.getEmail(), usuario.getEmail());

        if (usuarioAtualizado.getSenha() != null && !usuarioAtualizado.getSenha().isEmpty()) {
            usuario.setSenha(passwordService.hashPassword(usuarioAtualizado.getSenha()));
        }

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setTipoRole(usuarioAtualizado.getTipoRole());
        usuario.setAtivo(usuarioAtualizado.getAtivo());
        usuario.setDataAtualizacao(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long idUsuario) {
        Usuario usuario = buscarPorId(idUsuario);
        usuarioRepository.deleteById(idUsuario);
    }
}
