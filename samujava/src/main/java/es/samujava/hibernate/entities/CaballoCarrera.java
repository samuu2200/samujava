package es.samujava.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_CABALLOS")
public class CaballoCarrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    @NotNull(message = "El nombre es obligatorio.")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres.")
    private String nombre;

    @Column(name = "edad", nullable = false)
    @Min(value = 2, message = "La edad debe ser mayor o igual a 2.")
    @Max(value = 30, message = "La edad debe ser menor o igual a 30.")
    private int edad;

    @Column(name = "velocidad_maxima", nullable = false)
    @DecimalMin(value = "30.0", message = "La velocidad máxima debe ser mayor o igual a 30.0 km/h.")
    @DecimalMax(value = "80.0", message = "La velocidad máxima debe ser menor o igual a 80.0 km/h.")
    private double velocidadMaxima;

    @Column(name = "numero_de_triunfos", nullable = false)
    @Min(value = 0, message = "El número de triunfos no puede ser negativo.")
    private int numeroDeTriunfos;

    @Column(name = "experiencia", nullable = false)
    @Min(value = 0, message = "La experiencia debe ser mayor o igual a 0.0.")
    @Max(value = 10, message = "La experiencia debe ser menor o igual a 10.0.")
    private double experiencia;

    @Column(name = "esta_activo", nullable = false)
    private boolean estaActivo;

    // Constructores
    public CaballoCarrera(String nombre, int edad, double velocidadMaxima, int numeroDeTriunfos, double experiencia, boolean estaActivo) {
        this.nombre = nombre;
        this.edad = edad;
        this.velocidadMaxima = velocidadMaxima;
        this.numeroDeTriunfos = numeroDeTriunfos;
        this.experiencia = experiencia;
        this.estaActivo = estaActivo;
    }

    public CaballoCarrera() {
    }

    
    //Getters & Setters

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getNumeroDeTriunfos() {
        return numeroDeTriunfos;
    }

    public void setNumeroDeTriunfos(int numeroDeTriunfos) {
        this.numeroDeTriunfos = numeroDeTriunfos;
    }

    public double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        sb.append("Velocidad máxima: ").append(velocidadMaxima).append("\n");
        sb.append("Números de triunfos: ").append(numeroDeTriunfos).append("\n");
        sb.append("Experiencia: ").append(experiencia).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        sb.append("¿Está activo?: ").append(estaActivo).append("\n");
        return sb.toString();
    }
}
