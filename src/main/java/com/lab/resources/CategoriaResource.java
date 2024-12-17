package com.lab.resources;

import com.lab.domains.dtos.CategoriaDTO;
import com.lab.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {

        List<CategoriaDTO> categoriaDTOs = categoriaService.findAll()
                .stream()
                .map(CategoriaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(categoriaDTOs);
    }
}
