package services.cliente.impl;

import dtos.cliente.IncluirClienteDTO;
import entities.cliente.Cliente;
import repository.cliente.ClienteRepository;
import services.cliente.ClienteService;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void incluir(IncluirClienteDTO incluirClienteDTO) {
        clienteRepository.salvar(incluirClienteDTO);
    }

    @Override
    public Cliente buscarPorId(String id) {
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.buscarTodos();
    }

    @Override
    public boolean existe(String id) {
        return false;
    }
}
