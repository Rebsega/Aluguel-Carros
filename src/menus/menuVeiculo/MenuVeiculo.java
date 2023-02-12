package menus.menuVeiculo;

import dtos.veiculo.IncluirAlterarVeiculoDTO;
import entities.veiculo.Veiculo;
import enums.Porte;
import exceptions.RecursoNaoEncontradoException;
import menus.MenuPrincipal;
import repository.veiculo.VeiculoRepository;
import services.veiculo.VeiculoService;
import services.veiculo.impl.VeiculoServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuVeiculo {
    private final String SEPARADOR = "----------------------------------------";
    private VeiculoService veiculoService;
    private VeiculoRepository veiculoRepository;
    Scanner scanner = new Scanner(System.in);

    public MenuVeiculo() {
        this.veiculoService = new VeiculoServiceImpl(veiculoRepository);
        this.exibeMenuVeiculo();
    }

    private void exibeMenuVeiculo() {
        int escolha = 0;
        while(true) {
            System.out.println(SEPARADOR);
            System.out.println("Menu Veículo");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Listar");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Voltar");
            System.out.println(SEPARADOR);
            System.out.println("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1 -> this.incluirVeiculo();
                case 2 -> this.alterarVeiculo();
                case 3 -> this.listarVeiculos();
                case 4 -> this.buscarVeiculoPorPlaca();
                case 5 -> new MenuPrincipal();
                default -> {
                    System.out.println("Opção inválida");
                    this.exibeMenuVeiculo();
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

    private void incluirVeiculo() {
        System.out.println("Incluir Veículo");
        System.out.println("Placa (Modelo AAA-1234):");
        String placa = scanner.nextLine();
        while(!validaPlaca(placa)){
            System.err.println("Placa inválida. Digite uma placa válida (AAA-9999)");
            placa = scanner.nextLine();
        }
        System.out.println("Porte (Pequeno/Médio/SUV):");
        String porte = scanner.nextLine();
        while(!validaPorte(porte)) {
            System.err.println("Porte inválido. Digite Pequeno, Médio ou SUV");
            porte = scanner.nextLine();
        }
        Porte porteEnum = Porte.valueOf(porte.toUpperCase());
        Veiculo veiculo = new Veiculo(placa, porteEnum);
        veiculo.setEmUso(false);
        IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO = new IncluirAlterarVeiculoDTO(veiculo);
        veiculoService.incluir(incluirAlterarVeiculoDTO);
        System.out.println("Veículo incluído com sucesso!");
    }

    private void alterarVeiculo() {
        System.out.println("Alterar Veículo");
        System.out.println("Digite a placa (AAA-9999) do veículo que deseja alterar: ");
        String placa = scanner.nextLine();
        while(!validaPlaca(placa)){
            System.err.println("Placa inválida. Digite uma placa válida (AAA-9999)");
            placa = scanner.nextLine();
        }
        String finalPlaca = placa;
        Veiculo veiculo = veiculoService.buscarPorPlaca(placa)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo", finalPlaca));
        System.out.println("Veiculo encontrado "+veiculo.getPorte()+": " + veiculo.getPlaca());
        System.out.println("Digite o novo porte (Pequeno/Médio/SUV):");
        String porte = scanner.nextLine();
        while(!validaPorte(porte)) {
            System.err.println("Porte inválido. Digite Pequeno, Médio ou SUV");
            porte = scanner.nextLine();
        }
        Porte porteEnum = Porte.valueOf(porte.toUpperCase());
        IncluirAlterarVeiculoDTO incluirAlterarVeiculoDTO = new IncluirAlterarVeiculoDTO(placa,porteEnum);
        veiculoService.alterar(incluirAlterarVeiculoDTO, finalPlaca);
    }

    private void listarVeiculos() {
        System.out.println("Listar Veículos");
        List<Veiculo> veiculosList = veiculoService.buscarTodos();
        veiculosList.forEach(veiculo ->
                System.out.println(veiculo.getPorte()+": " + veiculo.getPlaca())
        );
    }

    private void buscarVeiculoPorPlaca() {
        System.out.println("Buscar Veículo por ID");
        System.out.println("Digite a placa do veículo que deseja buscar: ");
        String placa = scanner.nextLine();
        while(!validaPlaca(placa)){
            System.err.println("Placa inválida. Digite uma placa válida (AAA-9999)");
            placa = scanner.nextLine();
        }
        scanner.nextLine();
        String finalPlaca = placa;
        Veiculo veiculo = veiculoService.buscarPorPlaca(placa)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo", finalPlaca));
        System.out.println(veiculo.getPorte()+": " + veiculo.getPlaca());
    }
}
