package repository.aluguel.impl;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;
import exceptions.VeiculoEmUsoException;
import repository.aluguel.AluguelRepository;

import java.util.*;

public class AluguelRepositoryImpl implements AluguelRepository {

    private static List<Aluguel> alugueisList = new ArrayList<>();

    public AluguelRepositoryImpl(){ }


    @Override
    public void salvar(IncluirAluguelDTO incluirAluguelDTO) {
        Aluguel aluguel = new Aluguel(incluirAluguelDTO);
        aluguel.setAtivo(true);
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
    public Optional<Aluguel> buscarPorIdAluguelCpfCnpjClientePlacaVeiculo(String idAluguel, String cpfCnpjCliente, String placaVeiculo) {
        for(Aluguel aluguel : alugueisList) {
            if(aluguel.getId().equals(idAluguel) && aluguel.getCliente().getCpfCnpj().equals(cpfCnpjCliente) && aluguel.getVeiculo().getPlaca().equals(placaVeiculo)) {
                return Optional.of(aluguel);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean devolucaoVeiculo(String idAluguel, String cpfCnpjCliente, String placaVeiculo) {
        Calendar dataFinal = Calendar.getInstance();
        for(Aluguel aluguel : alugueisList) {
            if(aluguel.getId().equals(idAluguel) && aluguel.getCliente().getCpfCnpj().equals(cpfCnpjCliente) && aluguel.getVeiculo().getPlaca().equals(placaVeiculo)) {
                aluguel.setDataDevolucao(dataFinal);
                aluguel.setAtivo(false);
                return true;
            }
        }
        return false;
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
