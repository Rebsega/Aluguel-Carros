package services.cliente;

import dtos.cliente.IncluirAlterarClienteDTO;
import entities.cliente.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    void incluir(IncluirAlterarClienteDTO incluirAlterarClienteDTO);

    Cliente alterar(IncluirAlterarClienteDTO incluirAlterarClienteDTO, String idAnterior);

    Optional<Cliente> buscarPorCpfCnpj(String id);

    List<Cliente> buscarTodos();

    boolean existe(String id);
}
