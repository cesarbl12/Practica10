public abstract class Elemento {
    protected Posicion posicion;
    protected String tipo;

    public Elemento(Posicion posicion, String tipo){
        this.posicion = posicion;
        this.tipo = tipo;
    }

    public Posicion getPosicion(){
        return posicion;
    }

    public String getTipo(){
        return tipo;
    }
}
