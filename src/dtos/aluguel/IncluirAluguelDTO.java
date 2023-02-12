package dtos.aluguel;

import entities.aluguel.Aluguel;
import entities.cliente.Cliente;
import entities.veiculo.Veiculo;

import java.util.Calendar;
import java.util.Date;

public class IncluirAluguelDTO {

    private Cliente cliente;
    private Veiculo veiculo;
    private String identificador;
    private Calendar dataAluguel;
    private Calendar dataDevolucao;

    public IncluirAluguelDTO(Aluguel aluguel) {
        this.cliente = aluguel.getCliente();
        this.veiculo = aluguel.getVeiculo();
        this.identificador = aluguel.getId();
        this.dataAluguel = aluguel.getDataAluguel();
        this.dataDevolucao = aluguel.getDataDevolucao();
    }

    public IncluirAluguelDTO(Cliente cliente, Veiculo veiculo, String identificador, Calendar dataAluguel, Calendar dataDevolucao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.identificador = identificador;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Calendar getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Calendar dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
