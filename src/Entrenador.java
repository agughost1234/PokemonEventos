import java.util.Scanner;
import java.util.ArrayList;

public class Entrenador {
    
    private final String nombre;
    private final ArrayList<Pokemon> equipo = new ArrayList<>();

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

//Factory method para capturar un entrenador por consola sin necesidad de instanciar un objeto con new
    public static Entrenador capturarEntrenador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del entrenador: ");
        //trim()  para eliminar los espacios en blanco al inicio y al final de la cadena
        String nombre = scanner.nextLine().trim();
        return new Entrenador(nombre);
    }

    //agregar un pokemon al equipo
    public void agregarPokemon(Pokemon pokemon) {
        // cumplir el tamaño de la lista pokemon
        if (equipo.size() < 3) {
            equipo.add(pokemon);
        } else {
            System.out.println("No se pueden tener más de 3 pokemones en el equipo");
        }
    }

    
}


