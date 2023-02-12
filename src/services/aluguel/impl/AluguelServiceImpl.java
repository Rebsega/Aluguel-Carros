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
    public List<Aluguel> buscarTodos() {
        return aluguelRepository.buscarTodos();
    }
}
