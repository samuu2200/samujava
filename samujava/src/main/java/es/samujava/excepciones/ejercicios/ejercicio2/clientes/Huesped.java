package es.samujava.excepciones.ejercicios.ejercicio2.clientes;

public class Huesped extends Clientes{

    // Atributos
    private String dni;

    // Constructor
    public Huesped(String nombre, String dni) {
        super(nombre);
        this.dni = dni;
    }

    // Getters Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        super.toString();
        sb.append("DNI cliente: ").append(dni);
        return sb.toString();
    }
    
}
