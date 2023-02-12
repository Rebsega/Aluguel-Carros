package repository.aluguel.impl;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;
import exceptions.VeiculoEmUsoException;
import repository.aluguel.AluguelRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AluguelRepositoryImpl implements AluguelRepository {

    private List<Aluguel> alugueisList;

    public AluguelRepositoryImpl(){ }


    @Override
    public void salvar(IncluirAluguelDTO incluirAluguelDTO) {
        Aluguel aluguel = new Aluguel(incluirAluguelDTO);
        alugueisList.add(aluguel);
    }

    @Override
    public Aluguel buscarPorId(String id) {
        return null;
    }

    @Override
    public List buscarPorCliente(String idCliente) {
        return null;
    }

    @Override
    public List buscarTodos() {
      return null;
    }

    @Override
    public boolean veiculoEmUso(String id) {
        for(Aluguel aluguel : alugueisList) {
            if(aluguel.getVeiculo().getId().equals(id) && aluguel.getDataDevolucao().before(new Date())) {
                throw new VeiculoEmUsoException(aluguel.getVeiculo().getId(), aluguel.getVeiculo().getPorte().toString());
            }
        }
        return false;
    }
}
