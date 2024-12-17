package com.lab.repositories;

import com.lab.domains.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {

    Optional<Locacao> findById(Integer id);

}
