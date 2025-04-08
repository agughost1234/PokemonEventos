import java.util.Scanner;
import java.util.ArrayList;

public class Entrenador extends SerVivo{
    private final ArrayList<Pokemon> equipo = new ArrayList<>();
    private static final ArrayList<Entrenador> entrenadores = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public Entrenador(String nombre) {
        super(nombre);
        entrenadores.add(this);

      
    }

    static {

    // // Entrenador 1: Ash
    // Entrenador ash = new Entrenador("Ash Ketchum");
    // ash.getEquipo().add(new Pokemon("Charizard", Tipo_ataque_pokemon.FUEGO, Ataque.obtenerLista(Tipo_ataque_pokemon.FUEGO), 120f));
    // ash.getEquipo().add(new Pokemon("Pikachu", Tipo_ataque_pokemon.ELECTRICO, Ataque.obtenerLista(Tipo_ataque_pokemon.ELECTRICO), 100f));
    // ash.getEquipo().add(new Pokemon("Squirtle", Tipo_ataque_pokemon.AGUA, Ataque.obtenerLista(Tipo_ataque_pokemon.AGUA), 95f));
    // entrenadores.add(ash);

    // // Entrenador 2: Misty
    // Entrenador misty = new Entrenador("Misty");
    // misty.getEquipo().add(new Pokemon("Staryu", Tipo_ataque_pokemon.AGUA, Ataque.obtenerLista(Tipo_ataque_pokemon.AGUA), 90f));
    // misty.getEquipo().add(new Pokemon("Vaporeon", Tipo_ataque_pokemon.AGUA, Ataque.obtenerLista(Tipo_ataque_pokemon.AGUA), 110f));
    // misty.getEquipo().add(new Pokemon("Bellossom", Tipo_ataque_pokemon.PLANTA, Ataque.obtenerLista(Tipo_ataque_pokemon.PLANTA), 100f));
    // entrenadores.add(misty);

    // // Entrenador 3: Brock
    // Entrenador brock = new Entrenador("Brock");
    // brock.getEquipo().add(new Pokemon("Onix", Tipo_ataque_pokemon.TIERRA, Ataque.obtenerLista(Tipo_ataque_pokemon.TIERRA), 130f));
    // brock.getEquipo().add(new Pokemon("Graveler", Tipo_ataque_pokemon.TIERRA, Ataque.obtenerLista(Tipo_ataque_pokemon.TIERRA), 105f));
    // brock.getEquipo().add(new Pokemon("Magcargo", Tipo_ataque_pokemon.FUEGO, Ataque.obtenerLista(Tipo_ataque_pokemon.FUEGO), 95f));
    // entrenadores.add(brock);

    // // Entrenador 4: Gary
    // Entrenador gary = new Entrenador("Gary");
    // gary.getEquipo().add(new Pokemon("Arcanine", Tipo_ataque_pokemon.FUEGO, Ataque.obtenerLista(Tipo_ataque_pokemon.FUEGO), 125f));
    // gary.getEquipo().add(new Pokemon("Blastoise", Tipo_ataque_pokemon.AGUA, Ataque.obtenerLista(Tipo_ataque_pokemon.AGUA), 120f));
    // gary.getEquipo().add(new Pokemon("Electivire", Tipo_ataque_pokemon.ELECTRICO, Ataque.obtenerLista(Tipo_ataque_pokemon.ELECTRICO), 110f));
    // entrenadores.add(gary);

    // // Entrenador 5: Jessie (Equipo Rocket)
    // Entrenador jessie = new Entrenador("Jessie");
    // jessie.getEquipo().add(new Pokemon("Wobbuffet", Tipo_ataque_pokemon.TIERRA, Ataque.obtenerLista(Tipo_ataque_pokemon.TIERRA), 100f));
    // jessie.getEquipo().add(new Pokemon("Dustox", Tipo_ataque_pokemon.PLANTA, Ataque.obtenerLista(Tipo_ataque_pokemon.PLANTA), 95f));
    // jessie.getEquipo().add(new Pokemon("Seviper", Tipo_ataque_pokemon.TIERRA, Ataque.obtenerLista(Tipo_ataque_pokemon.TIERRA), 105f));
    // entrenadores.add(jessie);

    // // Entrenador 6: James (Equipo Rocket)
    // Entrenador james = new Entrenador("James");
    // james.getEquipo().add(new Pokemon("Weezing", Tipo_ataque_pokemon.TIERRA, Ataque.obtenerLista(Tipo_ataque_pokemon.TIERRA), 105f));
    // james.getEquipo().add(new Pokemon("Cacnea", Tipo_ataque_pokemon.PLANTA, Ataque.obtenerLista(Tipo_ataque_pokemon.PLANTA), 100f));
    // james.getEquipo().add(new Pokemon("Mime Jr.", Tipo_ataque_pokemon.ELECTRICO, Ataque.obtenerLista(Tipo_ataque_pokemon.ELECTRICO), 90f));
    // entrenadores.add(james);


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

    public void mostrarEntrenadores() {
        System.out.println("Entrenadores disponibles:");
        for (Entrenador entrenador : entrenadores) {
            entrenador.nombrarEquipo();
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
        
        Entrenador entrenador = new Entrenador(nombre);
        // Llamar al método para capturar Pokémon
        entrenador.capturarPokemon();
        // Llamar al método para nombrar el equipo
        entrenador.nombrarEquipo();
        return entrenador;
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
       Pokemon pokemon = new Pokemon(null, null, null, i);
        // Agregar el Pokémon al equipo
        equipo.add(pokemon.InstanciarPokemon(equipoAleatorio));
        
      
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

    public static ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }
   
}

