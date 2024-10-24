public class Bomba extends Elemento implements Destruible{
    private int radioAlcance;
    
    public Bomba(Posicion posicion, int radioAlcance){
        super(posicion, "Bomba");
        this.radioAlcance = radioAlcance;
    }

    @Override
    public void destruir(){
        System.out.println("Bomba Explotada");
    }

    public void explotar(Escenario escenario){
        System.out.println("Explotando bomba...");
        escenario.destruirElementos(this);
    }

    public int getRadioAlcance(){
        return radioAlcance;
    }
}
