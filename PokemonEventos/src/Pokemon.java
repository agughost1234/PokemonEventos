import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
    private String nombre;
    private tipos tipo;
    private ArrayList<Ataque> ataques = new ArrayList<>();
    private int ph;
    private boolean vivo = true;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public tipos getTipo() {
        return tipo;
    }
    public void setTipo(tipos tipo) {
        this.tipo = tipo;
    }
    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }
    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }
    public int getPh() {
        return ph;
    }
    public void setPh(int ph) {
        this.ph = ph;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public Pokemon(String nombre, tipos tipo, ArrayList<Ataque> ataques, int ph){
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataques = ataques;
        this.ph = ph;
    }

    public void atacar(){
        Scanner scanner = new Scanner(System.in);
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
                        ataqueElegido.PotenciaAtaque();
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
        scanner.close();
    }

    public void daño(int poder_atk){
        if(poder_atk > ph){
            ph = 0;
            vivo = false;
            System.out.println("Moriste");
            // Establecer lógica para cuando muera el pokemon
        } else {
            ph -= poder_atk;
            System.out.println(nombre + "ha recibido " + poder_atk + " daño, ph = " + ph);
        }
    }
}