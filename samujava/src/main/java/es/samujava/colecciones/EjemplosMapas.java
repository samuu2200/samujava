package es.samujava.colecciones;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EjemplosMapas {

    public static void main(String[] args) {
        
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Clave1", 2);
        System.out.println(mapa.put("Clave2", 3));
        System.out.println(mapa.put("Clave2", 4));
        System.out.println(mapa.put("Clave2", 5));

        // Recuperamos por clave
        System.out.println("====== Valores por clave =======");

        System.out.println(mapa.get("Clave1"));
        System.out.println(mapa.get("Clave2"));
        
        System.out.println("====== Claves =======");

        Set<String> claves = mapa.keySet();
        for (String clave : claves) {
            System.out.println(clave);
        }

        System.out.println("===== Valores ======");

        Collection<Integer> valores = mapa.values();
        for (Integer valor : valores) {
            System.out.println(valor);
        }

        System.out.println("===== Clave y valor ======");
        
        for (String clave : claves) {
            System.out.println(clave + " " + mapa.get(clave));
        }

        System.out.println("===== Clave y valor usando Entry ======");

        Set<Entry<String, Integer>> entries = mapa.entrySet();
        for (Entry<String,Integer> entry : entries) {
            System.out.println(entry);
        }
    }

    // Ejercicio

    // ============ PARTE 1: COLECCIONES =========================

    /* LISTAS
     * 1) Crear 6 alumnos
     * 2) Vamos a meterlos todos en una lista
     * 3) Creamos un método para mostrar la información de todos los alumnos
     * 4) Otro método en el cual vamos a preguntará por el nombre de un alumno y os dará la nota media de todos los alumnos que se llamen igual
     * 5) 
     * 
     * Plus lista
     * Actualizar para todos los alumnos supensos, su nota media a 0
     */


     // ============ PARTE 1: MAPAS =========================
    /* 
     * 6) Vamos a separar a los alumnos por aulas
     * aula1 -> alumnos
     * aula2 -> alumnos
     * aula3 -> alumnos
     */
    
    /* 
     * 7) Mostrar por cada alula los datos de los alumnos
     * 8) Indicar cual es el aula que tiene el alumno con la nota media más alta
     */
}
