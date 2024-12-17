package com.lab.repositories;

import com.lab.domains.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {


    Optional<Funcionario> findByCpf(String cpf);

}
