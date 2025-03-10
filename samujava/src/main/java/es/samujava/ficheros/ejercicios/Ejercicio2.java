package es.samujava.ficheros.ejercicios;

import java.io.File;

public class Ejercicio2 {

    public static void main(String[] args) {
        //String directorio = Utilidades.pideDatoCadena("Introduce directorio");
        String directorio = "D:\\ficheros";
        File dir = new File(directorio);
        if (dir.exists() && dir.isDirectory()) {
            pintaFicheros(dir, 0);
            
        }
    }

    private static void pintaFicheros(File dir, int contador) {

        if (contador >= 2) {
            return;
        }
        
        File[] files = dir.listFiles();
        System.out.println(dir.getPath() + "\\");
        for (File file : files) {
            if (file.isFile()) {
                System.out.print("\t" +file.getName() + " - ");
                System.out.print("\t" +file.length() + " - ");
                System.out.println("\t" + (file.isHidden() ? "Archivo oculto" : "Archivo visible"));
            } else {
                System.out.println("\t" + file.getPath() + "\\");
                // recursividad
                pintaFicheros(file, contador++);
                
            }
        }
    }

}
