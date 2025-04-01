public class Main {
    public static void main(String[] args) throws Exception {
        // Idea crear clase menu para el menú principal y otra para el juego...
        System.out.println("Bienvenido al juego de Pokemon!");
        System.out.println("************************************");
         // Crear un objeto de la clase Entrenador
         Entrenador entrenador = Entrenador.capturarEntrenador();
         //Llamar al método capturarPokemon() para crear el equipo
       entrenador.capturarPokemon(); 
         
    }
       
}
