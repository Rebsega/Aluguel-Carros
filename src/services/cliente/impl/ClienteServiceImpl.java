package services.cliente.impl;

import dtos.cliente.IncluirAlterarClienteDTO;
import entities.cliente.Cliente;
import repository.cliente.ClienteRepository;
import repository.cliente.impl.ClienteRepositoryImpl;
import services.cliente.ClienteService;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository = new ClienteRepositoryImpl();

    public ClienteServiceImpl(ClienteRepository clienteRepository) {

    }

    @Override
    public void incluir(IncluirAlterarClienteDTO incluirAlterarClienteDTO) {
        clienteRepository.salvar(incluirAlterarClienteDTO);
    }

    @Override
    public Cliente alterar(IncluirAlterarClienteDTO incluirAlterarClienteDTO, String idAnterior) {
        return clienteRepository.alterar(incluirAlterarClienteDTO, idAnterior);
    }

    @Override
    public Optional<Cliente> buscarPorCpfCnpj(String id) {
        return clienteRepository.buscarPorCpfCnpj(id);
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
