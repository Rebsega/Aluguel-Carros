package repository.veiculo;

import dtos.veiculo.IncluirVeiculoDTO;
import entities.veiculo.Veiculo;

import java.util.List;

public interface VeiculoRepository {
    void salvar(IncluirVeiculoDTO incluirVeiculoDTO);

    Veiculo buscarPorId(String id);

    List<Veiculo> buscarTodos();

    boolean existe(String id);
}
