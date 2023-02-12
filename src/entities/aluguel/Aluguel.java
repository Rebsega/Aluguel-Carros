package entities.aluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.cliente.Cliente;
import entities.veiculo.Veiculo;

import java.util.Date;

public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private String id;
    private Date dataAluguel;
    private Date dataDevolucao;

    public Aluguel(IncluirAluguelDTO incluirAluguelDTO) {
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