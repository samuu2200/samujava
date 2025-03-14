package es.samujava.ficheros;

import java.io.IOException;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        //String nombreArchivo = "D:\\Cursos\\Java\\archivo\\java.txt";
    	String nombreArchivo = "./recursos/java3.txt";
        ArchivoServicio servicio = new ArchivoServicio();

        
        try {
			System.out.println(servicio.leerArchivo3(nombreArchivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
