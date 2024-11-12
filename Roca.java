public class Roca extends Elemento {
    public Roca(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);  
    }


    public char getRepresentacion() {
        return 'R';  // Representación de la roca en el campo de batalla
    }
}