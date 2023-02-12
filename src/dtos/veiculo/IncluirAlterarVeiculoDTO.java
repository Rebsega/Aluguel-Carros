package dtos.veiculo;

import entities.veiculo.Veiculo;
import enums.Porte;

public class IncluirAlterarVeiculoDTO {

    private String placa;
    private Porte porte;

    public IncluirAlterarVeiculoDTO(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.porte = veiculo.getPorte();
    }

    public IncluirAlterarVeiculoDTO(String placa, Porte porte) {
        this.placa = placa;
        this.porte = porte;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }
}
