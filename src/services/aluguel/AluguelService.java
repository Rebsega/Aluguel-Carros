package services.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;

public interface AluguelService {

    void incluir(IncluirAluguelDTO incluirAluguelDTO);

    Aluguel buscarPorId(String id);
}
