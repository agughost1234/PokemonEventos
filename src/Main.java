public class Main {
    public static void main(String[] args) throws Exception {
        
        Entrenador e1 = Entrenador.capturarEntrenador();
        Entrenador e2 = Entrenador.capturarEntrenador();
        Batalla.batallaPorEquipos(e1, e2);
    }
}
