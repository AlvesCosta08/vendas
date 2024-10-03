package com.vendas.vendas.services;

import com.vendas.vendas.exceptions.ClienteNotFoundException;
import com.vendas.vendas.models.Cliente;
import com.vendas.vendas.models.Endereco;
import com.vendas.vendas.models.PessoaFisica;
import com.vendas.vendas.models.PessoaJuridica;
import com.vendas.vendas.repository.ClienteRepository;
import com.vendas.vendas.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public Cliente criarCliente(Cliente cliente, Endereco endereco) {
        validarCliente(cliente);
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        cliente.setEndereco(enderecoSalvo);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException(id);
        }
        validarCliente(clienteAtualizado);
        clienteAtualizado.setId(id);
        return clienteRepository.save(clienteAtualizado);
    }

    @Transactional
    public void removerCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException(id);
        }
        clienteRepository.deleteById(id);
    }

    private void validarCliente(Cliente cliente) {
        if (cliente instanceof PessoaFisica) {
            validarCpf((PessoaFisica) cliente);
        } else if (cliente instanceof PessoaJuridica) {
            validarCnpj((PessoaJuridica) cliente);
        }
    }

    private void validarCpf(PessoaFisica pessoaFisica) {
        String cpf = pessoaFisica.getCpf();
        if (clienteRepository.findByCpf(cpf).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado: " + cpf);
        }
        // Aqui você pode adicionar a lógica para validar o formato do CPF
        // Exemplo: validarFormatoCpf(cpf);
    }

    private void validarCnpj(PessoaJuridica pessoaJuridica) {
        String cnpj = pessoaJuridica.getCnpj();
        if (clienteRepository.findByCnpj(cnpj).isPresent()) {
            throw new IllegalArgumentException("CNPJ já cadastrado: " + cnpj);
        }
        // Aqui você pode adicionar a lógica para validar o formato do CNPJ
        // Exemplo: validarFormatoCnpj(cnpj);
    }
}
