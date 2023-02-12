package repository.cliente.impl;

import dtos.aluguel.IncluirAluguelDTO;
import dtos.cliente.IncluirClienteDTO;
import entities.cliente.Cliente;
import exceptions.EntidadeJaExisteException;
import repository.cliente.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {

    private List<Cliente> clientesList;

    public ClienteRepositoryImpl(){ }

    @Override
    public void salvar(IncluirClienteDTO incluirClienteDTO) {
       Cliente cliente = new Cliente(incluirClienteDTO);
         clientesList.add(cliente);
    }

    @Override
    public Cliente buscarPorId(String id) {
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public boolean existe(String id) {
        for(Cliente cliente : clientesList) {
            if(cliente.getId().equals(id)) {
                throw new EntidadeJaExisteException(cliente.getClass().toString(), cliente.getId());
            }
        }
        return false;
    }
}
