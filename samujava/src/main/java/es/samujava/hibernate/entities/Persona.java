package es.samujava.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TB_PERSONAS") // Es para darle un nombre a la tabla especifico, si no se registrará el nombre de la clase
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // AUTO:	Delega la estrategia al proveedor JPA (Hibernate decide según la BBDD).
    // IDENTITY:	Usa una columna auto-incremental. Funciona bien con MySQL, SQL Server, Oracle 12c+…
    // SEQUENCE:	 Usa una secuencia de base de datos (muy común en Oracle, PostgreSQL, etc.).
    // TABLE: Usa una tabla especial para almacenar y generar identificadores.
    private Long id;

    @Column(name = "nombre", nullable = false, length = 20, unique = true)
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;

    // La usamos para que no guarde en la base de datos este atributo
    @Transient
    private String estadoCivil;

    // Constructores
    public Persona() {}
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // G Y S
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        
        return sb.toString();
    }
}
