package es.samujava.excepciones.ejercicios.ejercicio1;

import es.samujava.pruebas.alumnos.Alumnos;
import es.samujava.pruebas.utilidades.Utilidades;

public class ValidarAlumnos {

    public static void main(String[] args) {
        
        ValidarAlumnos prueba = new ValidarAlumnos();
        Alumnos alumnos[] = prueba.crearAlumnos();
        prueba.ejecutar(alumnos);
    }

    public void ejecutar(Alumnos[] alumnos) {
        crearAlumnos();
        recorrerAlumnos(alumnos);
    }

    private Alumnos[] crearAlumnos() {

        Alumnos[] alumnos = new Alumnos[5];
        
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("\nIntroduce los datos del alumno " + (i + 1));
            int edad = Utilidades.pideDatoInt("Introduce la edad del alumno");
            double notaMedia = Utilidades.pideDatoDouble("Introduce la nota del alumno");
            try{
                Alumnos alumno = new Alumnos(edad, notaMedia);
                alumnos[i] = alumno;
            } catch (NotaInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return alumnos;
    }

    private void recorrerAlumnos(Alumnos[] alumnos) {
        for (Alumnos alumno : alumnos) {
            alumno.mostrarInformacion();
        }
    }

}
