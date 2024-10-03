package com.vendas.vendas.services;

import com.vendas.vendas.exceptions.ResourceNotFoundException;
import com.vendas.vendas.models.Produto;
import com.vendas.vendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> read(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> readAll() {
        return produtoRepository.findAll();
    }

    public Produto update(Long id, Produto produto) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
