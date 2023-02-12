package entities.veiculo;

import dtos.veiculo.IncluirAlterarVeiculoDTO;
import enums.Porte;

public class Veiculo {

    private String placa;

    private Porte porte;
    private Integer taxa;
    private boolean emUso = false;

    public Veiculo(String placa, Porte porte) {
        this.placa = placa;
        this.porte = porte;
        validaPorte(porte);
    }

    public Veiculo(IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO) {
        this.placa = incluirAlterarVeiculoDTO.getPlaca();
        this.porte = incluirAlterarVeiculoDTO.getPorte();
        validaPorte(incluirAlterarVeiculoDTO.getPorte());
    }

    private void validaPorte(Porte porte) {
        if(porte == Porte.PEQUENO)
            this.taxa = 100;
        else if(porte == Porte.MEDIO)
            this.taxa = 150;
        else if(porte == Porte.SUV)
            this.taxa = 200;
    }
    public boolean isEmUso() {
        return emUso;
    }

    public void setEmUso(boolean emUso) {
        this.emUso = emUso;
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
