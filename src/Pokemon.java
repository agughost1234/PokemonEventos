import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pokemon extends SerVivo{
    private String nombre;
    private Tipo_ataque_pokemon tipo;
    private ArrayList<Ataque> ataques = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private boolean vivo = true;
    private float hp;
    private float aumento = 1.0f; // CONTROL DE EVOLUCIÓN DE LOS POKEMONES
    private Tipo_ataque_pokemon[] counters;
    private ArrayList<Integer> repetidos = new ArrayList<>();

    public Tipo_ataque_pokemon getTipo() {
        return tipo;
    }
    public void setTipo(Tipo_ataque_pokemon tipo) {
        this.tipo = tipo;
    }
    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }
    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }
    public float getHp() {
        return hp;
    }
    public void setHp(float hp) {
        this.hp = hp;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public Pokemon(String nombre, Tipo_ataque_pokemon tipo, ArrayList<Ataque> ataques, float hp){
        super(nombre);
        this.tipo = tipo;
        this.ataques = ataques;
        this.hp = hp;
    }

    public ArrayList<Ataque> capturarAtaques(Tipo_ataque_pokemon tipo_pokemon, boolean confirmo){
        String nombre_atk;
        float poder_atk;
        String[] arsenal;

        for (Tipo_ataque_pokemon clase: Tipo_ataque_pokemon.values()){
            if(tipo_pokemon == clase){
                arsenal = clase.getAtaques();
                counters = clase.getCounter();
                if (confirmo == true){
                    System.out.println("ATAQUES DISPONIBLES (TIPO " + tipo + ")");
                    for(int i=0; i<arsenal.length; i++){
                        System.out.println((i+1) + "." + arsenal[i]);
                    }
                    // AGREGAR ANOTACIÓN @Deprecated PARA QUE NO JODA i++ jajajajaja
                    for (int i=0; i<4; i++){
                        System.out.println("Tu ataque # " + (i+1) + " (" + nombre + ")");
                        while(true){
                            if (scanner.hasNextInt()) {
                                int eleccion = scanner.nextInt();
                                if (eleccion>0 && eleccion<=arsenal.length){
                                    nombre_atk = arsenal[(eleccion-1)];
                                    poder_atk = aleatorio(100f, 10f);
                                    ataques.add(new Ataque(nombre_atk, poder_atk));
                                } else {
                                    System.out.println("¡Ey! Elige una opción válida");
                                }
                            }
                            else {
                                System.out.println("Por favor, elige un número.");
                                scanner.next();
                            }
                        }
                    }
                } else if (confirmo == false){
                    for (int i=0; i<4; i++){
                        nombre_atk = arsenal[aleatorio(arsenal.length, 0, true)];
                        poder_atk = aleatorio(100f, 10f);
                        ataques.add(new Ataque(nombre_atk, poder_atk));
                    }
                }
            }
        }
        return ataques;
    }

    public Pokemon InstanciarPokemon(boolean confirmo){
        
        int eleccion;
        hp = aleatorio(1000f, 100f);

        System.out.println("¿quien ES ese POKEMON? 🤔🕶️");
        System.out.println("¡Es hora de elegir tu Pokemon!");

        System.out.println("¿Cuál es su nombre?");
        nombre = scanner.nextLine().trim();

        System.out.println("¡Su tipo!");
        if(confirmo == false){
            eleccion = aleatorio(Tipo_ataque_pokemon.values().length, 0, false);
            tipo = Tipo_ataque_pokemon.values()[eleccion];
        } else {
            int contador = 0;
            for(Tipo_ataque_pokemon clase : Tipo_ataque_pokemon.values()){
                contador++;
                System.out.println(contador + ". " + clase);
            }
            while(true){
                if(scanner.hasNextInt()){

                    eleccion = scanner.nextInt();
                    if(eleccion>0 && eleccion<=Tipo_ataque_pokemon.values().length){
                        tipo = Tipo_ataque_pokemon.values()[eleccion-1];
                        break;
                    } else {
                        System.out.println("Por favor, selecciona una opción dentro del rango");
                    }
                } else {
                    System.out.println("¡Elige un número! 😠");
                    scanner.next();
                }
            }
        }

        ataques = this.capturarAtaques(tipo, confirmo);
        System.out.println("Las unidades de vida (HP) y la potencia de cada ataque son aleatorios, ¡Buena suerte!");

        return new Pokemon(nombre, tipo, ataques, hp);
    }

    public void atacar(Pokemon enemigo){
        System.out.println("Tus ataques:");
        for (int i=0; i<ataques.size(); i++){
            System.out.println((i+1) + ". " + ataques.get(i).getNombre());
        }
            while(true){
                if (scanner.hasNextInt()) {
                    int eleccion = scanner.nextInt();
                    if (eleccion>0 && eleccion<=ataques.size()){
                        Ataque ataqueElegido = ataques.get((eleccion-1));
                        System.out.println(nombre + ", " + "¡" + ataqueElegido.getNombre() + "!");
                        enemigo.daño(ataqueElegido.getPoder(), enemigo);
                        // Establecer lógica para dañar al enemigo
                        break;
                    } else {
                        System.out.println("¡Ey! Elige una opción válida");
                    }
                }
                else {
                    System.out.println("Por favor, elige un número.");
                    scanner.next();
                }
            }
    }

    public void daño(float poder_atk, Pokemon enemigo){
        float atk = (float)(poder_atk * this.aumento);
        if(Arrays.asList(counters).contains(enemigo.getTipo())){
            System.out.println("¡Ataque súper efectivo! " + enemigo.getNombre() + "es counter de " + this.getNombre());
            atk *= 1.3f;
        }
        if(atk >= hp){
            hp = 0;
            vivo = false;
            System.out.println("Moriste");
            // Establecer lógica para cuando muera el pokemon
        } else {
            hp -= atk;
            System.out.println(nombre + " ha recibido " + atk + " daño, hp = " + hp);
        }
    }

    public void evolucionar(int contador) {
        if (contador==1){
            this.aumento = 1.5f;
        } else if (contador==2){
            this.aumento = 2f;
        }

        this.hp = (int)(this.hp * this.aumento);
        System.out.println("¡ " + nombre + " ha evolucionado!, hp++ y atk++");
    }

    public static float aleatorio(float max, float min){
        Random r = new Random(); 
        float resultado = r.nextFloat() * (max - min) + min;
        return resultado;
    }
    private int aleatorio(int max, int min, boolean repetirImporta){
        Random r = new Random(); 
        int resultado = r.nextInt(max - min + 1) + min;
        if (repetirImporta == true){
            while(repetidos.contains(resultado)){   
                resultado = r.nextInt(max - min + 1) + min;
            }
            repetidos.add(resultado);
        }
        return resultado;
    }

    @Override
    public void entrada(){
        System.out.println(getNombre() + ", ¡Yo te elijo!");
    }

    @Override
    public void celebracion(){
        System.out.println("🏆");
    }
}