package com.lab.services;

import com.lab.domains.Veiculo;
import com.lab.domains.dtos.VeiculoDTO;
import com.lab.domains.enums.StatusVeiculo;
import com.lab.repositories.VeiculoRepository;
import com.lab.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Retorna todos os veículos
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    // Retorna um veículo por ID
    public Veiculo findById(Integer id) {
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo não encontrado! ID: " + id));
    }

    // Retorna um veículo por Placa
    public Veiculo findByPlaca(String placa) {
        Optional<Veiculo> obj = veiculoRepository.findByPlaca(placa);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo não encontrado! Placa: " + placa));
    }

    // Cria um novo veículo a partir de um VeiculoDTO
    public Veiculo create(VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setMarca(dto.getMarca());
        veiculo.setAno(dto.getAno());
        veiculo.setCategoria(dto.getCategoria());
        veiculo.setPlaca(dto.getPlaca());


        veiculo.setStatus(StatusVeiculo.fromId(dto.getStatus()));

        return veiculoRepository.save(veiculo);
    }


    public Veiculo update(Integer id, VeiculoDTO dto) {
        Veiculo veiculo = findById(id);

        veiculo.setModelo(dto.getModelo());
        veiculo.setMarca(dto.getMarca());
        veiculo.setAno(dto.getAno());
        veiculo.setCategoria(dto.getCategoria());
        veiculo.setPlaca(dto.getPlaca());


        veiculo.setStatus(StatusVeiculo.fromId(dto.getStatus()));

        return veiculoRepository.save(veiculo);
    }


    public void delete(Integer id) {
        findById(id);
        veiculoRepository.deleteById(id);
    }
}
