package es.samujava.ficheros;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.pruebas.utilidades.Utilidades;

public class CrearDirectorios {

    private static final Logger logger = LoggerFactory.getLogger(CrearDirectorios.class);

    public static void main(String[] args) {
        // Constructor con el directorio local
        final File DIRECTORIO_LOCAL = new File("C:\\Users\\Tardes.GET-05.000\\ficheros");

        // Constructor donde le pasamos el directorio y el nombre del directorio
        // Directorio imagenes
        File directorioImagenes = new File(DIRECTORIO_LOCAL, "\\imagenes");
        directorioImagenes.mkdir();

        // Directorio documentos
        File directorioDocumentos = new File(DIRECTORIO_LOCAL, "\\documentos");
        directorioDocumentos.mkdir();

        // Directorio otros
        File directorioOtros = new File(DIRECTORIO_LOCAL, "\\otros");
        directorioOtros.mkdir();

        // Vamos a preguntar por 5 nombres de ficheros
        for (int i = 0; i < 5; i++) {
            String nombresFicheros = Utilidades.pideDatoCadena("¿Qué archivo quieres crear?");
            // Si el archivo tiene la extención de una imagen la metemos en la carpeta
            // "imagenes"
            boolean extencionImg = nombresFicheros.endsWith(".jpg") || nombresFicheros.endsWith(".png")
                    || nombresFicheros.endsWith(".gif");
            boolean extencionTxt = nombresFicheros.endsWith(".txt");
            File nuevoFichero;

            if (extencionImg) {
                nuevoFichero = new File(directorioImagenes, nombresFicheros);
            } else if (extencionTxt) {
                nuevoFichero = new File(directorioDocumentos, nombresFicheros);
            } else {
                nuevoFichero = new File(directorioOtros, nombresFicheros);
            }

            try {
                if (nuevoFichero.createNewFile()) {
                    logger.info("-Se ha creado con exito: " + nuevoFichero.getAbsolutePath());
                } else {
                    logger.info("-El directorio ya existe.");
                }
            } catch (IOException e) {
                logger.error("-No se ha podido crear el fichero correctamente: ", e.getMessage());
            }
        }

        // Renombramos todos los ficheros que están dentro de "otros"
        System.out.println("*** Renombrar los archivos que estén en 'otros' ***");

    }

}

/*
 * 1. Preguntar por un directorio
 * 2. Si existe vamos a listar el directorio
 * 3. Y si hay directorio dentro, listamos también el directorio que hay por
 * dentro (máx 2)
 * 4. De cada fichero vamos a sacar el nombre, tamañao y si es oculto o no
 */
