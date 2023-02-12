package services.aluguel.impl;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;
import repository.aluguel.AluguelRepository;
import services.aluguel.AluguelService;

import java.util.List;
import java.util.Optional;

public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    public AluguelServiceImpl(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public void incluir(IncluirAluguelDTO incluirAluguelDTO) {
        aluguelRepository.salvar(incluirAluguelDTO);
    }

    @Override
    public Optional<Aluguel> buscarPorId(String id) {
        return aluguelRepository.buscarPorId(id);
    }

    @Override
    public Optional<Aluguel> buscarPorIdAluguelCpfCnpjClientePlacaVeiculo(String idAluguel, String cpfCnpjCliente, String placaVeiculo) {
        return aluguelRepository.buscarPorIdAluguelCpfCnpjClientePlacaVeiculo(idAluguel, cpfCnpjCliente, placaVeiculo);
    }

    @Override
    public boolean devolucao(String idAluguel, String cpfCnpjCliente, String placaVeiculo) {
        return aluguelRepository.devolucaoVeiculo(idAluguel, cpfCnpjCliente, placaVeiculo);
    }

    @Override
    public List<Aluguel> buscarTodos() {
        return aluguelRepository.buscarTodos();
    }
}
