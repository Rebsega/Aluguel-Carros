package dtos.cliente;

import entities.cliente.Cliente;
import enums.TipoPessoa;

public class IncluirClienteDTO {

    private String id;
    private String nome;
    private TipoPessoa tipoPessoa;

    public IncluirClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.tipoPessoa = cliente.getTipoPessoa();
    }
}
