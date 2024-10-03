package com.vendas.vendas.services;

import com.vendas.vendas.exceptions.ResourceNotFoundException;
import com.vendas.vendas.models.Pedido;
import com.vendas.vendas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> read(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> readAll() {
        return pedidoRepository.findAll();
    }

    public Pedido update(Long id, Pedido pedido) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
    }
}
