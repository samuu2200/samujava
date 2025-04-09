package es.samujava.hibernate_2.dto;

public class PersonaDTO {

    private String nombre;
    private int edad;

    // Constructor
    public PersonaDTO(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters & Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        
        return sb.toString();
    }

}
