package com.lab.services;

import com.lab.domains.Funcionario;
import com.lab.repositories.FuncionarioRepository;
import com.lab.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Integer id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado! ID: " + id));
    }

    public Funcionario findByCpf(String cpf) {
        Optional<Funcionario> obj = funcionarioRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado! CPF: " + cpf));
    }

    public Funcionario create(Funcionario obj) {
        obj.setId(null);
        return funcionarioRepository.save(obj);
    }

    public Funcionario update(Integer id, Funcionario obj) {
        Funcionario existingFuncionario = findById(id);
        existingFuncionario.setNome(obj.getNome());
        existingFuncionario.setSalario(obj.getSalario());
        existingFuncionario.setCpf(obj.getCpf());
        return funcionarioRepository.save(existingFuncionario);
    }

    public void delete(Integer id) {
        findById(id);
        funcionarioRepository.deleteById(id);
    }
}
