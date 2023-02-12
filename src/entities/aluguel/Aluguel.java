package entities.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.cliente.Cliente;
import entities.veiculo.Veiculo;

import java.util.Calendar;
import java.util.Date;

public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private String id;
    private Calendar dataAluguel;
    private Calendar dataDevolucao;
    private double valor;


    public Aluguel(IncluirAluguelDTO incluirAluguelDTO) {
        this.cliente = incluirAluguelDTO.getCliente();
        this.veiculo = incluirAluguelDTO.getVeiculo();
        this.id = incluirAluguelDTO.getIdentificador();
        this.dataAluguel = incluirAluguelDTO.getDataAluguel();
        this.dataDevolucao = incluirAluguelDTO.getDataDevolucao();
    }

    public Aluguel(Cliente cliente, Veiculo veiculo, String id, Calendar dataAluguel, Calendar dataDevolucao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.id = id;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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