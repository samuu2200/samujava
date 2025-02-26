package es.samujava.excepciones.ejercicios.ejercicio2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import es.samujava.excepciones.ejercicios.ejercicio2.clientes.ClienteAsiduo;
import es.samujava.excepciones.ejercicios.ejercicio2.clientes.Clientes;
import es.samujava.excepciones.ejercicios.ejercicio2.clientes.Comensal;
import es.samujava.excepciones.ejercicios.ejercicio2.clientes.Huesped;

public class Bar {

    public static void main(String[] args) {
        

        
    }

    // Atributos
    private String nombre;

    // Constructor
    public Bar(String nombre) {
        this.nombre = nombre;
    }
    
    // Getters Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Métodos
    public void abrirBar() {
        System.out.println("***El bar " + nombre + " ha abierto***");
    }

    // Crear Clientes
    public List<Clientes> crearClientes() {
        Clientes huesped = new Huesped("Samuel", "27815097T");
        Clientes comensal = new Comensal("David", true);
        Clientes clienteAsiduo = new ClienteAsiduo("Carlos", "El mío");

        List<Clientes> listadoClietnes = Arrays.asList(huesped, comensal, clienteAsiduo);
        return listadoClietnes;        
    }
    
    public void recorrerClientes(List<Clientes> listadoClientes) {
        for (Clientes clientes : listadoClientes) {
            System.out.println(clientes);
        }
    }
    
}
