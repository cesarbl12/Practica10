public class Terricola extends Personaje {

    public Terricola(String nombre, Escenario escenario, Posicion posicion) {
        super(nombre, escenario, posicion);  
    }


    public char getRepresentacion() {
        return 'T';  // Representación del Terricola en el campo de batalla
    }
}