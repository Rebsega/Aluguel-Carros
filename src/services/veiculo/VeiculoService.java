package services.veiculo;

import dtos.veiculo.IncluirAlterarVeiculoDTO;
import entities.veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {

    void incluir(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO);

    Veiculo alterar(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO, String idAnterior);

    Optional<Veiculo> buscarPorPlaca(String id);

    List<Veiculo> buscarTodos();

    boolean existe(String id);
}
