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
}
