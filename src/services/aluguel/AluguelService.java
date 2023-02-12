package services.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelService {

    void incluir(IncluirAluguelDTO incluirAluguelDTO);

    Optional<Aluguel> buscarPorId(String id);

    List<Aluguel> buscarTodos();
}
