package repository.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelRepository{

    void salvar(IncluirAluguelDTO incluirAluguelDTO);

    Optional<Aluguel> buscarPorId(String id);

    Optional<Aluguel> buscarPorIdAluguelCpfCnpjClientePlacaVeiculo(String idAluguel, String cpfCnpjCliente, String placaVeiculo);

    boolean devolucaoVeiculo(String idAluguel, String cpfCnpjCliente, String placaVeiculo);

    List<Aluguel> buscarTodos();

    boolean veiculoEmUso(String idVeiculo);
}
