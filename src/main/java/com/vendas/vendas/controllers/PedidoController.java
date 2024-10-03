package com.vendas.vendas.controllers;

import com.vendas.vendas.models.Pedido;
import com.vendas.vendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
        Pedido createdPedido = pedidoService.create(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> read(@PathVariable Long id) {
        return pedidoService.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> readAll() {
        List<Pedido> pedidos = pedidoService.readAll();
        return ResponseEntity.ok(pedidos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido updatedPedido = pedidoService.update(id, pedido);
        return ResponseEntity.ok(updatedPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
