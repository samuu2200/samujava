package es.samujava.inicio.funciones;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Utilidades {

	public static final String ELIGE_OPCION = "Por favor, elige una opción";
	
	public static int pideDatoNumerico(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();
		
		return numero;
	}
	
	public static double pideDatoDecimal(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		double numero = scan.nextInt();
		
		return numero;
	}

	/**
	 * 
	 * @param texto
	 * @return
	 */
	public static String pideDatoCadena(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		String cadena = scan.nextLine();
		
		return cadena;
	}
	
	
	
	
	public static void pintaMenu (String menuStr) {
		String[] opciones = menuStr.split(";");
		pintaMenu(opciones);
		
	}
	/**
	 * Función que sirve para pintar las opciones de un menú que llegan 
	 * en un array de Strings
	 * @param menuArray Array Strings con las opciones del menú
	 * @author Jose Luis
	 * @since 1.0
	 */
	public static void pintaMenu (String[] menuArray) {
//		for (String opcion : menuArray) {
//			System.out.println(opcion);
//		}
//		System.out.println("Introduce una opción");
		pintaMenu(menuArray,"Introduce una opción");
	}
	
	public static void pintaMenu (String[] menuArray, String texto) {

		for (String opcion : menuArray) {
			System.out.println(opcion);
		}
		System.out.println(texto);
	}
	public static Date fechas(String mensaje) {
		System.out.println(mensaje);
		Date fecha = crearFecha(0, 0, 0);

		return fecha;
		
	}

    // Crea una fecha a partir de año, mes y día
    public static Date crearFecha(int año, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, año);
        calendar.set(Calendar.MONTH, mes - 1); // Enero es 0
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    // Formatea una fecha en formato dd/MM/yyyy
    public static String formatearFecha(Date fecha) {
        if (fecha == null) return "";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }
	
}






