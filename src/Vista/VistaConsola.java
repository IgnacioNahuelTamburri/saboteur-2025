package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Controlador.Controlador;
public class VistaConsola {

    private Controlador controlador;
    private Scanner scanner = new Scanner(System.in);

    public VistaConsola (Controlador controlador){
        this.controlador = controlador;
        mostrarMenu();
    }

    private void mostrarMenu() {
        int opcion;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Iniciar Juego");
            System.out.println("3. Cargar Partida");
            System.out.println("4. Configuración");
            System.out.println("5. Acerca de");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    iniciarJuego();
                    break;
                case 3:
                    cargarPartida();
                    break;
                case 4:
                    configuracion();
                    break;
                case 5:
                    acercaDe();
                    break;
                case 6:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();

        } while (opcion != 6);
    }

    private void crearJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        controlador.agregarJugador(nombre);
        System.out.println("Jugador '" + nombre + "' creado correctamente.");
    }

    private void iniciarJuego() {
        if (controlador.cantJugadores() == 0) {
            System.out.println("Debe crear al menos un jugador antes de iniciar.");
            return;
        }

        System.out.println("Iniciando juego con los jugadores: " + controlador.getJugadores());
        // Aquí llamás a tu lógica de inicio de partida
    }

    private void cargarPartida() {
        System.out.println("Función de cargar partida aún no implementada.");
        // Lógica futura
    }

    private void configuracion() {
        System.out.println("Opciones de configuración próximamente...");
        // Lógica futura
    }

    private void acercaDe() {
        System.out.println("Juego Saboteur - Proyecto Java 2025");
        System.out.println("Desarrollado por Nahuel Tamburri");
    }

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    /*
    public static CartaTunel parse(String s) {
    // Separar por espacios → ["N:true", "E:false", ...]
    String[] partes = s.split(" ");

    boolean n = false, e = false, o = false, su = false, c = false;

    for (String p : partes) {
        String[] kv = p.split(":"); // ejemplo → ["N", "true"]
        String clave = kv[0];
        boolean valor = Boolean.parseBoolean(kv[1]);

        switch (clave) {
            case "N": n = valor; break;
            case "E": e = valor; break;
            case "O": o = valor; break;
            case "S": su = valor; break;
            case "C": c = valor; break;
            default:
                throw new IllegalArgumentException("Clave inválida en cadena: " + clave);
        }
    }

    return new CartaTunel(n, o, e, su, c);
}

     */
}
