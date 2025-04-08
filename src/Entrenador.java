import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Entrenador extends SerVivo{
    private final ArrayList<Pokemon> equipo = new ArrayList<>();

    public Entrenador(String nombre) {
        super(nombre);
    }

    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

    public void nombrarEquipo() {

        System.out.println("Nombre del entrenador: " + getNombre());
        System.out.println("************");
        System.out.println("Pokemones en el equipo: ");
        for (Pokemon pokemon : equipo) {
             System.out.println("Nombre del pokemon: " + pokemon.getNombre());
                System.out.println("Tipo del pokemon: " + pokemon.getTipo());
                System.out.println("Hp del pokemon: " + pokemon.getHp());
                System.out.println("************");
        }
       
    }


    
//Factory method para capturar un entrenador por consola sin necesidad de instanciar un objeto con new
    public static Entrenador capturarEntrenador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************");
        System.out.println("¡Hola, espero estés listo para comenzar una aventura pokemon!");
        System.out.print("Ingrese el nombre del entrenador: ");
        //trim()  para eliminar los espacios en blanco al inicio y al final de la cadena
        String nombre = scanner.nextLine().trim();
        System.out.println("************");
        System.out.println("Bienvenido " + nombre + "!");
        System.out.println("¡Prepárate para capturar Pokémons y convertirte en un maestro Pokémon!");
        System.out.println("************");
        System.out.println("¡Comencemos!");
        System.out.println("************");
        return new Entrenador(nombre);
    }

    public void capturarPokemon() {
    // preguntar si quiere crear equipo manualmente o aleatoriamente
    boolean equipoAleatorio = false;
    Scanner scanner = new Scanner(System.in);
    System.out.println("¿Quieres capturar un pokemon? (s/n)");
    String respuesta = scanner.nextLine().trim().toLowerCase();
    while (true) {
        if (respuesta.equals("s")) {
            break;
        } else if (respuesta.equals("n")) {
            equipoAleatorio = true;
            break;
        } else {
            System.out.println("Respuesta no válida. Por favor, ingresa 's' o 'n'.");
            respuesta = scanner.nextLine().trim().toLowerCase();
        }
    }
  for (int i = 0; i < 3; i++) {
      //  equipo.add(Pokemon.instanciarPokemon(equipoAleatorio));
      
  }

} 

    @Override
    public void entrada(){
        System.out.println("Me llamo " + getNombre() + ", ¡Y seré tu contrincante!");
    }

    @Override
    public void celebracion(){
        System.out.println("Eso es, ¡victoria!");
    }
}