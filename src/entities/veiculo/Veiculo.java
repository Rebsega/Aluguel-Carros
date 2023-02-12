package entities.veiculo;

import dtos.veiculo.IncluirVeiculoDTO;
import enums.Porte;

public class Veiculo {

    private String placa;

    private Porte porte;
    private Integer taxa;

    public Veiculo(String placa, Porte porte) {
        this.placa = placa;
        this.porte = porte;
        validaPorte(porte);
    }

    public Veiculo(IncluirVeiculoDTO incluirVeiculoDTO) {
        this.placa = incluirVeiculoDTO.getPlaca();
        this.porte = incluirVeiculoDTO.getPorte();
        validaPorte(incluirVeiculoDTO.getPorte());
    }

    private void validaPorte(Porte porte) {
        if(porte == Porte.PEQUENO)
            this.taxa = 100;
        else if(porte == Porte.MEDIO)
            this.taxa = 150;
        else if(porte == Porte.SUV)
            this.taxa = 200;
    }

    public String getId() {
        return placa;
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

    public Integer getTaxa() {
        return taxa;
    }

    public void setTaxa(Integer taxa) {
        this.taxa = taxa;
    }
}
