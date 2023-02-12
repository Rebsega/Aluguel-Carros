package dtos.cliente;

import entities.cliente.Cliente;
import enums.TipoPessoa;

public class IncluirAlterarClienteDTO {

    private String id;
    private String nome;
    private TipoPessoa tipoPessoa;

    public IncluirAlterarClienteDTO(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public IncluirAlterarClienteDTO(Cliente cliente) {
        this.id = cliente.getCpfCnpj();
        this.nome = cliente.getNome();
        this.tipoPessoa = cliente.getTipoPessoa();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
