package com.vendas.vendas.controllers;

import com.vendas.vendas.models.PedidoProduto;
import com.vendas.vendas.services.PedidoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido-produtos")
public class PedidoProdutoController {

    @Autowired
    private PedidoProdutoService pedidoProdutoService;

    @PostMapping
    public ResponseEntity<PedidoProduto> create(@RequestBody PedidoProduto pedidoProduto) {
        PedidoProduto createdPedidoProduto = pedidoProdutoService.create(pedidoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedidoProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoProduto> read(@PathVariable Long id) {
        return pedidoProdutoService.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PedidoProduto>> readAll() {
        List<PedidoProduto> pedidoProdutos = pedidoProdutoService.readAll();
        return ResponseEntity.ok(pedidoProdutos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoProduto> update(@PathVariable Long id, @RequestBody PedidoProduto pedidoProduto) {
        PedidoProduto updatedPedidoProduto = pedidoProdutoService.update(id, pedidoProduto);
        return ResponseEntity.ok(updatedPedidoProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
