import menus.MenuPrincipal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usar dados pré-inseridos? (S/N)");
        String usarDadosMockados = scanner.nextLine();
        if (usarDadosMockados.equalsIgnoreCase("S")) {
            new DadosMockados();
        }
        new MenuPrincipal();
    }
}