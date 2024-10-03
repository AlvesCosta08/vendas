package com.vendas.vendas.controllers;

import com.vendas.vendas.models.Produto;
import com.vendas.vendas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        Produto createdProduto = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> read(@PathVariable Long id) {
        return produtoService.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Produto>> readAll() {
        List<Produto> produtos = produtoService.readAll();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        Produto updatedProduto = produtoService.update(id, produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
