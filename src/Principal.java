import dtos.veiculo.IncluirVeiculoDTO;
import entities.veiculo.Veiculo;
import enums.Porte;
import repository.aluguel.AluguelRepository;
import repository.aluguel.impl.AluguelRepositoryImpl;
import repository.cliente.ClienteRepository;
import repository.cliente.impl.ClienteRepositoryImpl;
import repository.veiculo.VeiculoRepository;
import repository.veiculo.impl.VeiculoRepositoryImpl;
import services.aluguel.AluguelService;
import services.aluguel.impl.AluguelServiceImpl;
import services.cliente.ClienteService;
import services.cliente.impl.ClienteServiceImpl;
import services.veiculo.VeiculoService;
import services.veiculo.impl.VeiculoServiceImpl;

public class Principal {
    static VeiculoService veiculoService;
    static VeiculoRepository veiculoRepository;
    static ClienteService clienteService;
    static ClienteRepository clienteRepository;
    static AluguelService aluguelService;
    static AluguelRepository aluguelRepository;

    private void criarMock() {
        instanciarServicos();
    }

    static void instanciarServicos() {
        veiculoRepository = new VeiculoRepositoryImpl();
        veiculoService = new VeiculoServiceImpl(veiculoRepository);
        clienteRepository = new ClienteRepositoryImpl();
        clienteService = new ClienteServiceImpl(clienteRepository);
        aluguelRepository = new AluguelRepositoryImpl();
        aluguelService = new AluguelServiceImpl(aluguelRepository);
    }

    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("ABC-1234", Porte.PEQUENO);
        Veiculo veiculo2 = new Veiculo("DEF-5678", Porte.MEDIO);
        Veiculo veiculo3 = new Veiculo("GHI-9012", Porte.SUV);
        IncluirVeiculoDTO incluirVeiculoDTO = new IncluirVeiculoDTO(veiculo);
        IncluirVeiculoDTO incluirVeiculoDTO2 = new IncluirVeiculoDTO(veiculo2);
        IncluirVeiculoDTO incluirVeiculoDTO3 = new IncluirVeiculoDTO(veiculo3);
        veiculoService.incluir(incluirVeiculoDTO);
        veiculoService.incluir(incluirVeiculoDTO2);
        veiculoService.incluir(incluirVeiculoDTO3);

        for(Veiculo v : veiculoService.buscarTodos())
            System.out.println(v.getId() + " - " + v.getPorte() + " - " + v.getTaxa());

    }
}
