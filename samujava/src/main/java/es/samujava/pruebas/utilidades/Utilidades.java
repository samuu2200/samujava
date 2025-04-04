package es.samujava.pruebas.utilidades;

import java.util.Scanner;

public class Utilidades {

    public static String pideDatoCadena(String texto) {
        Scanner scan = new Scanner(System.in);
        System.out.print(texto + ": ");
        String cadena = scan.nextLine();
        return cadena;
    }

    public static int pideDatoInt(String texto) {
        Scanner scan = new Scanner(System.in);
        System.out.print(texto + ": ");
        int numero = scan.nextInt();
        return numero;
    }

    public static double pideDatoDouble(String texto) {
        Scanner scan = new Scanner(System.in);
        System.out.print(texto + ": ");
        double numero = scan.nextInt();
        return numero;
    }

    public static boolean pideDatoBoolean(String texto) {
        Scanner scan = new Scanner(System.in);
        System.out.print(texto + ": ");
        boolean booleano = Boolean.parseBoolean(scan.nextLine());
        return booleano;
    }
    
}
