package repository.veiculo.impl;

import dtos.veiculo.IncluirAlterarVeiculoDTO;
import entities.veiculo.Veiculo;
import exceptions.EntidadeJaExisteException;
import repository.veiculo.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepositoryImpl implements VeiculoRepository {
    private static List<Veiculo> veiculosList = new ArrayList<>();

    public VeiculoRepositoryImpl(){ }
    @Override
    public void salvar(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO) {
        Veiculo veiculo = new Veiculo(incluirAlterarVeiculoDTO);
        veiculosList.add(veiculo);
    }

    @Override
    public Veiculo alterar(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO, String placaAnterior) {
        Veiculo veiculo = new Veiculo(incluirAlterarVeiculoDTO);
        for(Veiculo v : veiculosList) {
            if(v.getPlaca().equals(placaAnterior)) {
                veiculosList.remove(v);
                veiculosList.add(veiculo);
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public Optional<Veiculo> buscarPorPlaca(String placa) {
        for(Veiculo veiculo : veiculosList) {
            if(veiculo.getPlaca().equals(placa)) {
                return Optional.of(veiculo);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Veiculo> buscarTodos() {
        return veiculosList;
    }

    @Override
    public boolean existe(String id) {
        if(veiculosList.size() == 0) return false;
        for (Veiculo veiculo : veiculosList) {
            if(veiculo.getPlaca().equals(id)) {
                throw new EntidadeJaExisteException(veiculo.getClass().toString(), veiculo.getPlaca());
            }
        }
        return false;
    }
}
