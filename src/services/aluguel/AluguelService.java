package services.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelService {

    void incluir(IncluirAluguelDTO incluirAluguelDTO);

    Optional<Aluguel> buscarPorId(String id);

    Optional<Aluguel> buscarPorIdAluguelCpfCnpjClientePlacaVeiculo(String idAluguel, String cpfCnpjCliente, String placaVeiculo);

    boolean devolucao(String idAluguel, String cpfCnpjCliente, String placaVeiculo);

    List<Aluguel> buscarTodos();
}
