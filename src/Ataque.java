public class Ataque {
    private TipoAtaque nombre;
    private int poder;

    public TipoAtaque getNombre() {
        return nombre;
    }
    public void setNombre(TipoAtaque nombre) {
        this.nombre = nombre;
    }
    public int getPoder() {
        return poder;
    }
    public void setPoder(int poder) {
        this.poder = poder;
    }

    public Ataque(TipoAtaque nombre, int poder){
        this.nombre = nombre;
        this.poder = poder;
    }

    public void potenciaAtaque(Pokemon pokemon){
        pokemon.daño(poder);
    }
}