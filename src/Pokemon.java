import java.util.Scanner;

public class Pokemon {
    private String nombre;
    private TipoPokemon tipo;
    private Ataque[] ataques = new Ataque[4];
    private int hp;
    static Scanner scanner = new Scanner(System.in);
    private boolean vivo = true;
    private float aumento = 1.0f;
    private int contador = 0;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public TipoPokemon getTipo() {
        return tipo;
    }
    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }
    public Ataque[] getAtaques() {
        return ataques;
    }
    public void setAtaques(Ataque[] ataques) {
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

    public Pokemon(String nombre, TipoPokemon tipo, Ataque[] ataques, int hp){
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataques = ataques;
        this.hp = hp;
    }

    public void atacar(Pokemon enemigo){
        System.out.println("Tus ataques:");
        for (int i=0; i<ataques.length; i++){
            System.out.println((i+1) + ". " + ataques[i].getNombre());
        }
            while(true){
                if (scanner.hasNextInt()) {
                    int eleccion = scanner.nextInt();
                    if (eleccion>0 && eleccion<=ataques.length){
                        Ataque ataqueElegido = ataques[(eleccion-1)];
                        System.out.println(nombre + ", " + "¡" + ataqueElegido.getNombre() + "!");
                        enemigo.daño(ataqueElegido.getPoder());
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

    public void daño(int poder_atk){
        int atk = (int)(poder_atk * this.aumento);
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

    public void evolucionar(){
        contador++;
        if (contador==1){
            this.aumento = 1.5f;
        } else if (contador==2){
            this.aumento = 2f;
        } else {
            System.out.println("Tu pokemon está en su nivel max.");
        }
        this.hp = (int)(this.hp * this.aumento);
        System.out.println("¡ " + nombre + " ha evolucionado!, hp++ y atk++");
    }
}