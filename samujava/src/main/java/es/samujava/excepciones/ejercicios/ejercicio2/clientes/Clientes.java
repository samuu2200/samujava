package es.samujava.excepciones.ejercicios.ejercicio2.clientes;

public class Clientes {

    // Atributos
    private String nombre;  

    // Constructores
    public Clientes(String nombre) {
        this.nombre = nombre;
    }

    // Getters Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ToString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre cliente: ").append(nombre);
        
        return sb.toString();
    }
    
    // Métodos
}
