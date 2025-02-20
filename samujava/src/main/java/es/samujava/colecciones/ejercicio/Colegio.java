package es.samujava.colecciones.ejercicio;

import java.util.List;
import java.util.Map;

import es.samujava.pruebas.alumnos.Alumnos;

public class Colegio {

    // Atributos
    private String nombre;
    private String direccion;
    private Map<String, List<Alumnos>> aulas;

    // Constructor
    public Colegio(String nombre, String direccion, Map<String, List<Alumnos>> aulas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.aulas = aulas;
    }

    public Colegio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;   
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Map<String, List<Alumnos>> getAulas() {
        return aulas;
    }
    public void setAulas(Map<String, List<Alumnos>> aulas) {
        this.aulas = aulas;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del colegio: ").append(nombre + "\n");
        sb.append("Dirección del colegio: ").append(direccion + "\n");
        return sb.toString();
    }

}
