package es.samujava.pruebas.utilidades;

import java.util.Scanner;

public class Utilidades {

    public static String pideDatoCadena(String texto) {
        Scanner scan = new Scanner(System.in);
        System.out.print(texto + ": ");
        String cadena = scan.nextLine();
        return cadena;
    }
    
}
