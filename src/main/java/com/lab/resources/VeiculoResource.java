package com.lab.resources;

import com.lab.domains.Veiculo;
import com.lab.domains.dtos.VeiculoDTO;
import com.lab.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;


    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        List<Veiculo> veiculos = veiculoService.findAll();
        List<VeiculoDTO> veiculoDTOs = veiculos.stream().map(VeiculoDTO::new).toList();
        return ResponseEntity.ok().body(veiculoDTOs);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.findById(id);
        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }


    @GetMapping(value = "/placa/{placa}")
    public ResponseEntity<VeiculoDTO> findByPlaca(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.findByPlaca(placa);
        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }


    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody VeiculoDTO dto) {
        Veiculo veiculo = veiculoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Integer id, @Valid @RequestBody VeiculoDTO dto) {
        Veiculo veiculo = veiculoService.update(id, dto);
        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
