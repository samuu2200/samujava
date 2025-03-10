package es.samujava.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.ficheros.CrearDirectorios;

public class UtilidadesFicheros {
    private static final Logger logger = LoggerFactory.getLogger(CrearDirectorios.class);
    public static final String SEPARADOR_PIPE = "|";
    
    
    /**
     * Método que nos permite crear ficheros pasando ficheros de tipo File y un arrays de Strings
     * @param dirFicheros
     * @param directorios
     */
    public static void crearDirectorios(File dirFicheros, String[] directorios) {
        crearDirectorios(dirFicheros, Arrays.asList(directorios));
    }

    /**
     * Método que nos permite crear un directorio pasandole una Collection <String> y una tipo File de ficheros 
     * @param dirFicheros
     * @param directorios
     */
    public static void crearDirectorios(File dirFicheros, Collection<String> directorios) {
        for (String directorio : directorios) {
            File documentos = new File(dirFicheros, directorio);
            if (documentos.mkdir()) {
                logger.info("El directorio " + documentos + " se ha creado");
            } else {
                logger.warn("El directorio " + documentos + " no ha creado");
            }
        }
    }

}
