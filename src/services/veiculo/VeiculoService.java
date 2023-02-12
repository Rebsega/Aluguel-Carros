package services.veiculo;

import dtos.veiculo.IncluirVeiculoDTO;
import entities.veiculo.Veiculo;

public interface VeiculoService {

    Veiculo criarVeiculo(IncluirVeiculoDTO incluirVeiculoDTO);
}
