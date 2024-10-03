package com.vendas.vendas.repository;

import com.vendas.vendas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método para encontrar Pessoa Física pelo CPF
    Optional<Cliente> findByCpf(String cpf);

    // Método para encontrar Pessoa Jurídica pelo CNPJ
    Optional<Cliente> findByCnpj(String cnpj);
}
