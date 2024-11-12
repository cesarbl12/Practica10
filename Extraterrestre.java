public class Extraterrestre extends Personaje {

    // Constructor que inicializa al Extraterrestre con nombre, escenario, posición y puntos de vida
    public Extraterrestre(String nombre, Escenario escenario, Posicion posicion, int puntosDeVida) {
        super(nombre, escenario, posicion);  // Llama al constructor de la clase base Personaje
    }


    public char getRepresentacion() {
        return 'E';  // Representación del Extraterrestre en el campo de batalla
    }


}