package entities.aluguel;

import entities.EntidadeGenerica;
import entities.cliente.Cliente;
import entities.veiculo.Veiculo;

import java.util.Date;

public class Aluguel implements EntidadeGenerica {
    private Cliente cliente;
    private Veiculo veiculo;
    private String identificador;
    private Date dataAluguel;
    private Date dataDevolucao;

    public Aluguel(Cliente cliente, Veiculo veiculo, Date dataAluguel, Date dataDevolucao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String getId() {
        return identificador;
    }
}