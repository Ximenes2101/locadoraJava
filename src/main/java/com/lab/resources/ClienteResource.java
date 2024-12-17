package com.lab.resources;

import com.lab.domains.Cliente;
import com.lab.domains.dtos.ClienteDTO;
import com.lab.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {

        List<ClienteDTO> list = clienteService.findAll().stream()
                .map(ClienteDTO::new)  //
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    // Retorna um ClienteDTO por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDTO(obj));  // Retorna o DTO do Cliente
    }

    //
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<ClienteDTO> findByCpf(@PathVariable String cpf) {
        Optional<Cliente> obj = clienteService.findByCpf(cpf);
        return ResponseEntity.ok().body(new ClienteDTO(obj));  // Retorna o DTO do Cliente
    }


    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = clienteService.create(dto);  // Cria o Cliente a partir do DTO
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();  // Retorna a URI do novo Cliente criado
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO dto) {
        Cliente obj = clienteService.update(id, dto);  // Atualiza o Cliente com os dados do DTO
        return ResponseEntity.ok().body(new ClienteDTO(obj));  // Retorna o DTO atualizado
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
