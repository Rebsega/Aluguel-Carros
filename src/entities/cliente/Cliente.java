package entities.cliente;

import entities.EntidadeGenerica;
import enums.TipoPessoa;

public class Cliente implements EntidadeGenerica {

    private String nome;

    private String identificador;

    private TipoPessoa tipoPessoa;

    public Cliente(String nome, String identificador, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.identificador = identificador;
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String getId() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
        validaIdentificador(identificador);
    }

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
