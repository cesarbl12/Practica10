import java.util.ArrayList;

public class Escenario {
    private final int TAMANIO = 10;  // Tamaño del escenario [10x10] Puede modificarse
    private ArrayList<Elemento> elementos;

    public Escenario() {
        this.elementos = new ArrayList<>();
    }

    public void agregarElemento(Elemento elemento) {
        elementos.add(elemento);
    }

    public void mostrarEscenario() {
        // Crear la matriz vacía
        char[][] matriz = new char[TAMANIO][TAMANIO];

        // Inicializar la matriz con puntos (.) que representan espacios vacíos
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                matriz[i][j] = '.';
            }
        }

        // Colocar los elementos en la matriz
        for (Elemento elemento : elementos) {
            Posicion posicion = elemento.getPosicion();
            int fila = posicion.getFila();
            int columna = posicion.getColumna();
            
            // Determinar qué carácter usar para cada tipo de elemento
            if (elemento instanceof Terricola) {
                matriz[fila][columna] = 'T';  // T para Terricola
            } else if (elemento instanceof Extraterreste) {
                matriz[fila][columna] = 'E';  // E para Extraterrestre
            } else if (elemento instanceof Roca) {
                matriz[fila][columna] = 'R';  // R para Roca
            } else if (elemento instanceof Bomba) {
                matriz[fila][columna] = 'B';  // B para Bomba
            }
        }

        // Imprimir la matriz
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();  // Salto de línea después de cada fila
        }
    }

    public void destruirElementos(Bomba bomba) {
        ArrayList<Elemento> elementosADestruir = new ArrayList<>();
        for (Elemento e : elementos) {
            if (e instanceof Destruible && e.getPosicion().distancia(bomba.getPosicion()) <= bomba.getRadioAlcance()) {
                elementosADestruir.add(e);
            }
        }

        for (Elemento e : elementosADestruir) {
            if (e instanceof Destruible) {
                ((Destruible) e).destruir();
            }
        }

        elementos.removeAll(elementosADestruir);
    }
}
