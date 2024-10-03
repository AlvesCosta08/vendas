package com.vendas.vendas.controllers;

import com.vendas.vendas.exceptions.UsuarioAlreadyExistsException;
import com.vendas.vendas.exceptions.UsuarioNotFoundException;
import com.vendas.vendas.models.Usuario;
import com.vendas.vendas.services.JwtService;
import com.vendas.vendas.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (UsuarioAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor.");
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> loginUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getSenha());
            String token = jwtService.generateToken(String.valueOf(usuarioAutenticado));
            return ResponseEntity.ok(token);
        } catch (UsuarioNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
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
