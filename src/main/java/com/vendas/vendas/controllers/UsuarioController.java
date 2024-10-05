package com.vendas.vendas.controllers;

import com.vendas.vendas.dto.UsuarioDTO;
import com.vendas.vendas.models.Usuario;
import com.vendas.vendas.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(); // Cria um novo objeto Usuario a partir do DTO
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTipoRole(usuarioDTO.getTipoRole());
        // A senha não deve ser definida aqui, deve ser gerenciada no serviço.

        Usuario usuarioSalvo = usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<>(converterParaDTO(usuarioSalvo), HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioService.buscarPorId(idUsuario);
        return new ResponseEntity<>(converterParaDTO(usuario), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> buscarPorEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        return new ResponseEntity<>(converterParaDTO(usuario), HttpStatus.OK);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(
            @PathVariable Long idUsuario,
            @Valid @RequestBody UsuarioDTO usuarioAtualizadoDTO) {

        Usuario usuarioAtualizado = new Usuario();
        usuarioAtualizado.setNome(usuarioAtualizadoDTO.getNome());
        usuarioAtualizado.setEmail(usuarioAtualizadoDTO.getEmail());
        usuarioAtualizado.setTipoRole(usuarioAtualizadoDTO.getTipoRole());
        usuarioAtualizado.setAtivo(usuarioAtualizadoDTO.getAtivo());
        // A senha deve ser gerenciada no serviço.

        Usuario usuario = usuarioService.atualizarUsuario(idUsuario, usuarioAtualizado);
        return new ResponseEntity<>(converterParaDTO(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long idUsuario) {
        usuarioService.deletarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

    // Método auxiliar para converter Usuario em UsuarioDTO
    private UsuarioDTO converterParaDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoRole(),
                usuario.getAtivo()
        );
    }
}
