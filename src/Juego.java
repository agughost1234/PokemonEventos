import java.util.Scanner;

public class Juego {
    private static Scanner scanner = new Scanner(System.in);
    private static Entrenador entrenadorActual = null;

    public static void iniciar() {
        System.out.println("****************************************");
        System.out.println("¡Bienvenido al mundo Pokémon!");
        System.out.println("****************************************");

        menu(); // Llama al menú
    }

    private static void menu() {
        while (true) {
            System.out.println("****************************************");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Batallar");
            System.out.println("3. Salir");
            System.out.println("****************************************");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    entrenadorActual = Entrenador.capturarEntrenador();
                    break;

                case "2":
                    batalla();
                    break;

                case "3":
                    System.out.println("****************************************");
                    System.out.println("¡Gracias por jugar, hasta pronto!");
                    System.out.println("****************************************");
                    return;

                default:
                    System.out.println("****************************************");
                    System.out.println("Opción no válida. Por favor elija 1, 2 o 3.");
                    System.out.println("****************************************");
            }
        }
    }

    private static void batalla() {
        System.out.println("****************************************");
        if (entrenadorActual == null) {
            System.out.println("¡Primero debes crear un entrenador!");
        } else {
            System.out.println("¡Aquí irá la lógica de batalla muy pronto!");
        }
        System.out.println("****************************************");
    }
}
