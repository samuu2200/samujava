package es.samujava.ficheros;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.pruebas.utilidades.Utilidades;
import es.samujava.utils.UtilidadesFicheros;

public class CrearDirectorios {

    private static final Logger logger = LoggerFactory.getLogger(CrearDirectorios.class);
    private static final String DIR_DOCUMENTOS = "documentos";
    private static final String DIR_IMAGENES = "imagenes";
    private static final String DIR_OTROS = "otros";

    public static void main(String[] args) {
        // Constructor con el directorio local
        String dirOrigen = "C:\\Users\\Tardes.GET-05.000\\ficheros\\";
        final File DIRECTORIO_LOCAL = new File(dirOrigen);

        if (DIRECTORIO_LOCAL.exists()) {
            logger.info("El directorio " + dirOrigen + " existe");

            String[] directorios = { DIR_DOCUMENTOS, DIR_IMAGENES, DIR_OTROS };
            UtilidadesFicheros.crearDirectorios(DIRECTORIO_LOCAL, directorios);

        }

        for (int i = 0; i < 5; i++) {
            String nombreFichero = Utilidades.pideDatoCadena("Introduce nombre del fichero " + (i + 1));

            String extensionFichero = nombreFichero.substring(nombreFichero.lastIndexOf("."));
            logger.info("La extensión del fichero " + nombreFichero + " es " +
                    extensionFichero);

            String directorioDestinos;

            if (extensionFichero.equals(".txt")) {
                directorioDestinos = dirOrigen + DIR_DOCUMENTOS;
            } else if (extensionFichero.equals(".jpg") ||
                    extensionFichero.equals(".png")) {
                directorioDestinos = dirOrigen + DIR_IMAGENES;
            } else {
                directorioDestinos = dirOrigen + DIR_OTROS;
            }

            File ficheroDocumento = new File(directorioDestinos, nombreFichero);
            try {
                ficheroDocumento.createNewFile();
                logger.info("Fichero " + ficheroDocumento + " se ha creado correctamente");
            } catch (IOException e) {
                logger.error("No se ha creado el fichero ", e.getMessage());
            }
        }

        // Renombrar los archivos que estén en otros
        File dirOtros = new File(dirOrigen + DIR_OTROS);
        File[] ficherosOtros = dirOtros.listFiles();
        int contador = 0;
        for (File fichero : ficherosOtros) {
            String extensionFichero = "";
            if (fichero.isFile()) {
                // Si el fichero no teremina con punto, pues que lo coja
                if (fichero.getName().contains(".")) {
                    extensionFichero = fichero.getName().substring(fichero.getName().lastIndexOf("."));
                } else {
                    extensionFichero = ".xml";
                }

                String nuevoNombre = "Samuel" + contador + extensionFichero;
                File fileRename = new File(dirOtros, nuevoNombre);
                fichero.renameTo(fileRename);
                contador++;
            }
        }

    }

}

/*
 * 1. Preguntar por un directorio
 * 2. Si existe vamos a listar el directorio
 * 3. Y si hay directorio dentro, listamos también el directorio que hay por
 * dentro (máx 2)
 * 4. De cada fichero vamos a sacar el nombre, tamañao y si es oculto o no
 */
