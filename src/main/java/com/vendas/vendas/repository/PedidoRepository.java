package com.vendas.vendas.repository;

import com.vendas.vendas.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Métodos adicionais podem ser definidos aqui
}
