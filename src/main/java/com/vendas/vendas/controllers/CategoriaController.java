package com.vendas.vendas.controllers;

import com.vendas.vendas.models.Categoria;
import com.vendas.vendas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        Categoria createdCategoria = categoriaService.create(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> read(@PathVariable Long id) {
        return categoriaService.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> readAll() {
        List<Categoria> categorias = categoriaService.readAll();
        return ResponseEntity.ok(categorias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria updatedCategoria = categoriaService.update(id, categoria);
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
