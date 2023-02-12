package dtos.veiculo;

import entities.veiculo.Veiculo;
import enums.Porte;

public class IncluirVeiculoDTO {
    private String id;

    private String placa;
    private Porte porte;

    public IncluirVeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.placa = veiculo.getPlaca();
        this.porte = veiculo.getPorte();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
