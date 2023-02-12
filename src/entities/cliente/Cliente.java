package entities.cliente;

import dtos.cliente.IncluirAlterarClienteDTO;
import enums.TipoPessoa;

public class Cliente{

    private String nome;

    private String cpfCnpj;

    private TipoPessoa tipoPessoa;

    public Cliente (){}

    public Cliente(String nome, String cpfCnpj) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        validaIdentificador(cpfCnpj);
    }

    public Cliente(IncluirAlterarClienteDTO incluirAlterarClienteDTO) {
        this.nome = incluirAlterarClienteDTO.getNome();
        this.cpfCnpj = incluirAlterarClienteDTO.getId();
        validaIdentificador(cpfCnpj);
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }

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
