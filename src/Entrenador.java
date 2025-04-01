import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
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

    public void nombrarEquipo() {

        System.out.println("Nombre del entrenador: " + nombre);
        System.out.println("************************************");
        System.out.println("Pokemones en el equipo: ");
        for (Pokemon pokemon : equipo) {
             System.out.println("Nombre del pokemon: " + pokemon.getNombre());
                System.out.println("Tipo del pokemon: " + pokemon.getTipo());
                System.out.println("Hp del pokemon: " + pokemon.getHp());
                System.out.println("************************************");
        }
       
    }

    //flujo recomendado primer paso crear entrenador con la clase Entrenador y luego capturar pokemones
    //capturarPokemon() será un método de entrenador
    //capturarPokemon() se encargará de capturar pokemones y agregarlos al equipo
    
//Factory method para capturar un entrenador por consola sin necesidad de instanciar un objeto con new
    public static Entrenador capturarEntrenador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("¡Hola, espero estés listo para comenzar una aventura pokemon!");
        System.out.print("Ingrese el nombre del entrenador: ");
        //trim()  para eliminar los espacios en blanco al inicio y al final de la cadena
        String nombre = scanner.nextLine().trim();
        System.out.println("************************************");
        System.out.println("Bienvenido " + nombre + "!");
        System.out.println("¡Prepárate para capturar Pokémons y convertirte en un maestro Pokémon!");
        System.out.println("************************************");
        System.out.println("Recuerda que solo puedes capturar 3 pokemones por equipo.");
        System.out.println("************************************");
        System.out.println("¡Comencemos!");
        System.out.println("************************************");
        return new Entrenador(nombre);
    }

    public void capturarPokemon() {
        
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            if (equipo.size() == 3) {
                System.out.println("No puedes capturar más pokemones, tu equipo está completo.");
                System.out.println("************************************");
                break;
            }
            else {
                System.out.println("Deseas capturar un Pokémon? (si/no), si no entonces se formará el equipo aleatoriamente");
                String respuesta = scanner.nextLine().toLowerCase();
                System.out.println("************************************");
                if (respuesta.equals("si") ) {
                    int cantidadPokemones = 4;
                    while (cantidadPokemones > 3 || cantidadPokemones < 1) {
                        System.out.println("¿Cuántos pokemones quieres capturar? (entre 1 y 3): ");
                        cantidadPokemones = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        if (cantidadPokemones > 3 || cantidadPokemones < 1) {
                            System.out.println("El número de pokemones debe estar entre 1 y 3.");
                            
                        }
                        
                        System.out.println("************************************");

                    }
                    for (int i = 0; i < cantidadPokemones; i++) {
                        System.out.println("Ingrese el nombre del pokemon: ");
                        String nombrePokemon = scanner.nextLine().trim(); // trim() para eliminar espacios en blanco
                        System.out.println("************************************");
                        System.out.println("Tipos de pokemon disponibles: ");
                        int contador = 1;
                        for (Tipo_ataque_pokemon tipo : Tipo_ataque_pokemon.values()) {
                            System.out.println(contador + ". " + tipo);
                            contador++;
                            
                        }
                        System.out.println("************************************");
                        int tipoPokemon = 0;
                        while (tipoPokemon < 1 || tipoPokemon > Tipo_ataque_pokemon.values().length) {
                            System.out.println("Ingrese el tipo de pokemon (1-" + Tipo_ataque_pokemon.values().length + "): ");
                            tipoPokemon = scanner.nextInt(); // tipoPokemon es un int
                            scanner.nextLine(); // Limpiar el buffer del scanner
                            if ( tipoPokemon < 1 || tipoPokemon > Tipo_ataque_pokemon.values().length) {
                                System.out.println("El tipo de pokemon debe estar entre 1 y " + Tipo_ataque_pokemon.values().length + ".");
                                
                            }
                            System.out.println("************************************");
                            
                        }
                        Tipo_ataque_pokemon tipoPokemon_ = Tipo_ataque_pokemon.values()[tipoPokemon - 1]; // convertir a enum
                        int hpPokemon = 0;
                        while (hpPokemon < 100 || hpPokemon > 200) {
                            System.out.println("Ingrese el hp del pokemon (entre 100 y 200): ");
                            hpPokemon = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer del scanner
                            if (hpPokemon < 100 || hpPokemon > 200) {
                                System.out.println("El hp debe estar entre 100 y 200.");
                            
                            }
                            System.out.println("************************************");

                        }
                        Pokemon pokemon = new Pokemon(nombrePokemon, tipoPokemon_, null, hpPokemon);
                        agregarPokemonEquipo(pokemon); 
                    }
                    nombrarEquipo();
                  
                    break;
                   
                }
                else if (respuesta.equals("no")) {
                    System.out.println("Se formará el equipo aleatoriamente.");
                    System.out.println("************************************");
                    Random random = new Random();
                    int cantidadPokemon = random.nextInt(3) + 1; // Genera un número aleatorio entre 1 y 3
                    for (int i = 0; i < cantidadPokemon; i++) {
                        System.out.println("Ingrese el nombre del pokemon: ");
                        String nombrePokemon = scanner.nextLine().trim(); // trim() para eliminar espacios en blanco
                        System.out.println("************************************");
                        int tipoPokemon = random.nextInt(Tipo_ataque_pokemon.values().length);   
                        Tipo_ataque_pokemon tipoPokemon_ = Tipo_ataque_pokemon.values()[tipoPokemon]; // convertir a enum
                        int hpPokemon = random.nextInt(200-100+1) + 100; // Genera un número aleatorio entre 1 y 100
                        Pokemon pokemon = new Pokemon(nombrePokemon, tipoPokemon_, null, hpPokemon);
                        agregarPokemonEquipo(pokemon);
                    }
                    nombrarEquipo();
                    break;
                } else {
                    System.out.println("Respuesta no válida. Por favor, ingresa 'si' o 'no'.");
                    
            }
        
            }
           
    }
       
        
       
    }
    //agregar un pokemon al equipo
    public void agregarPokemonEquipo(Pokemon pokemon) {
        // cumplir el tamaño de la lista pokemon
        if (equipo.size() <= 3) {
            equipo.add(pokemon);
        } 
    }

    
}


