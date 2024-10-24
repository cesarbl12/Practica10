public class MisionPosibleMain {
    public static void main(String[] args) {
        Escenario escenario = new Escenario();
        
        // Agregar elementos al escenario
        escenario.agregarElemento(new Terricola(new Posicion(3, 2)));
        escenario.agregarElemento(new Terricola(new Posicion(0, 9)));
        escenario.agregarElemento(new Extraterreste(new Posicion(3, 5)));
        escenario.agregarElemento(new Roca(new Posicion(4, 3)));
        Bomba bomba = new Bomba(new Posicion(4, 4), 1);
        escenario.agregarElemento(bomba);

        // Mostrar el escenario antes de la explosión
        System.out.println("Escenario antes de la explosión:");
        escenario.mostrarEscenario();

        // Hacer explotar la bomba
        bomba.explotar(escenario);

        // Mostrar el escenario después de la explosión
        System.out.println("Escenario después de la explosión:");
        escenario.mostrarEscenario();
    }
}
