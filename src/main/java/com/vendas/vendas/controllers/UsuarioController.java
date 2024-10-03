package com.vendas.vendas.controllers;

import com.vendas.vendas.exceptions.UsuarioAlreadyExistsException;
import com.vendas.vendas.exceptions.UsuarioNotFoundException;
import com.vendas.vendas.models.Usuario;
import com.vendas.vendas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
        } catch (UsuarioAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String email) {
        try {
            Usuario usuario = usuarioService.buscarPorEmail(email).orElseThrow(
                    () -> new UsuarioNotFoundException("Usuário com email " + email + " não foi encontrado.")
            );
            return ResponseEntity.ok(usuario);
        } catch (UsuarioNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
