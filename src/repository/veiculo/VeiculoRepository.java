package repository.veiculo;

import dtos.veiculo.IncluirAlterarVeiculoDTO;
import entities.veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository {
    void salvar(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO);
    Veiculo alterar(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO, String placaAnterior);

    Optional<Veiculo> buscarPorPlaca(String id);

    List<Veiculo> buscarTodos();

    boolean existe(String id);
}
