package es.samujava.excepciones;

import es.samujava.pruebas.alumnos.Alumnos;

public class EjemploExcepciones {

    public static void main(String[] args) {
        
        Alumnos alumno1 = null;
        try {
            metodo1();
        } catch (MiExcepcion e) {
            e.printStackTrace();
        }

        System.out.println("Inicio");
        
        try {
            String[] colores = {"azul", "blanco"}; // Cómo no se hace referencia a la posición del array, no hay ninguna excepción
            metodo1();
            System.out.println(7/0); // No se puede dividir entre 0 / AritmeticException
            System.out.println(colores[2]); // Como hacemos referencia a la posición del array de String después de la primera excepción, entonces está jamás se ejecuta
            System.out.println(alumno1.getNombre()); 
            // Cierro fichero | Nunca se cerraría
        } catch (NullPointerException e) {
            System.out.println("Error 1: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException err) {  
            System.out.println("Error 2: " + err.getMessage());

        } catch (Exception e) {
            System.out.println("Error General: " + e.getMessage());
        } finally {
            System.out.println("SE EJECUTA SIEMPRE");
            // Cierro fichero
        }

        System.out.println("Fin");
        
    }

    // Propagar la excepción es poner el throws al método
    public static void metodo1() throws MiExcepcion {
        if (Math.random() > 0.5) {
            // throw new NullPointerException("Error Null creado por mí");
            // throw new MiExcepcion("Mensaje de mí propia excepción"); // Es de tipo checked

            // Creamos el objeto con nuestra excepción
            MiExcepcion me = new MiExcepcion("Mensaje de mí propia excepción");
            // Lanzar la excepción
            throw me;
        } else {
            System.out.println("Todo ha ido bien");
        }
    }
}
