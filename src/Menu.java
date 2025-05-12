import java.util.Scanner;

public class Menu {
    // Artributos
    Scanner sc;

    // Constructor
    public Menu() {
        this.sc = new Scanner(System.in);
    }

    // Metodos
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** BIENVENIDO AL CONVERTIDOR DE MONEDAS *****");
            System.out.println("1. Convertir Moneda");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion();
                    break;
                case 2:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opcion != 2);
    }

    private  void realizarConversion() {
        System.out.print("Ingrese codigo de moneda de origen (Ej: USD): ");
        String monedaOrigen = sc.next().toUpperCase();
        System.out.print("Ingrese codigo de moneda de destino (Ej: EU): ");
        String monedaDestino = sc.next().toUpperCase();
        System.out.print("Ingrese valor a convertir: ");
        double valor = sc.nextDouble();

        System.out.println(valor + " " + monedaOrigen + " equivalen a " + "00.00 " + monedaDestino);
    }
}
