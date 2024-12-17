package com.lab.repositories;

import com.lab.domains.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    Optional<Cliente> findById(Integer id);

    Optional<Cliente> findByCpf(String cpf);


}
