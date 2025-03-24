package es.samujava.bbdd.ejercicios;

import java.util.Date;

public class Empleados {

    private int id;
    private String nombre;
    private int edad_empleado;
    private double salario_empleado;
    private int id_departamento;
    private Date fecha_contratacion;

    // Constructor
    public Empleados(String nombre) {
        this.nombre = nombre;
    }

    public Empleados(int id, String nombre, int edad_empleado, double salario_empleado, int id_departamento,
            Date fecha_contratacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad_empleado = edad_empleado;
        this.salario_empleado = salario_empleado;
        this.id_departamento = id_departamento;
        this.fecha_contratacion = fecha_contratacion;
    }
    // Getter & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_empleado() {
        return edad_empleado;
    }

    public void setEdad_empleado(int edad_empleado) {
        this.edad_empleado = edad_empleado;
    }

    public double getSalario_empleado() {
        return salario_empleado;
    }

    public void setSalario_empleado(double salario_empleado) {
        this.salario_empleado = salario_empleado;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nombre Empleado: ").append(nombre).append("\n");
        sb.append("Edad empleado: ").append(edad_empleado).append("\n");
        sb.append("Salario del empleado: ").append(salario_empleado).append("\n");
        sb.append("ID departamento: ").append(id_departamento).append("\n");
        sb.append("Fecha de contratación: ").append(fecha_contratacion).append("\n");
        return sb.toString();
    }

}

/*
 * crear una clase con los atributos que tiene la tabla empleados
 * Hacer un método que le pases una edad y que devuelva una lista de empleados
 * que tenga más de esa edad
 * 
 */
