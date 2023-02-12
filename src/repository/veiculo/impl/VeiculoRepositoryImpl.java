package repository.veiculo.impl;

import dtos.veiculo.IncluirVeiculoDTO;
import entities.veiculo.Veiculo;
import exceptions.EntidadeJaExisteException;
import repository.veiculo.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositoryImpl implements VeiculoRepository {
    private List<Veiculo> veiculosList;

    public VeiculoRepositoryImpl(){
        this.veiculosList = new ArrayList<>();
    }
    @Override
    public void salvar(IncluirVeiculoDTO incluirVeiculoDTO) {
        Veiculo veiculo = new Veiculo(incluirVeiculoDTO);
        veiculosList.add(veiculo);
    }

    @Override
    public Veiculo buscarPorId(String id) {
        for(Veiculo veiculo : veiculosList) {
            if(veiculo.getId().equals(id)) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> buscarTodos() {
        return veiculosList;
    }

    @Override
    public boolean existe(String id) {
        if(veiculosList.size() == 0) return false;
        for (Veiculo veiculo : veiculosList) {
            if(veiculo.getId().equals(id)) {
                throw new EntidadeJaExisteException(veiculo.getClass().toString(), veiculo.getId());
            }
        }
        return false;
    }
}
