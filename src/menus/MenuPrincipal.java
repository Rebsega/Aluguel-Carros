package menus;

import menus.menuAluguel.MenuAluguel;
import menus.menuCliente.MenuCliente;
import menus.menuVeiculo.MenuVeiculo;

import java.util.Scanner;

public class MenuPrincipal {
    Scanner scanner = new Scanner(System.in);

    public MenuPrincipal() {
        this.exibeMenu();
    }

    private void exibeMenu() {
        int escolha = 0;
        while(true) {
            System.out.println("Menu Principal");
            System.out.println("1 - Aluguel");
            System.out.println("2 - Cliente");
            System.out.println("3 - Veículo");
            System.out.println("4 - Sair");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1 -> new MenuAluguel();
                case 2 -> new MenuCliente();
                case 3 -> new MenuVeiculo();
                case 4 -> System.exit(0);
                default -> {
                    System.out.println("Opção inválida");
                    this.exibeMenu();
                }
            }
        }
    }
}
