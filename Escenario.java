import java.io.*;
import java.util.*;

public class Escenario {
    private String nombre;
    Elemento[][] campoDeBatalla;
    private int n;

    public Escenario(String nombre, int n) {
        this.n = n;
        campoDeBatalla = new Elemento[n][n];
        this.nombre = nombre;
    }

    // public void mostrarEscenario(){
    //     char [][] matriz = new char[n][n];

    //     for (int i=0; i < n; i++){
    //         for (int j = 0;j< n ; j++){
    //             matriz[i][j] = '.';
    //         }
    //     }
    // }

    public void agregarElemento(Elemento elemento) {
        Posicion posicion = elemento.getPosicion();
        campoDeBatalla[posicion.getRenglon()][posicion.getColumna()] = elemento;
    }

    public void destruirElemento(Posicion posicion, int radio) {
        int renglonCentral = posicion.getRenglon();
        int columnaCentral = posicion.getColumna();

        for (int i = renglonCentral - radio; i <= renglonCentral + radio; i++) {
            for (int j = columnaCentral - radio; j <= columnaCentral + radio; j++) {
                if (i >= 0 && i < n && j >= 0 && j < n && campoDeBatalla[i][j] != null) {
                    Elemento elemento = campoDeBatalla[i][j];
                    if (elemento instanceof Destruible) {
                        ((Destruible) elemento).destruir();
                        campoDeBatalla[i][j] = null;  // Eliminar el elemento del campo después de destruirlo
                    }
                }
            }
        }
    }

    public void removerElemento(Elemento elemento) {
        Posicion posicion = elemento.getPosicion();
        campoDeBatalla[posicion.getRenglon()][posicion.getColumna()] = null;
    }

    public void cargarConfiguracion(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();  // Eliminar espacios en blanco al principio y al final de la línea
                if (linea.isEmpty()) continue;  // Saltar líneas vacías

                String[] partes = linea.split(" ");
                if (partes.length < 3) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue;  // Saltar líneas con formato incorrecto
                }

                String tipoElemento = partes[0];
                int renglon = Integer.parseInt(partes[1]);
                int columna = Integer.parseInt(partes[2]);

                switch (tipoElemento) {
                    case "Roca":
                        if (partes.length == 3) {
                            agregarElemento(new Roca(this, new Posicion(renglon, columna)));
                        } else {
                            System.out.println("Formato incorrecto para Roca en línea: " + linea);
                        }
                        break;
                    case "Extraterrestre":
                        if (partes.length == 3) {
                            agregarElemento(new Extraterrestre("Alien", this, new Posicion(renglon, columna), 1));
                        } else {
                            System.out.println("Formato incorrecto para Extraterrestre en línea: " + linea);
                        }
                        break;
                    case "Bomba":
                        if (partes.length == 4) {
                            int radio = Integer.parseInt(partes[3]);
                            agregarElemento(new Bomba(this, new Posicion(renglon, columna), radio));
                        } else {
                            System.out.println("Formato incorrecto para Bomba en línea: " + linea);
                        }
                        break;
                    case "Terricola":
                        if (partes.length == 3){
                            agregarElemento(new Terricola("Humano", this, new Posicion(renglon, columna)));
                        } else {
                            System.out.println("Formato incorrecto para Bomba en línea: " + linea);
                        }
                    default:
                        System.out.println("Tipo de elemento desconocido: " + tipoElemento);
                }
            }
        }
    }

    public void guardarConfiguracion(String archivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Elemento elemento = campoDeBatalla[i][j];
                    if (elemento != null) {
                        String linea = "";
                        if (elemento instanceof Roca) {
                            linea = "Roca " + i + " " + j;
                        } else if (elemento instanceof Extraterrestre) {
                            linea = "Extraterrestre " + i + " " + j;
                        } else if (elemento instanceof Bomba) {
                            Bomba bomba = (Bomba) elemento;
                            linea = "Bomba " + i + " " + j + " " + bomba.getRadio();
                        }
                        bw.write(linea);
                        bw.newLine();
                    }
                }
            }
        }
    }

     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("Escenario: ").append(nombre).append("\n");

         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 if (campoDeBatalla[i][j] == null) {
                     sb.append("- ");
                 } else {
                     sb.append(campoDeBatalla[i][j].getRepresentacion()).append(" ");
                 }
             }
             sb.append("\n");
         }

         return sb.toString();
     }
}