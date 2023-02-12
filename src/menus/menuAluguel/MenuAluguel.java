package menus.menuAluguel;

import dtos.aluguel.IncluirAluguelDTO;
import entities.aluguel.Aluguel;
import entities.cliente.Cliente;
import entities.veiculo.Veiculo;
import enums.TipoPessoa;
import exceptions.RecursoNaoEncontradoException;
import exceptions.VeiculoEmUsoException;
import menus.MenuPrincipal;
import repository.aluguel.AluguelRepository;
import repository.cliente.ClienteRepository;
import repository.veiculo.VeiculoRepository;
import services.aluguel.AluguelService;
import services.aluguel.impl.AluguelServiceImpl;
import services.cliente.ClienteService;
import services.cliente.impl.ClienteServiceImpl;
import services.veiculo.VeiculoService;
import services.veiculo.impl.VeiculoServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuAluguel  {

    private final String SEPARADOR = "----------------------------------------";

    private ClienteService clienteService;
    private ClienteRepository clienteRepository;
    private VeiculoService veiculoService;
    private VeiculoRepository veiculoRepository;
    private AluguelService aluguelService;
    private AluguelRepository aluguelRepository;
    Scanner scanner = new Scanner(System.in);
    public MenuAluguel() {
        this.clienteService = new ClienteServiceImpl(clienteRepository);
        this.veiculoService = new VeiculoServiceImpl(veiculoRepository);
        this.aluguelService = new AluguelServiceImpl(aluguelRepository);
        this.exibeMenuAluguel();
    }

    private void exibeMenuAluguel() {
         int escolha = 0;
         while(true){
            System.out.println(SEPARADOR);
            System.out.println("Menu Aluguel");
            System.out.println("1 - Incluir");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Voltar");
            System.out.println(SEPARADOR);
            escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1 -> this.incluirAluguel();
                case 2 -> this.listarAlugueis();
                case 3 -> this.buscarAluguelPorId();
                case 4 -> new MenuPrincipal();
                default -> {
                    System.out.println("Opção inválida");
                    this.exibeMenuAluguel();
                }
            }
         }
    }

    private boolean validaPlaca(String placa) {
        if(placa.length() != 7) {
            return false;
        }
        String[] placaArray = placa.split("-");
        if(placaArray.length != 2) {
            return false;
        }
        if(placaArray[0].length() != 3 || placaArray[1].length() != 4) {
            return false;
        }
        return true;
    }

    private boolean validaPorte(String porte) {
        return porte.equalsIgnoreCase("Pequeno") || porte.equalsIgnoreCase("Médio") || porte.equalsIgnoreCase("SUV");
    }

    private boolean validaCepCnpj(String id) {
        return id.length() == 11 || id.length() == 14;
    }

    private Date converteStringToDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(data);
    }

    private double calcularValorAluguel(Aluguel aluguel) {
        Calendar dataInicial = aluguel.getDataAluguel();
        Calendar dataFinal = aluguel.getDataDevolucao();
        long dias = (dataFinal.getTimeInMillis() - dataInicial.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        //validar desconto se pessoa fisica ou juridica
        if(dias == 5 && aluguel.getCliente().getTipoPessoa() == TipoPessoa.FISICA) {
            return (dias * aluguel.getVeiculo().getTaxa()) * 0.95;
        }
        else if(dias == 3 && aluguel.getCliente().getTipoPessoa() == TipoPessoa.JURIDICA) {
            return (dias * aluguel.getVeiculo().getTaxa()) * 0.90;
        }
        else {
            return dias * aluguel.getVeiculo().getTaxa();
        }
    }

    private void incluirAluguel(){
        System.out.println("Incluir Aluguel");
        System.out.println("ID do aluguel: ");
        String id = scanner.nextLine();

        /////////////////////CLIENTE QUE VAI ALUGAR/////////////////////
        List<Cliente> clienteList = clienteService.buscarTodos();
        System.out.println("Clientes da base: \n");
        for(Cliente cliente: clienteList){
            System.out.println(cliente.getCpfCnpj() + " - " + cliente.getNome());
        }
        System.out.println("CPF/CNPJ do cliente: ");
        String cpfCnpj = scanner.nextLine();
        while(!validaCepCnpj(cpfCnpj)) {
            System.out.println("CPF/CNPJ inválido");
            System.out.println("Redigite: ");
            cpfCnpj = scanner.nextLine();
        }
        String finalCpfCnpj = cpfCnpj;
        Cliente cliente = clienteService.buscarPorCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente", finalCpfCnpj));
        /////////////////////CLIENTE QUE VAI ALUGAR/////////////////////

        /////////////////////VEÍCULO QUE SERÁ ALUGADO/////////////////////
        System.out.println("Veículos da base: \n");
        List<Veiculo> veiculoList = veiculoService.buscarTodos();
        for(Veiculo veiculo: veiculoList){
            System.out.println(veiculo.getPlaca() + " - " + veiculo.getPorte());
        }
        System.out.println("Placa do veículo: ");
        String placa = scanner.nextLine();
        while(!validaPlaca(placa)) {
            System.out.println("Placa inválida");
            System.out.println("Redigite: ");
            placa = scanner.nextLine();
        }
        String finalPlaca = placa;
        Veiculo veiculo = veiculoService.buscarPorPlaca(placa)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo", finalPlaca));
        if(veiculo.isEmUso()){
            throw new VeiculoEmUsoException(veiculo.getPlaca(), veiculo.getPorte().toString());
        }
        /////////////////////VEÍCULO QUE SERÁ ALUGADO/////////////////////

        /////////////////////PERÍODO DE ALUGUEL/////////////////////
        System.out.println("Data de início: ");
        String dataInicio = scanner.nextLine();
        Calendar dataInicioCalendar = null;
        try {
            dataInicioCalendar = Calendar.getInstance();
            dataInicioCalendar.setTime(converteStringToDate(dataInicio));
        }catch (ParseException e) {
            System.out.println("Data inválida");
            System.out.println("Redigite: ");
            dataInicio = scanner.nextLine();
        }
        System.out.println("Data de término: ");
        String dataTermino = scanner.nextLine();
        Calendar dataFimCalendar = null;
        try {
            dataFimCalendar = Calendar.getInstance();
            dataFimCalendar.setTime(converteStringToDate(dataTermino));
        }catch (ParseException e) {
            System.out.println("Data inválida");
            System.out.println("Redigite: ");
            dataTermino = scanner.nextLine();
        }

        /////////////////////MONTANDO O ALUGUEL/////////////////////
        Aluguel aluguel = new Aluguel(cliente, veiculo, id, dataInicioCalendar, dataFimCalendar);
        IncluirAluguelDTO incluirAluguelDTO = new IncluirAluguelDTO(aluguel);
        aluguelService.incluir(incluirAluguelDTO);

        aluguel.setValor(calcularValorAluguel(aluguel));

        aluguel.getVeiculo().setEmUso(true);
        System.out.println("Aluguel incluído com sucesso");
        /////////////////////MONTANDO O ALUGUEL/////////////////////
    }

    private void listarAlugueis() {
        System.out.println("Listar Alugueis");
        List<Aluguel> aluguelList = aluguelService.buscarTodos();
        for(Aluguel aluguel: aluguelList){
            System.out.println(aluguel.getId() + " - " + aluguel.getCliente().getNome() + " - " + aluguel.getVeiculo().getPlaca());
        }
    }

    private void buscarAluguelPorId() {
        System.out.println("Buscar Aluguel por ID");
        System.out.println("ID do aluguel: ");
        String id = scanner.nextLine();
        Aluguel aluguel = aluguelService.buscarPorId(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluguel", id));
        System.out.println(aluguel.getId() + " - " + aluguel.getCliente().getNome() + " - " + aluguel.getVeiculo().getPlaca());
    }

}
