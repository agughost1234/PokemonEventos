import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pokemon {
    private String nombre;
    private Tipo_ataque_pokemon tipo;
    private ArrayList<Ataque> ataques = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private boolean vivo = true;
    private int hp;
    private float aumento = 1.0f; // CONTROL DE EVOLUCIÓN DE LOS POKEMONES
    private Tipo_ataque_pokemon[] counters;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
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
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public Pokemon(String nombre, Tipo_ataque_pokemon tipo, ArrayList<Ataque> ataques, int hp){
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataques = ataques;
        this.hp = hp;
    }

    public ArrayList<Ataque> capturarAtaques(){
        String respuesta, nombre_atk;
        float poder_atk;
        String[] arsenal;

        for (Tipo_ataque_pokemon clase: Tipo_ataque_pokemon.values()){
            if(this.tipo == clase){
                arsenal = clase.getAtaques();
                counters = clase.getCounter();
                System.out.println("¿Quieres elegir los ataques manualmente? (s/n). Si no, se elegirán automáticamente (¡es más divertido! 🤫)");
                respuesta = scanner.nextLine().toLowerCase();
                while(true){
                    if (respuesta.equals("s")){
                        System.out.println("ATAQUES DISPONIBLES (TIPO " + tipo + ")");
                        for(int i=0; i<=arsenal.length; i++){
                            System.out.println((i+1) + "." + arsenal[i]);
                        }
                        for (int i=0; i<4; i++){
                            System.out.println("Tu ataque # " + (i+1) + " (" + nombre + ")");
                            while(true){
                                if (scanner.hasNextInt()) {
                                    int eleccion = scanner.nextInt();
                                    if (eleccion>0 && eleccion<=arsenal.length){
                                        nombre_atk = arsenal[(eleccion-1)];
                                        poder_atk = aleatorio(100, 10);
                                        ataques.add(new Ataque(nombre_atk, poder_atk));
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
                        break;
                    } else if (respuesta.equals("n")){
                        for (int i=0; i<4; i++){
                            nombre_atk = arsenal[aleatorio(arsenal.length, 0)];
                            poder_atk = aleatorio(100, 10);
                            ataques.add(new Ataque(nombre_atk, poder_atk));
                        }
                        break;
                    } else {
                        System.out.println("Disculpa, ¿Qué dijiste? 🤯");
                    }
                }
                System.out.println("¡Estos serán los ataques de " + nombre + "! (El poder de cada ataque es aleatorio 🎲...)");
                System.out.println(ataques);
            }
        }
        return ataques;
    }

    public Pokemon InstanciarPokemon(){
        System.out.println("¿quien ES ese POKEMON? 🤔🕶️");
        System.out.println("¡Es hora de elegir tu Pokemon!");
        System.out.println("¿Cuál es su nombre?");
        nombre = scanner.nextLine().trim();
        System.out.println("¡Su tipo!");
        int contador = 0;
        for(Tipo_ataque_pokemon clase : Tipo_ataque_pokemon.values()){
            contador++;
            System.out.println(contador + ". " + clase);
        }
        while(true){
            if(scanner.hasNextInt()){
                int eleccion = scanner.nextInt();
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
        ataques = this.capturarAtaques();

        System.out.println("Y sus puntos de salud (HP) serán dados aleatoriamente, ¡Buena suerte!");
        hp = aleatorio(1000, 100);

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

        this.hp = (int)(this.hp * this.aumento);
        System.out.println("¡ " + nombre + " ha evolucionado!, hp++ y atk++");
        }
    }

    public static float aleatorio(float max, float min){
        Random r = new Random(); 
        float resultado = r.nextFloat() * (max - min) + min;
        return resultado;
    }
    public static int aleatorio(int max, int min){
        Random r = new Random(); 
        int resultado = r.nextInt(max - min + 1) + min;
        return resultado;
    }
}