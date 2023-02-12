package services.veiculo.impl;

import dtos.veiculo.IncluirVeiculoDTO;
import entities.veiculo.Veiculo;
import exceptions.EntidadeJaExisteException;
import repository.veiculo.VeiculoRepository;
import services.veiculo.VeiculoService;

import java.util.List;

public class VeiculoServiceImpl implements VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }
    @Override
    public void incluir(IncluirVeiculoDTO incluirVeiculoDTO) {
        if(!existe(incluirVeiculoDTO.getId())){veiculoRepository.salvar(incluirVeiculoDTO);}
        else throw new EntidadeJaExisteException(Veiculo.class.toString(), incluirVeiculoDTO.getId());
    }

    @Override
    public Veiculo buscarPorId(String id) {
        return veiculoRepository.buscarPorId(id);
    }

    @Override
    public List<Veiculo> buscarTodos() {
        return veiculoRepository.buscarTodos();
    }

    @Override
    public boolean existe(String id) {
        return veiculoRepository.existe(id);
    }
}
