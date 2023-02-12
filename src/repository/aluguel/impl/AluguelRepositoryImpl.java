package repository.aluguel.impl;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;
import exceptions.VeiculoEmUsoException;
import repository.aluguel.AluguelRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AluguelRepositoryImpl implements AluguelRepository {

    private static List<Aluguel> alugueisList = new ArrayList<>();

    public AluguelRepositoryImpl(){ }


    @Override
    public void salvar(IncluirAluguelDTO incluirAluguelDTO) {
        Aluguel aluguel = new Aluguel(incluirAluguelDTO);
        alugueisList.add(aluguel);
    }

    @Override
    public Optional<Aluguel> buscarPorId(String id) {
        for(Aluguel aluguel : alugueisList) {
            if(aluguel.getId().equals(id)) {
                return Optional.of(aluguel);
            }
        }
        return Optional.empty();
    }

    @Override
    public List buscarTodos() {
      return alugueisList;
    }

    @Override
    public boolean veiculoEmUso(String id) {
        if(alugueisList.size() == 0) return false;
        for(Aluguel aluguel : alugueisList) {
            if(aluguel.getVeiculo().getPlaca().equals(id) && aluguel.getDataDevolucao().before(new Date())) {
                throw new VeiculoEmUsoException(aluguel.getVeiculo().getPlaca(), aluguel.getVeiculo().getPorte().toString());
            }
        }
        return false;
    }
}
