package es.samujava.ficheros.ejercicios;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import es.samujava.pruebas.alumnos.Alumnos;
import es.samujava.utils.UtilidadesFicheros;

public class Ejercicio3Ficcheros {
    public static void main(String[] args) {
        String[] asignaturas = {"A1","A2","A3"};
        Alumnos a1 = new Alumnos("N1", "A1", 22, 8, "asdas@asdsad.es", asignaturas);
        Alumnos a2 = new Alumnos("N2", "A2", 23, 6, "zxczx@asdsad.es", asignaturas);
        Alumnos a3 = new Alumnos("N3", "A3", 24, 9, "qweqw@asdsad.es", asignaturas);


        List<Alumnos> Alumnoss = Arrays.asList(a1,a2,a3);
        Ejercicio3Ficcheros e3 = new Ejercicio3Ficcheros();
        e3.almacenarAlumnossFichero(Alumnoss);
    }

    public void almacenarAlumnossFichero (List<Alumnos> Alumnoss){

        Path ruta = Paths.get("./recursos/datos_Alumnoss.txt");
		
        try {

            for (Alumnos Alumnos : Alumnoss) {
                StringBuilder sb = new StringBuilder();
                sb.append(Alumnos.getNombre());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append(Alumnos.getEdad());
                sb.append(UtilidadesFicheros.SEPARADOR_PIPE);
                sb.append(Arrays.toString(Alumnos.getAsignaturas()));

                // String contenido = ""+Alumnos.getNombre()+"|"+Alumnos.getApellidos()+
                //         "|"+Alumnos.getEdad() +"|" + Arrays.toString(Alumnos.getAsignaturas()) +"\n";
                String contenido = sb.toString();
                contenido = contenido.replace("[", "")
                            .replace("]", "");


                String texto = "Prueba ";
                //texto.join(texto, "texto1","texto2");

                //N1|24|A1,A2,A3
                // String asignaturas = "";
                // for (String asignatura : Alumnos.getAsignaturas()) {
                //     asignaturas+=asignatura+",";
                // }
                //contenido+= asignaturas;

                Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    
            }
            
            System.out.println("Escritura completada.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
