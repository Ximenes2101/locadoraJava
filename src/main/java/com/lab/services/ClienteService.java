package com.lab.services;

import com.lab.domains.Cliente;
import com.lab.domains.dtos.ClienteDTO;
import com.lab.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }


    public Cliente findById(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }


    public Optional<Cliente> findByCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return cliente;
    }


    public Cliente create(ClienteDTO dto) {

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(dto.getEndereco());
        cliente.setTelefone(dto.getTelefone());


        return clienteRepository.save(cliente);
    }


    public Cliente update(Integer id, ClienteDTO dto) {

        Cliente cliente = findById(id);

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(dto.getEndereco());
        cliente.setTelefone(dto.getTelefone());


        return clienteRepository.save(cliente);
    }


    public void delete(Integer id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }
}
