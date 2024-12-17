package com.lab.services;

import com.lab.domains.Locacao;
import com.lab.repositories.LocacaoRepository;
import com.lab.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<Locacao> findAll() {
        return locacaoRepository.findAll();
    }

    public Locacao findById(Integer id) {
        Optional<Locacao> obj = locacaoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Locação não encontrada! ID: " + id));
    }

    public Locacao create(Locacao obj) {
        obj.setId(null);
        return locacaoRepository.save(obj);
    }

    public Locacao update(Integer id, Locacao obj) {
        Locacao existingLocacao = findById(id);
        existingLocacao.setDataInicio(obj.getDataInicio());
        existingLocacao.setDataFim(obj.getDataFim());
        existingLocacao.setValorTotal(obj.getValorTotal());
        return locacaoRepository.save(existingLocacao);
    }

    public void delete(Integer id) {
        findById(id);
        locacaoRepository.deleteById(id);
    }
}
