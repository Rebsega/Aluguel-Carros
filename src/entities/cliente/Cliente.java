package entities.cliente;

import dtos.aluguel.IncluirAluguelDTO;
import dtos.cliente.IncluirClienteDTO;
import enums.TipoPessoa;

public class Cliente{

    private String nome;

    private String id;

    private TipoPessoa tipoPessoa;

    public Cliente(String nome, String identificador) {
        this.nome = nome;
        this.id = identificador;
        validaIdentificador(identificador);
    }

    public Cliente(IncluirClienteDTO incluirClienteDTO) {
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setId(String id) { this.id = id; }

    private void validaIdentificador(String identificador) {
        if(identificador.length() == 11)
            this.tipoPessoa = TipoPessoa.FISICA;
        else if(identificador.length() == 14)
            this.tipoPessoa = TipoPessoa.JURIDICA;
        else
            throw new IllegalArgumentException("Identificador inválido");
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
