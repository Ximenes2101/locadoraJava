package com.lab.repositories;

import com.lab.domains.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    Optional<Veiculo> findById(Integer id);

    Optional<Veiculo> findByPlaca(String placa);


}
