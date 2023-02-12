package entities.veiculo;

import entities.EntidadeGenerica;
import enums.Porte;

public class Veiculo implements EntidadeGenerica {

    private String placa;

    private Porte porte;

    public Veiculo(String placa, Porte porte) {
        this.placa = placa;
        this.porte = porte;
    }

    @Override
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
}
