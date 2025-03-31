public class Ataque {
    private Tipo_ataque_pokemon nombre;
    private int poder;

    public Tipo_ataque_pokemon getNombre() {
        return nombre;
    }
    public void setNombre(Tipo_ataque_pokemon nombre) {
        this.nombre = nombre;
    }
    public int getPoder() {
        return poder;
    }
    public void setPoder(int poder) {
        this.poder = poder;
    }

    public Ataque(Tipo_ataque_pokemon nombre, int poder){
        this.nombre = nombre;
        this.poder = poder;
    }
}