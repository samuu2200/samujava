package es.samujava.ficheros.ejercicios;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.utils.UtilidadesFicheros;

public class Ejercicio1Ficheros {
    private static final Logger logger = LoggerFactory.getLogger(Ejercicio1Ficheros.class);
    private static final String DIR_DOCUMENTOS = "documentos";
    private static final String DIR_IMAGENES = "imagenes";
    private static final String DIR_OTROS = "otros";
    public static void main(String[] args) {
        String dirOrigen = "C:\\Users\\Tardes\\Ficheros\\";
        File dirFicheros = new File(dirOrigen);

        if (dirFicheros.exists()){
            logger.info("El directorio "+ dirOrigen + " existe. Creando nuevos directorios si no existieran");

            String [] directorios = {DIR_DOCUMENTOS, DIR_IMAGENES, DIR_OTROS};
            UtilidadesFicheros.crearDirectorios(dirFicheros, directorios);
        }

        File dirOtros = new File(dirOrigen+DIR_OTROS);
        File[] ficherosOtros = dirOtros.listFiles();
        int contador = 0;
        for (File fichero : ficherosOtros) {
            if (fichero.isFile()){
                String extensionFichero = "";
                if (fichero.getName().contains(".")){
                    extensionFichero = fichero.getName().substring(fichero.getName().lastIndexOf("."));
                }else{
                    extensionFichero = ".xml";
                }
                
                String nuevoNombre = "joseluis"+contador+extensionFichero;
                File fileRenamed = new File (dirOtros,nuevoNombre);
                fichero.renameTo(fileRenamed);
                contador++;
            }
        }
    }
    
}
