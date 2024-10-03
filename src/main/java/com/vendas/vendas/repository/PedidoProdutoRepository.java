package com.vendas.vendas.repository;

import com.vendas.vendas.models.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {
    // Métodos adicionais podem ser definidos aqui
}
