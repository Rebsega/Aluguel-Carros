package services.cliente;

import dtos.aluguel.IncluirAluguelDTO;
import dtos.cliente.IncluirClienteDTO;
import entities.aluguel.Aluguel;
import entities.cliente.Cliente;

import java.util.List;

public interface ClienteService {

    void incluir(IncluirClienteDTO incluirClienteDTO);

    Cliente buscarPorId(String id);

    List<Cliente> buscarTodos();

    boolean existe(String id);
}
