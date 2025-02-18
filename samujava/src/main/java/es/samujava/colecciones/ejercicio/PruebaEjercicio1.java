package es.samujava.colecciones.ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
        
        Alumnos alumno1 = new Alumnos("Samuel", "Quintero", 24, 9, "sam@");
        Alumnos alumno2 = new Alumnos("José", "Gonzalez", 34, 2, "jose@");
        Alumnos alumno3 = new Alumnos("Samuel", "De La Mata", 38, 10, "alber@");
        Alumnos alumno4 = new Alumnos("María", "De los Angeles", 33, 3, "mar@");
        Alumnos alumno5 = new Alumnos("Liz", "Maribel", 30, 4, "liz@");
        Alumnos alumno6 = new Alumnos("Isis", "Daricell", 48, 7, "ijaa@");

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);
        alumnos.add(alumno6);

        alumnos.addAll(Arrays.asList(alumno1, alumno2, alumno3, alumno4, alumno5, alumno6));
        
        return alumnos;
    }
    
    public void preguntarAlumnos(List<Alumnos> alumnos) {
        int contador = 0;
        String busquedaAlumno = Utilidades.pideDatoCadena("Ingresa el nombre del alumno");

        System.out.println("\nBuscando alumno: " + busquedaAlumno);
        
        for (Alumnos alumno : alumnos) {
            boolean coincidencia = busquedaAlumno.equalsIgnoreCase(alumno.getNombre());        
            
            if (coincidencia) {
                contador++;
                System.out.println("\nNúmero de coincidencias encontradas: " + contador);
                System.out.println("Nota media de los alumnos con la coincidencia: " + busquedaAlumno);
                System.out.println(alumno.getNotaMedia());
            } 
        }
        
    }

    public void ejecutar(List<Alumnos> alumnos){
        for (Alumnos alumno : alumnos) {
            alumno.mostrarInformacion();
        }
        preguntarAlumnos(alumnos);
        //separarPorAulas(alumnos);
        Map<String, List<Alumnos>> aulas = separarPorAulas(alumnos);
        dastosAlumnosPorAulas(aulas);
        aulaConMayorNotaMedia(aulas);
        alumnosSuspensos(alumnos);
    }

    // Mapsa
    public Map<String, List<Alumnos>> separarPorAulas(List<Alumnos> alumnos) {
        // Creamos las aulas para separar a los alumnos
        Map<String, List<Alumnos>> aulas = new HashMap<>();

        List<Alumnos> alumnosAula1 = Arrays.asList(alumnos.get(0), alumnos.get(1));
        List<Alumnos> alumnosAula2 = Arrays.asList(alumnos.get(2), alumnos.get(3));
        List<Alumnos> alumnosAula3 = Arrays.asList(alumnos.get(4), alumnos.get(5));

        aulas.put("Aula 1", alumnosAula1);
        aulas.put("Aula 2", alumnosAula2);
        aulas.put("Aula 3", alumnosAula3);
        
        return aulas;
    }

    public void dastosAlumnosPorAulas(Map<String, List<Alumnos>> aulas){
                
        for (Map.Entry<String, List<Alumnos>> entry : aulas.entrySet()) {
            System.out.println("\nAula: " + entry.getKey());
            List<Alumnos> aulaAlumnos = entry.getValue();
            for (Alumnos alumno : aulaAlumnos) {
                System.out.println("- " + alumno.getNombre() + " " + alumno.getApellidos());
            }
        }
    }

    public void aulaConMayorNotaMedia(Map<String, List<Alumnos>> aulas) {
        double nota = 0;
        String aula = "";
        
        for (Map.Entry<String, List<Alumnos>> entry : aulas.entrySet()) {
            List<Alumnos> aulaAlumnos = entry.getValue();
            for (Alumnos alumno : aulaAlumnos) {
                if (alumno.getNotaMedia() > nota) {
                    nota = alumno.getNotaMedia();
                    aula = entry.getKey();
                }
            }
        }

        System.out.print("\nAula con mayor nota: ");
        System.out.println(aula + " " + nota);
        
    }

    public void alumnosSuspensos(List<Alumnos> alumnos) {

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNotaMedia() < 5) {
                System.out.println("Alumnos borrados" + alumnos.remove(i));
                i--;
            }
        }
        
    }

}
