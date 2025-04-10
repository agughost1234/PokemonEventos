import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pokemon extends SerVivo{
    private Tipo_ataque_pokemon tipo;
    private ArrayList<Ataque> ataques = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private boolean vivo = true;
    private float hp;
    private float aumento = 1.0f; // CONTROL DE EVOLUCIÓN DE LOS POKEMONES

    public TipoAtaquePokemon getTipo() {
        return tipo;
    }
    public void setTipo(TipoAtaquePokemon tipo) {
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

    public Pokemon(String nombre, TipoAtaquePokemon tipo, ArrayList<Ataque> ataques, float hp){
        super(nombre);
        this.tipo = tipo;
        this.ataques = ataques;
        this.hp = hp;
    }

    public static ArrayList<Ataque> capturarAtaques(Tipo_ataque_pokemon tipo_pokemon, boolean confirmo, String nombre_pokemon){
        String nombre_atk;
        float poder_atk;
        int eleccion;
        String[] arsenal;
        ArrayList<Ataque> ataques = new ArrayList<>();
        ArrayList<Integer> repetidos = new ArrayList<>();

        for (TipoAtaquePokemon clase: TipoAtaquePokemon.values()){
            if(tipo_pokemon == clase){
                arsenal = clase.getAtaques();
                if (confirmo == true){
                    System.out.println("ATAQUES DISPONIBLES (TIPO " + tipo_pokemon + ")");
                    for(int i=0; i<arsenal.length; i++){
                        System.out.println((i+1) + "." + arsenal[i]);
                    }
                    for (int i=0; i<4; i++){
                        System.out.println("Tu ataque # " + (i+1) + " (" + nombre_pokemon + ")");
                        while(true){
                            if (scanner.hasNextInt()){
                                eleccion = scanner.nextInt();
                                scanner.nextLine();
                                if(repetidos.contains(eleccion)){
                                    while(repetidos.contains(eleccion)){
                                        System.out.println("¡Selecciona un ataque diferente!");
                                        eleccion = scanner.nextInt();
                                        scanner.nextLine();
                                    }
                                }
                                repetidos.add(eleccion);
                                if (eleccion>0 && eleccion<=arsenal.length){
                                    nombre_atk = arsenal[(eleccion-1)];
                                    poder_atk = aleatorioFloat(100f, 10f);
                                    ataques.add(new Ataque(nombre_atk, poder_atk));
                                    break;
                                } else {
                                    System.out.println("¡Ey! Elige una opción válida");
                                }
                            } else {
                                System.out.println("Por favor, elige un número.");
                            }
                        }
                    }
                } else if (confirmo == false){
                    for (int i=0; i<4; i++){
                        nombre_atk = arsenal[aleatorioInt(arsenal.length, 0, true)];
                        poder_atk = aleatorioFloat(100f, 10f);
                        ataques.add(new Ataque(nombre_atk, poder_atk));
                    }
                }
            }
        }
        return ataques;
    }

    public static Pokemon InstanciarPokemon(boolean confirmo){

        int hp_pokemon;
        Tipo_ataque_pokemon tipo_pokemon;
        String nombre_pokemon;
        ArrayList<Ataque> ataques_pokemon = new ArrayList<>();
    
        hp_pokemon = aleatorioInt(1000, 100, false);

        System.out.println("¿quien ES ese POKEMON? 🤔🕶️");
        System.out.println("¡Es hora de elegir tu Pokemon!");

        System.out.println("¿Cuál es su nombre?");
        nombre_pokemon = scanner.nextLine().trim();

        tipo_pokemon = Pokemon.elegirTipo(confirmo);
        ataques_pokemon = Pokemon.capturarAtaques(tipo_pokemon, confirmo, nombre_pokemon);
        System.out.println("Las unidades de vida (HP) y la potencia de cada ataque son aleatorios, ¡Buena suerte!");

        return new Pokemon(nombre_pokemon, tipo_pokemon, ataques_pokemon, hp_pokemon);
    }

    public static Tipo_ataque_pokemon elegirTipo(boolean confirmo){
        int eleccion;
        Tipo_ataque_pokemon tipo_pokemon;

        if(confirmo == false){
            eleccion = aleatorioInt(Tipo_ataque_pokemon.values().length, 0, false);
            tipo_pokemon = Tipo_ataque_pokemon.values()[eleccion];
        } else {
            System.out.println("¡Su tipo!");
            int contador = 0;
            for(TipoAtaquePokemon clase : TipoAtaquePokemon.values()){
                contador++;
                System.out.println(contador + ". " + clase);
            }
            while(true){
                if(scanner.hasNextInt()){
                    eleccion = scanner.nextInt();
                    scanner.nextLine();
                    if(eleccion>0 && eleccion<=Tipo_ataque_pokemon.values().length){
                        tipo_pokemon = Tipo_ataque_pokemon.values()[eleccion-1];
                        break;
                    } else {
                        System.out.println("Por favor, selecciona una opción dentro del rango");
                    }
                } else {
                    System.out.println("¡Elige un número! 😠");
                }
            }
        }
        return tipo_pokemon;
    }

    public void atacar(Pokemon enemigo){
        System.out.println("Tus ataques (" + this.getNombre() + "):");
        for (int i=0; i<ataques.size(); i++){
            System.out.println((i+1) + ". " + ataques.get(i).getNombre() + " - daño: " + ataques.get(i).getPoder());
        }
            while(true){
                if (scanner.hasNextInt()) {
                    int eleccion = scanner.nextInt();
                    scanner.nextLine();
                    if (eleccion>0 && eleccion<=ataques.size()){
                        Ataque ataqueElegido = ataques.get((eleccion-1));
                        System.out.println(this.getNombre() + ", " + "¡" + ataqueElegido.getNombre() + "!");
                        enemigo.daño(ataqueElegido.getPoder(), this);
                        break;
                    } else {
                        System.out.println("¡Ey! Elige una opción válida");
                    }
                }
                else {
                    System.out.println("Por favor, elige un número.");
                }
            }
    }

    public void daño(float poder_atk, Pokemon enemigo){
        Tipo_ataque_pokemon[] counters;
        counters = this.getTipo().getCounter();

        float atk = (float)(poder_atk * this.aumento);
        if(Arrays.asList(counters).contains(enemigo.getTipo())){
            System.out.println("¡Ataque súper efectivo! " + enemigo.getNombre() + " es counter de " + this.getNombre());
            atk *= 1.3f;
        }
        if(atk >= this.hp){
            this.hp = 0;
            vivo = false;
            System.out.println(this.getNombre() + " ha sido derrotado...");
        } else {
            this.hp -= atk;
            System.out.println(this.getNombre() + " ha recibido " + atk + " daño, hp = " + hp);
        }
    }

    public void evolucionar(int contador) {
        if (contador==1){
            this.aumento = 1.5f;
        } else if (contador==2){
            this.aumento = 2f;
        }
        this.hp = (float)(this.hp * this.aumento);
        System.out.println("¡ " + this.getNombre() + " ha evolucionado!, hp++ y atk++");
    }

    public static float aleatorioFloat(float max, float min){
        Random r = new Random(); 
        float resultado = r.nextFloat() * (max - min) + min;
        return resultado;
    }

    private static int aleatorioInt(int max, int min, boolean repetirImporta){
        ArrayList<Integer> repetidos = new ArrayList<>();
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
        System.out.println("Yupii");
    }
}