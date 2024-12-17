package com.lab.repositories;

import com.lab.domains.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface    CategoriaRepository extends JpaRepository<Categoria, Integer>{

    Optional<Categoria> findById(Integer id);
    Optional<Categoria> findByNome(String nome);
    Optional<Categoria> findByDescricao(String descricao);

}
