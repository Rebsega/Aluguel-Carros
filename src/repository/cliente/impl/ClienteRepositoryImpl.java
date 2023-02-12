package repository.cliente.impl;

import dtos.cliente.IncluirAlterarClienteDTO;
import entities.cliente.Cliente;
import exceptions.EntidadeJaExisteException;
import repository.cliente.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryImpl implements ClienteRepository {

    private static List<Cliente> clientesList = new ArrayList<>();

    public ClienteRepositoryImpl(){
    }

    @Override
    public void salvar(IncluirAlterarClienteDTO incluirAlterarClienteDTO) {
       Cliente cliente = new Cliente(incluirAlterarClienteDTO);
         if(existe(cliente.getCpfCnpj())) {
              throw new EntidadeJaExisteException(cliente.getClass().toString(), cliente.getCpfCnpj());
         }
        clientesList.add(cliente);
    }

    @Override
    public Cliente alterar(IncluirAlterarClienteDTO incluirAlterarClienteDTO, String idAnterior) {
        Cliente cliente = new Cliente(incluirAlterarClienteDTO);
        buscarPorCpfCnpj(idAnterior).ifPresent(clienteAnterior -> {
            clientesList.remove(clienteAnterior);
            clientesList.add(cliente);
        });
        return null;
    }

    @Override
    public Optional<Cliente> buscarPorCpfCnpj(String id) {
        for(Cliente cliente : clientesList) {
            if(cliente.getCpfCnpj().equals(id)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clientesList;
    }

    @Override
    public boolean existe(String id) {
        if(clientesList.size() == 0) return false;
        for(Cliente cliente : clientesList) {
            if(cliente.getCpfCnpj().equals(id)) {
                throw new EntidadeJaExisteException(cliente.getClass().toString(), cliente.getCpfCnpj());
            }
        }
        return false;
    }
}
