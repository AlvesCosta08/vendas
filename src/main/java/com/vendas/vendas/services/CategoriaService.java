package com.vendas.vendas.services;

import com.vendas.vendas.exceptions.ResourceNotFoundException;
import com.vendas.vendas.models.Categoria;
import com.vendas.vendas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria> read(Long id) {
        return categoriaRepository.findById(id);
    }

    public List<Categoria> readAll() {
        return categoriaRepository.findAll();
    }

    public Categoria update(Long id, Categoria categoria) {
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        categoria.setIdCategoria(id);
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        categoriaRepository.deleteById(id);
    }
}
