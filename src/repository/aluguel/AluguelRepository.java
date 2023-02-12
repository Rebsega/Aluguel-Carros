package repository.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;

import java.util.List;

public interface AluguelRepository{

    void salvar(IncluirAluguelDTO incluirAluguelDTO);

    Aluguel buscarPorId(String id);

    List<Aluguel> buscarPorCliente(String nomeCliente);

    List<Aluguel> buscarTodos();

    boolean veiculoEmUso(String idVeiculo);
}
