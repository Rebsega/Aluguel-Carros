package repository.aluguel.impl;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;
import persistence.memoria.GerenciadorArquivo;
import repository.aluguel.AluguelRepository;

import java.util.List;

public class AluguelRepositoryImpl implements AluguelRepository {

    private GerenciadorArquivo gerenciadorArquivo;

    public AluguelRepositoryImpl(GerenciadorArquivo gerenciadorArquivo) {
        this.gerenciadorArquivo = gerenciadorArquivo;
    }


    @Override
    public void salvar(IncluirAluguelDTO incluirAluguelDTO) {
        gerenciadorArquivo.escreverArquivo(incluirAluguelDTO);
    }

    @Override
    public Aluguel buscarPorId(String id) {
        return (Aluguel) gerenciadorArquivo.buscarPorIdUnico(id);
    }

    @Override
    public List buscarPorCliente(String nomeCliente) {
        return null;
    }

    @Override
    public List buscarTodos() {
        return null;
    }

    @Override
    public boolean deletar(String id) {
        return false;
    }
}
