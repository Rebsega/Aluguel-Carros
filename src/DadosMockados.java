import dtos.aluguel.IncluirAluguelDTO;
import dtos.cliente.IncluirAlterarClienteDTO;
import dtos.veiculo.IncluirAlterarVeiculoDTO;
import entities.aluguel.Aluguel;
import entities.cliente.Cliente;
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

import java.util.Calendar;
import java.util.List;

public class DadosMockados {


    private VeiculoRepository veiculoRepository = new VeiculoRepositoryImpl();
    private VeiculoService veiculoService = new VeiculoServiceImpl(veiculoRepository);

    private ClienteRepository clienteRepository = new ClienteRepositoryImpl();
    private ClienteService clienteService = new ClienteServiceImpl(clienteRepository);

    private AluguelRepository aluguelRepository = new AluguelRepositoryImpl();
    private AluguelService aluguelService = new AluguelServiceImpl(aluguelRepository);

    private Veiculo veiculo;
    private Veiculo veiculo2;
    private Veiculo veiculo3;
    private Cliente cliente;
    private Cliente cliente2;
    private Cliente cliente3;
    public DadosMockados() {
        this.criarDados();
    }

    private void criarDados() {
        this.criaVeiculos();
        this.criaClientes();
        this.criaAlugueis();
    }

    private void criaVeiculos() {
        veiculo = new Veiculo("ABC-1234", Porte.PEQUENO);
        veiculo2 = new Veiculo("DEF-5678", Porte.MEDIO);
        veiculo3 = new Veiculo("GHI-9012", Porte.SUV);
       List<IncluirAlterarVeiculoDTO> incluirAlterarVeiculoDTOS = List.of(
                new IncluirAlterarVeiculoDTO(veiculo),
                new IncluirAlterarVeiculoDTO(veiculo2),
                new IncluirAlterarVeiculoDTO(veiculo3)
        );
        incluirAlterarVeiculoDTOS.forEach(veiculoService::incluir);
    }

    private void criaClientes() {
        cliente = new Cliente("João", "12345678900");
        cliente2 = new Cliente("Maria", "12345678901");
        cliente3 = new Cliente("Empresa", "12345678902432");
        List<IncluirAlterarClienteDTO> incluirAlterarClienteDTOS = List.of(
                new IncluirAlterarClienteDTO(cliente),
                new IncluirAlterarClienteDTO(cliente2),
                new IncluirAlterarClienteDTO(cliente3)
        );
        incluirAlterarClienteDTOS.forEach(clienteService::incluir);
    }

    private void criaAlugueis() {
        Calendar dataAluguel = Calendar.getInstance();
        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 1);
        Aluguel aluguel = new Aluguel(cliente, veiculo, "1", dataAluguel, dataDevolucao);
        Aluguel aluguel2 = new Aluguel(cliente2, veiculo2, "2", dataAluguel, dataDevolucao);
        Aluguel aluguel3 = new Aluguel(cliente3, veiculo3, "3", dataAluguel, dataDevolucao);
        List<IncluirAluguelDTO> incluirAluguelDTOS = List.of(
                new IncluirAluguelDTO(aluguel),
                new IncluirAluguelDTO(aluguel2),
                new IncluirAluguelDTO(aluguel3)
        );
        incluirAluguelDTOS.forEach(aluguelService::incluir);
    }
}
