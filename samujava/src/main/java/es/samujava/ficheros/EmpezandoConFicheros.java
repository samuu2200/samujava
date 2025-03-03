package es.samujava.ficheros;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.Main;

public class EmpezandoConFicheros {
    private static final Logger logger = LoggerFactory.getLogger(EmpezandoConFicheros.class);
    public static void main(String[] args) {
        //Constructor File
        File directorio = new File("C:\\Users\\Tardes.GET-05.000\\ficheros");
        File fichero = new File("C:\\Users\\Tardes.GET-05.000\\ficheros\\fichero1.txt");
        System.out.println("\n*** Directorio ***");
        System.out.println("\t-Es un directorio: " + directorio.isDirectory()); // False
        System.out.println("\t-Es un fichero: " + directorio.isFile()); // True

        System.out.println("\n*** Fichero ***");
        System.out.println("\t-Es un directorio: " + fichero.isDirectory()); // True
        System.out.println("\t-Es un fichero: " + fichero.isFile()); // False

        System.out.println("\n*** Fichero existe ***");
        System.out.println("\t-Es un fichero: " + fichero.isFile()); // True
        System.out.println("\t-Existe el fichero: " + fichero.exists()); // True

        System.out.println("\n*** Crea 10 directorios ***");
        for (int i = 0; i < 11; i++) {
            File directorioNuevo = new File(directorio, "\\subdir" + i); // Llamamos al constructor donde le pasamos el directorio donde queremos crear el directorio con el nombre "subdir"
            if (!directorioNuevo.exists()) { // Si no existe los crea
                System.out.println("¡Se ha creado un fichero nuevo!");
                directorioNuevo.mkdir();
            }
        }

        System.out.println("\n*** Listar un directorio ***");
        String[] listaDirectorio = directorio.list(); // Devuelve un array de String de Listados los directorios y fichero donde se está ejecutando la lista
        for (String nombres : listaDirectorio) {
            System.out.println(nombres);
            File file1 = new File(directorio, "subdir1"); // Creamos un objeto para acceder a la ruta y poder acceder al fichero
            file1.delete();
        }

        System.out.println("\n*** Listamos un directorio listFile ***");
        File[] listaFicheros = directorio.listFiles(); // Nos devuelve un array tipo File donde ya podemos acceder a los objetos y manipular los ficheros 
        for (File ficheros : listaFicheros) {
            System.out.println(ficheros.delete());
        }

/*         String rutaFichero = fichero.getAbsolutePath();
        System.out.println(rutaFichero); */

        System.out.println("\n*** Creamos un fichero dentro de la ruta del diretorio ***");
        File fichero2 = new File("C:\\Users\\Tardes.GET-05.000\\ficheross\\fichero2.txt");
        try {
            fichero2.createNewFile();
        } catch (IOException e) {
            logger.error("Error al crear el fichero " + fichero2.getAbsolutePath() + ": " + e.getMessage(), e);
            // Usamos El nombre del objeto logger.error, para controlar las excepciones con logs en el programa
        }

        /* 
         * 1. Crear el directorio imágenes, el directorio documentos y el directorio "otros"
         * 2. Vamos a preguntar por 5 nombres de ficheros
         * 3. Si el fichero tiene la extención de una imagen "jpg, png, gif", Si el fichero es una imagen los metemos en el directorio imágnees 
         * 4. Si el fichero es un .txt en documentos
         * 5. Si no es una imagen ni un documento lo metemos en "otros"
         * 6. Después de todo, coger todos los directorios que hay en otros y renombrarlos con nuestro nombre, manteniendo la extención que tiene el fichero
         */
    }

}
