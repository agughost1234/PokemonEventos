public abstract class SerVivo {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SerVivo(String nombre){
        this.nombre = nombre;
    }

    public void entrada(){
        System.out.println("Hola");
    }

    public void celebracion(){
        System.out.println("¡Victoria!");
    }
}
