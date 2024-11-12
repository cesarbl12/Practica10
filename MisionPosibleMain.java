import java.io.*;
import java.util.Scanner;

public class MisionPosibleMain {
    public static void main(String[] args) {
        Escenario escenario = new Escenario("Escenario", 10);
        String archivoConfiguracion = "C:/Users/cesar/OneDrive/Escritorio/POO/Practica10/configuracion.txt";

        try {
            // Cargar la configuración inicial desde el archivo
            escenario.cargarConfiguracion(archivoConfiguracion);
            System.out.println("Escenario inicial:");
            System.out.println(escenario);

            // Pedir al usuario que ingrese la posición de la bomba para detonar
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la fila de la bomba a detonar: ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna de la bomba a detonar: ");
            int columna = scanner.nextInt();

            // Verificar y detonar la bomba en la posición indicada
            Elemento elemento = escenario.campoDeBatalla[fila][columna];
            if (elemento instanceof Bomba) {
                ((Bomba) elemento).explotar();
            } else {
                System.out.println("No hay una bomba en esa posición.");
            }

            // Mostrar el escenario después de la explosión
            System.out.println("\nEscenario después de la explosión:");
            System.out.println(escenario);

            // Guardar la configuración actual en el archivo
            escenario.guardarConfiguracion(archivoConfiguracion);

        } catch (IOException e) {
            System.out.println("Error al leer o escribir el archivo de configuración: " + e.getMessage());
        }
    }
}