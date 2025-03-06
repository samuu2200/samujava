package es.samujava.ficheros;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
    	LocalDateTime datetime = LocalDateTime.now();
    	System.out.println(datetime.getYear());
    	System.out.println(datetime.getMonthValue());
    	//System.out.println(datetime.getMonth());
    	
    	Instant instant = Instant.now();
    	System.out.println(instant);
    	//Ruta relativa a la carpeta del proyecto
        String nombreArchivo = "./recursos/java4.txt";
		String archivoSamu = "./recursos/samu" + datetime.getYear() + datetime.getMonthValue() + datetime.getDayOfMonth() + ".txt";

		LocalDate date = LocalDate.now();
		String fechaStr2 = "" + date;

		Date fecha = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");
		String fechaStr3 = df.format(fecha);

		String nombreArchivo3 = "./recursos/samuel_" + fechaStr3 + ".txt";

        ArchivoServicio service = new ArchivoServicio();
        //service.mostrarContenidoDirectorio("C:\\Users\\Tardes\\");
        service.crearArchivo2(nombreArchivo3);
    }
}
