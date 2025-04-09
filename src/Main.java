public class Main {

    public static void main(String[] args) throws Exception {
        Entrenador entrenador = Entrenador.capturarEntrenador();
        entrenador.capturarPokemon();
        entrenador.nombrarEquipo();
    }
}
