import java.util.Scanner;

public class Menu {
    // Artributos
    Scanner sc;
    ConsultaAPI consultaAPI;

    // Constructor
    public Menu() {
        this.sc = new Scanner(System.in);
        this.consultaAPI = new ConsultaAPI();
    }

    // Metodos
    public void iniciar() {
        int opcion;
        do {
            System.out.println("***** BIENVENIDO AL CONVERTIDOR DE MONEDAS *****");
            System.out.println("1. Convertir Moneda");
            System.out.println("2. Obtener Tasas de Cambio");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> realizarConversion();
                case 2 -> tasaDeCambio();
                case 3 -> System.out.println("Finalizando programa...");
                default -> System.out.println("Opción no valida.");
            }
        } while (opcion != 3);
    }

    private void realizarConversion() {
        String monedaOrigen = solicitarMoneda("Ingrese código de moneda de origen (Ej: USD): ");
        String monedaDestino = solicitarMoneda("Ingrese código de moneda de destino (Ej: EUR): ");
        double cantidad = solicitarCantidad("Ingrese cantidad (" + monedaOrigen + ") para convertir a (" + monedaDestino + "): ");

        System.out.println("Conversión lista: " + cantidad + " " + monedaOrigen + " → " + monedaDestino);
    }

    private String solicitarMoneda(String mensaje) {
        String moneda;
        boolean esValida;
        do {
            System.out.print(mensaje);
            moneda = sc.next().toUpperCase();
            esValida = consultaAPI.verificarMoneda(moneda);
            if (!esValida) {
                System.out.println("La moneda ingresada NO es válida. Intente nuevamente.");
            }
        } while (!esValida);
        return moneda;
    }

    private double solicitarCantidad(String mensaje) {
        double cantidad;
        sc.nextLine();
        do {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                cantidad = sc.nextDouble();
                sc.nextLine();
                if (cantidad > 0) {
                    return cantidad;
                } else {
                    System.out.println("El valor debe ser mayor a 0.");
                }
            } else {
                System.out.println("Valor numérico inválido.");
                sc.nextLine();
            }
        } while (true);
    }

    private void tasaDeCambio() {
        System.out.println("Tasa de Cambio");
    }
}
