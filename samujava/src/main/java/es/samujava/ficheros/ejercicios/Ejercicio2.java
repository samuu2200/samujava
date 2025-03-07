package es.samujava.ficheros.ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.pruebas.alumnos.Alumnos;
import es.samujava.pruebas.utilidades.Utilidades;

public class Ejercicio2 {
    private static final Logger logger = LoggerFactory.getLogger(Ejercicio2.class);
    private static final String URL_ARCHIVO = "./recursos/alumnos.txt";


    public static void main(String[] args) {

        Ejercicio2 prueba = new Ejercicio2();
        String[] asignaturas = prueba.crearAsignaturas();
        List<Alumnos> listadAlumnos = prueba.crearAlumnos(asignaturas);
        prueba.ejecutar(asignaturas, listadAlumnos);
    }

    private void ejecutar(String[] asignaturas, List<Alumnos> listadoAlumnos) {
        crearAsignaturas();
        crearAlumnos(asignaturas);
        crearArchivoAlumnos((URL_ARCHIVO), listadoAlumnos);
    }

    private List<Alumnos> crearAlumnos(String[] asignaturas) {
        List<Alumnos> listadoAlumnos = new ArrayList<>();
        Alumnos alumno1 = new Alumnos("Samuel", "Quintero", 24, 9, "saquin@", asignaturas);
        Alumnos alumno2 = new Alumnos("Alex", "Morales", 24, 6, "ale@", asignaturas);
        Alumnos alumno3 = new Alumnos("Mariangel", "Gonzalez", 22, 8, "mg@", asignaturas);
        listadoAlumnos = Arrays.asList(alumno1, alumno2, alumno3);
        return listadoAlumnos;
    }

    private String[] crearAsignaturas() {
        String[] asignaturas = new String[2];
        for (int i = 0; i < asignaturas.length; i++) {
            String nombresAsignaturas = Utilidades.pideDatoCadena("Introduce asignaturas");
            asignaturas[i] = nombresAsignaturas;
        }
        return asignaturas;
    }

    public void crearArchivoAlumnos(String nombre, List<Alumnos> listadoAlumnos) {
        File archivo = new File(nombre);

        try (PrintWriter buffer = new PrintWriter(archivo)) {
            // try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo))){
            logger.info("Se ha creado correctamente");
            buffer.println("\nInformación Alumnos: ");
            for (Alumnos alumnos : listadoAlumnos) {
                buffer.printf("""
                        %nAlumno: %s
                        ---------------------
                        \tNombre: %s | Apellido: %s | Edad: %d | Email: %s | Asignaturas: %s
                        """,alumnos.getNombre(), alumnos.getNombre(), alumnos.getApellidos(), alumnos.getEdad(), alumnos.getEmail(),
                        Arrays.toString(alumnos.getAsignaturas()));

            }
            // buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Ha habido un error al crear el archivo", e.getMessage());
        }

    }

}
