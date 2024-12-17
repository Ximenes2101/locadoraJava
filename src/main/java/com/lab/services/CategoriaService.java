package com.lab.services;

import com.lab.domains.Categoria;
import com.lab.repositories.CategoriaRepository;
import com.lab.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! ID: " + id));
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Integer id, Categoria obj) {
        Categoria existingCategoria = findById(id);
        existingCategoria.setNome(obj.getNome());
        existingCategoria.setDescricao(obj.getDescricao());
        return categoriaRepository.save(existingCategoria);
    }

    public void delete(Integer id) {
        findById(id);
        categoriaRepository.deleteById(id);
    }
}
