public class Posicion{
    private int fila;
    private int columna;

    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    //calcula la distancia entre dos posiciones
    public double distancia(Posicion otra){
        return Math.sqrt(Math.pow(this.fila - otra.getFila(), 2) + Math.pow(this.columna - otra.getColumna(), 2));
    }
}