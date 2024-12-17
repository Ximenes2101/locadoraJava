package com.lab.services;

import com.lab.domains.*;
import com.lab.domains.enums.StatusCpf;
import com.lab.domains.enums.StatusVeiculo;
import com.lab.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.math.BigDecimal;
@Service
public class DBService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;

    public void initDB() {
        // Populando categorias
        Categoria cat1 = new Categoria(null, "SUV", "Veículos utilitários esportivos", StatusVeiculo.DISPONIVEL);
        Categoria cat2 = new Categoria(null, "Sedan", "Veículos de passeio com porta-malas separado", StatusVeiculo.DISPONIVEL);
        Categoria cat3 = new Categoria(null, "Hatch", "Veículos compactos com porta-malas integrado", StatusVeiculo.DISPONIVEL);


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Populando veículos
        Veiculo v1 = new Veiculo(null, "Corolla", "Toyota", LocalDate.of(2020, 5, 10), "Sedan", "ABC-1234", StatusVeiculo.DISPONIVEL);
        Veiculo v2 = new Veiculo(null, "Compass", "Jeep", LocalDate.of(2021, 8, 15), "SUV", "XYZ-5678", StatusVeiculo.DISPONIVEL);
        Veiculo v3 = new Veiculo(null, "Gol", "Volkswagen", LocalDate.of(2019, 3, 20), "Hatch", "DEF-9012", StatusVeiculo.LOCADO);

        veiculoRepository.saveAll(Arrays.asList(v1, v2, v3));

        // Populando clientes
        Cliente cli1 = new Cliente(null, "123.456.789-00", "Maria Silva", "Rua das Flores, 100", "11-99999-9999");
        Cliente cli2 = new Cliente(null, "987.654.321-00", "João Souza", "Av. Paulista, 200", "11-98888-8888");

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));

        // Populando funcionários
        Funcionario func1 = new Funcionario(null, "Carlos Oliveira", BigDecimal.valueOf(600), "111.222.333-44", StatusCpf.DISPONIVEL);

        Funcionario func2 = new Funcionario(null, "Ana Lima",  BigDecimal.valueOf(800),  "555.666.777-88", StatusCpf.DISPONIVEL);

        funcionarioRepository.saveAll(Arrays.asList(func1, func2));

        Locacao loc1 = new Locacao(null, true, LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 15), BigDecimal.valueOf(500.0), cli1, v1, func1);

        Locacao loc2 = new Locacao(null, true, LocalDate.of(2023, 2, 5), LocalDate.of(2023, 2, 10), BigDecimal.valueOf(700.0), cli2, v2, func2);

        locacaoRepository.saveAll(Arrays.asList(loc1, loc2));

    }
}
