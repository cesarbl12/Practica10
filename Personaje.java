public abstract class Personaje extends Elemento{

    protected int puntosDeVida=100;
    protected String nombre;

    public Personaje(Posicion posicion, String tipo){
        super(posicion, tipo);
    }    

    public String getNombre(){
        return nombre;
    }
}
