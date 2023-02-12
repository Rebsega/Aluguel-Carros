package menus.menuCliente;

import dtos.cliente.IncluirAlterarClienteDTO;
import entities.cliente.Cliente;
import exceptions.RecursoNaoEncontradoException;
import menus.MenuPrincipal;
import repository.cliente.ClienteRepository;
import services.cliente.ClienteService;
import services.cliente.impl.ClienteServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MenuCliente  {
    private final String SEPARADOR = "----------------------------------------";
    private ClienteService clienteService;
    private ClienteRepository clienteRepository;
    Scanner scanner = new Scanner(System.in);

    public MenuCliente() {
        this.clienteService = new ClienteServiceImpl(clienteRepository);
        this.exibeMenuCliente();
    }

    private void exibeMenuCliente() {
        int escolha = 0;
        while(true) {
            System.out.println(SEPARADOR);
            System.out.println("Menu Cliente");
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
                case 1 -> this.incluirCliente();
                case 2 -> this.alterarCliente();
                case 3 -> this.listarClientes();
                case 4 -> this.buscarClientePorId();
                case 5 -> new MenuPrincipal();
                default -> {
                    System.out.println("Opção inválida");
                    this.exibeMenuCliente();
                }
            }
        }
    }

    private boolean validaCepCnpj(String id) {
        return id.length() == 11 || id.length() == 14;
    }

    private void incluirCliente() {

        System.out.println("Incluir Cliente");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF/CNPJ: ");
        String cpfCnpj = scanner.nextLine();
        while(!validaCepCnpj(cpfCnpj)) {
            System.err.println("CPF/CNPJ inválido. Digite novamente: ");
            cpfCnpj = scanner.nextLine();
        }
        Cliente cliente = new Cliente(nome, cpfCnpj);
        IncluirAlterarClienteDTO incluirAlterarClienteDTO = new IncluirAlterarClienteDTO(cliente);
        clienteService.incluir(incluirAlterarClienteDTO);
        System.out.println("Cliente incluído com sucesso!");
    }

    private void alterarCliente() {
        String id = "";
        System.out.println("Alterar Cliente");
        System.out.println("Digite o ID: ");
        id = scanner.nextLine();
        String finalId = id;
        Cliente cliente = clienteService.buscarPorCpfCnpj(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente", finalId));
        System.out.println("Alterando o cliente: " + cliente.getNome() + " - " + cliente.getCpfCnpj());
        System.out.println("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.println("Novo CPF/CNPJ: ");
        String cpfCnpj = scanner.nextLine();
        while(!validaCepCnpj(cpfCnpj)) {
            System.err.println("CPF/CNPJ inválido. Digite novamente: ");
            cpfCnpj = scanner.nextLine();
        }
        IncluirAlterarClienteDTO incluirAlterarClienteDTO = new IncluirAlterarClienteDTO(nome, cpfCnpj);
        clienteService.alterar(incluirAlterarClienteDTO, finalId);
    }

    private void listarClientes() {
        System.out.println("Listar Clientes");
        List<Cliente> clientesList = clienteService.buscarTodos();
        clientesList.forEach((cliente) ->
            System.out.println(cliente.getNome() + " - " + cliente.getCpfCnpj())
        );
    }

    private void buscarClientePorId() {
        String cpfCnpj = "";
        System.out.println("Buscar Cliente por CPF/CNPJ");
        System.out.println("Digite o ID: ");
        cpfCnpj = scanner.nextLine();
        String finalId = cpfCnpj;
        Cliente cliente = clienteService.buscarPorCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente", finalId));
        System.out.println(cliente.getNome() + " - " + cliente.getCpfCnpj());
    }
}