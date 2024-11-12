public class Bomba extends Elemento implements Destruible {
    private int radio;

    public Bomba(Escenario escenario, Posicion posicion, int radio) {
        super(escenario, posicion);
        this.radio = radio;
    }

    public void explotar() {
        System.out.println("Explotando bomba!!");
        escenario.destruirElemento(posicion, radio);  // Destruye elementos dentro del radio
        destruir();  // La bomba se destruye después de explotar
    }
    public int getRadio() {
        return radio;
    }

    @Override
    public void destruir() {
        System.out.println("Bomba destruida");
        escenario.removerElemento(this);  // Remueve la bomba del escenario
    }

    @Override
    public char getRepresentacion() {
        return 'B';  // Representación de la bomba en el campo de batalla
    }
}