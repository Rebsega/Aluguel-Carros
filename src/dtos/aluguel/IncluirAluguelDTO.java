package dtos.aluguel;

import entities.aluguel.Aluguel;
import entities.cliente.Cliente;
import entities.veiculo.Veiculo;

import java.util.Date;

public class IncluirAluguelDTO {

    private Cliente cliente;
    private Veiculo veiculo;
    private String identificador;
    private Date dataAluguel;
    private Date dataDevolucao;

    public IncluirAluguelDTO(Aluguel aluguel) {
        this.cliente = aluguel.getCliente();
        this.veiculo = aluguel.getVeiculo();
        this.identificador = aluguel.getId();
        this.dataAluguel = aluguel.getDataAluguel();
        this.dataDevolucao = aluguel.getDataDevolucao();
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
}
