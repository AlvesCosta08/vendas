package com.vendas.vendas.services;

import com.vendas.vendas.exceptions.ResourceNotFoundException;
import com.vendas.vendas.models.PedidoProduto;
import com.vendas.vendas.repository.PedidoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoProdutoService {

    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    public PedidoProduto create(PedidoProduto pedidoProduto) {
        return pedidoProdutoRepository.save(pedidoProduto);
    }

    public Optional<PedidoProduto> read(Long id) {
        return pedidoProdutoRepository.findById(id);
    }

    public List<PedidoProduto> readAll() {
        return pedidoProdutoRepository.findAll();
    }

    public PedidoProduto update(Long id, PedidoProduto pedidoProduto) {
        if (!pedidoProdutoRepository.existsById(id)) {
            throw new ResourceNotFoundException("PedidoProduto não encontrado");
        }
        pedidoProduto.setId(id);
        return pedidoProdutoRepository.save(pedidoProduto);
    }

    public void delete(Long id) {
        if (!pedidoProdutoRepository.existsById(id)) {
            throw new ResourceNotFoundException("PedidoProduto não encontrado");
        }
        pedidoProdutoRepository.deleteById(id);
    }
}
