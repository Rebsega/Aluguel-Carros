package services.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;

import java.util.List;

public interface AluguelService {

    void incluir(IncluirAluguelDTO incluirAluguelDTO);

    Aluguel buscarPorId(String id);

    List<Aluguel> buscarTodos();
}
