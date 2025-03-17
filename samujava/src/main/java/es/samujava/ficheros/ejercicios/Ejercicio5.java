package es.samujava.ficheros.ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import es.samujava.ficheros.ejercicios.pojos.Eventos;

public class Ejercicio5 {

    public static void main(String[] args) {
        Map<String, List<Eventos>> mapa = cargarEventosFichero("Z:\\Ficheros\\eventos.txt", 1);
        // pintaMapa(mapa);
        try {
            escribirEventosPorCiudad(mapa);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mostrarEventosGratuitosPorCiudad(mapa);
        System.out.println("Termina");
    }

    private static void mostrarEventosGratuitosPorCiudad(Map<String, List<Eventos>> mapa) {
        System.out.println("\n*** Eventos gratuitos por ciudad ***");
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            List<Eventos> eventosCiudad = mapa.get(ciudad);
            for (Eventos evento : eventosCiudad) {
                if (evento.isEsGratuito()) {
                    System.out.println("\t" + ciudad + " " + evento.getNombre());
                }
            }
        }
    }

    private static void escribirEventosPorCiudad(Map<String, List<Eventos>> mapa) throws IOException {
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            Path ruta = Paths.get("./" + ciudad + ".txt");
            List<Eventos> eventosCiudad = mapa.get(ciudad);
            System.out.println("Ciudad: " + ciudad + " con " + eventosCiudad.size());
            StringBuilder sb = new StringBuilder();
            for (Eventos evento : eventosCiudad) {
                sb.append(evento.getNombre() + "\n");
            }
            Files.write(ruta, sb.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        }

    }

    private static void pintaMapa(Map<String, List<Eventos>> mapa) {
        Set<String> ciudades = mapa.keySet();
        for (String ciudad : ciudades) {
            List<Eventos> eventosCiudad = mapa.get(ciudad);
            System.out.println("Ciudad: " + ciudad + " con " + eventosCiudad.size());
            for (Eventos evento : eventosCiudad) {
                System.out.println(evento);
            }
        }
    }

    private static Map<String, List<Eventos>> cargarEventosFichero(String eventsFile, int numLineas) {
        Map<String, List<Eventos>> mapaEventos = new HashMap<>();

        try (Scanner scan = new Scanner(new File(eventsFile))) {
            scan.useDelimiter("\n"); // Le indica que las líneas están separadas por un salto de línea
            // Se ha utilizado el Scanner porque... es más comodo para saltarnos la primera
            // línea
            /*  */
            for (int i = 0; i < numLineas; i++) {
                scan.next();
            }

            while (scan.hasNext()) {
                String linea = scan.next();
                System.out.println(linea);
                String[] datos = linea.split(",");
                // StringTokenizer st = new StringTokenizer(linea, ","); // Con esta manera
                // tenemos un objeto de tipo String
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = null;
                try {
                    fecha = format.parse(datos[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String ciudad = datos[3];
                String descripcion = datos[4];
                int duracion = Integer.parseInt(datos[5]);
                double precio = Double.parseDouble(datos[6]);
                String organizador = datos[7];
                //boolean esGratuito = Boolean.parseBoolean(datos[8]);
      /*           String condicion = datos[8];
                if (condicion.contains("true")) {
                    System.out.println(condicion);
                } */
                boolean esGratuito = datos[8].trim().equals("true") ? true : false;

                Eventos evento = new Eventos(id, nombre, fecha, ciudad, descripcion, duracion, precio, organizador,
                        esGratuito);
                System.out.println(evento);

                if (mapaEventos.get(ciudad) == null) {
                    List<Eventos> eventosCiudad = new ArrayList<>();
                    eventosCiudad.add(evento);
                    mapaEventos.put(ciudad, eventosCiudad);
                } else
                    mapaEventos.get(ciudad).add(evento);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return mapaEventos;
    }

}
