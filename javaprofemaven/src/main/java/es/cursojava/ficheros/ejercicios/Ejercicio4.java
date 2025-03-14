package es.cursojava.ficheros.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        String dirQuijote = "C:\\Users\\Tardes.GET-05.000\\ficheros\\Quijote.txt";

        try {
            leerArchivo3(dirQuijote);
            leerArchivoNombre(dirQuijote);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static void leerArchivo3(String nombre) throws IOException {
        int contador = 0;
        Path path = Paths.get(nombre);
        StringBuilder sb = new StringBuilder();

        List<String> lines = Files.readAllLines(path);
        for (String linea : lines) {
            contador++;
            sb.append(linea + "\n");
        }

        String lineasContadas = "Líneas total contadas: " + contador;
        System.out.println(lineasContadas);
    }

    public static void leerArchivoNombre(String nombre) throws IOException {
        int contador = 0;
        Path path = Paths.get(nombre);
        StringBuilder sb = new StringBuilder();

        List<String> lines = Files.readAllLines(path);
        for (String linea : lines) {
            String[] numLineas = linea.split(" ");
            for (String palabra : numLineas) {
                String nombreBusqueda = "quijote";
                      
                if (palabra.toLowerCase().contains(nombreBusqueda)){
                    contador++;
                }
                sb.append(linea + "\n");
            }
        }

        String lineasContadas = "Veces que se repite el Quijote: " + contador;
        System.out.println(lineasContadas);
    }

}
