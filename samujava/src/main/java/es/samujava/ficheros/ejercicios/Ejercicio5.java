package es.samujava.ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Ejercicio5 {

    public static void main(String[] args) {
        cargarEventosFichero("Z:\\Ficheros\\eventos.txt");
    }

    private static void cargarEventosFichero(String eventsFile) {

        try (Scanner scan = new Scanner(new File(eventsFile))) {
            scan.useDelimiter("\n"); // Le indica que las líneas están separadas por un salto de línea
            // Se ha utilizado el Scanner porque... es más comodo para saltarnos la primera línea
            /*  */
            scan.next();
            while (scan.hasNext()) {
                String linea = scan.next();
                System.out.println(linea);                
                String[] datos = linea.split(",");
                
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = format.parse(datos[2]);
                
                String lugar = datos[3];
                String descripcion = datos[4];
                int duracion = Integer.parseInt(datos[5]);
                double precio = Double.parseDouble(datos[6]);
                String organizador = datos[7];
                //boolean esGratuito = Boolean.parseBoolean(datos[8]);
                boolean esGratuito = datos[8].equals("tue") ? true : false;

                
                Eventos evento = new Eventos(id, nombre, fecha, lugar, descripcion, duracion, precio, organizador, esGratuito);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
