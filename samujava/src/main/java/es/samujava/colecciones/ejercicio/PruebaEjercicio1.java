package es.samujava.colecciones.ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.samujava.pruebas.alumnos.Alumnos;
import es.samujava.pruebas.utilidades.Utilidades;

public class PruebaEjercicio1 {

    public static void main(String[] args) {
        
        PruebaEjercicio1 prueba = new PruebaEjercicio1();
        List<Alumnos> alumnos = prueba.crearAlumnos();
        prueba.ejecutar(alumnos);   

    }
    
    public List<Alumnos> crearAlumnos() {
        List<Alumnos> alumnos = new ArrayList<>();
        
        Alumnos alumno1 = new Alumnos("Samuel", "Quintero", 24, 1, "sam@");
        Alumnos alumno2 = new Alumnos("José", "Gonzalez", 34, 2, "jose@");
        Alumnos alumno3 = new Alumnos("Samuel", "De La Mata", 38, 10, "alber@");
        Alumnos alumno4 = new Alumnos("María", "De los Angeles", 33, 3, "mar@");
        Alumnos alumno5 = new Alumnos("Liz", "Maribel", 30, 4, "liz@");
        Alumnos alumno6 = new Alumnos("Isis", "Daricell", 48, 7, "ijaa@");

        alumnos.addAll(Arrays.asList(alumno1, alumno2, alumno3, alumno4, alumno5, alumno6));
        
        return alumnos;
    }



    public void ejecutar(List<Alumnos> alumnos){
        for (Alumnos alumno : alumnos) {
            alumno.mostrarInformacion();
        }
        
        preguntarAlumnos(alumnos);
        separarPorAulas(alumnos);
        Map<String, List<Alumnos>> aulas = separarPorAulas(alumnos);
        dastosAlumnosPorAulas(aulas);
        aulaConMayorNotaMedia(aulas);
        alumnosSuspensos(alumnos);
        for (Alumnos alumno : alumnos) {
            alumno.mostrarInformacion();
        }
    }
    
    public void preguntarAlumnos(List<Alumnos> alumnos) {
        double nota = 0;
        boolean encontrado = false;
        String busquedaAlumno = Utilidades.pideDatoCadena("Ingresa el nombre del alumno");

        System.out.println("\nBuscando alumno: " + busquedaAlumno);
        
        for (Alumnos alumno : alumnos) {
            boolean coincidencia = busquedaAlumno.equalsIgnoreCase(alumno.getNombre());        
            
            if (coincidencia) {
                encontrado = true;

                if (alumno.getNotaMedia() > nota) {
                    nota = alumno.getNotaMedia();
                } 
            } 

        }

        if (encontrado) {
            System.out.println("Nota media de los alumnos con la coincidencia: " + busquedaAlumno);
            System.out.println(nota);
        }
        
    }

    // Mapas
    public Map<String, List<Alumnos>> separarPorAulas(List<Alumnos> alumnos) {
        // Creamos las aulas para separar a los alumnos
        Map<String, List<Alumnos>> aulas = new LinkedHashMap<>();

        List<Alumnos> alumnosAula1 = Arrays.asList(alumnos.get(0), alumnos.get(1));
        List<Alumnos> alumnosAula2 = Arrays.asList(alumnos.get(2), alumnos.get(3));
        List<Alumnos> alumnosAula3 = Arrays.asList(alumnos.get(4), alumnos.get(5));

        aulas.put("Aula 1", alumnosAula1);
        aulas.put("Aula 2", alumnosAula2);
        aulas.put("Aula 3", alumnosAula3);
        
        return aulas;
    }

    public void dastosAlumnosPorAulas(Map<String, List<Alumnos>> aulas){
        System.out.println("\n*** Datos alumnos por aulas ***");
        Set<String> claves = aulas.keySet();

        for (String clave : claves) {
            System.out.println(clave + ": ");
            List<Alumnos> alumnos = aulas.get(clave);
            for (Alumnos alumno : alumnos) {
                System.out.println("-" + alumno.getNombre() + " " + alumno.getApellidos());
            }
        }
        
    }

    public void aulaConMayorNotaMedia(Map<String, List<Alumnos>> aulas) {
        System.out.println("\n*** Aula con mayor nota media ***");
        double nota = 0;
        String aula = "";
        String nombreAlumno = "";
        
        Set<String> claves = aulas.keySet();
        for (String clave : claves) {
            List<Alumnos> alumnosMayorNota = aulas.get(clave);
            for (Alumnos alumno : alumnosMayorNota) {
                if (alumno.getNotaMedia() > nota) {
                    nota = alumno.getNotaMedia();
                    aula = clave;
                    nombreAlumno = alumno.getNombre();
                }
            }
        }

        System.out.print("Aula con mayor nota: ");
        System.out.println(aula + ":");
        System.out.println("-" + nombreAlumno + " " + nota);
        
    }

    public void alumnosSuspensos(List<Alumnos> alumnos) {
        System.out.println("\n*** Eliminar alumnos suspensos ***");
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNotaMedia() < 5) {
                alumnos.remove(i--);
            }
        }
        
    }

}
