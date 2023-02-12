package services.veiculo;

import dtos.veiculo.IncluirVeiculoDTO;
import entities.veiculo.Veiculo;

import java.util.List;

public interface VeiculoService {

    void incluir(IncluirVeiculoDTO incluirVeiculoDTO);

    Veiculo buscarPorId(String id);

    List<Veiculo> buscarTodos();

    boolean existe(String id);
}
