package services.veiculo.impl;

import dtos.veiculo.IncluirAlterarVeiculoDTO;
import entities.veiculo.Veiculo;
import exceptions.EntidadeJaExisteException;
import repository.veiculo.VeiculoRepository;
import services.veiculo.VeiculoService;

import java.util.List;
import java.util.Optional;

public class VeiculoServiceImpl implements VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }
    @Override
    public void incluir(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO) {
        if(!existe(incluirAlterarVeiculoDTO.getPlaca())){veiculoRepository.salvar(incluirAlterarVeiculoDTO);}
        else throw new EntidadeJaExisteException(Veiculo.class.toString(), incluirAlterarVeiculoDTO.getPlaca());
    }

    @Override
    public Veiculo alterar(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO, String idAnterior) {
        return veiculoRepository.alterar(incluirAlterarVeiculoDTO, idAnterior);
    }

    @Override
    public Optional<Veiculo> buscarPorPlaca(String id) {
        return veiculoRepository.buscarPorPlaca(id);
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
