package es.samujava.excepciones.ejercicios.ejercicio2;

import es.samujava.excepciones.ejercicios.ejercicio2.clientes.ClienteAsiduo;
import es.samujava.excepciones.ejercicios.ejercicio2.clientes.Clientes;
import es.samujava.excepciones.ejercicios.ejercicio2.clientes.Comensal;
import es.samujava.excepciones.ejercicios.ejercicio2.clientes.Huesped;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TazaCafe;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooColdTemperatureException;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooHotTemperatureException;

public class Bar {
    // Atributos
    private String nombre;

    // Constructor
    public Bar() {

    }
    
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
    

    public static void main(String[] args) {
        
        Bar bar = new Bar("Hola");
        Cafeteable[] listadoClientes = bar.crearClientes();
        bar.ejecutar(listadoClientes);
    }


    // Métodos

    public void ejecutar(Cafeteable[] listadoClientes) {
        abrirBar();
        servirCafe(listadoClientes);
    }

    public void abrirBar() {
        System.out.println("***El bar " + nombre + " ha abierto***");
    }

    // Crear Clientes
    public Cafeteable[] crearClientes() {
        Huesped huesped = new Huesped("Samuel", "27815097T");
        Comensal comensal = new Comensal("David", true);
        ClienteAsiduo clienteAsiduo = new ClienteAsiduo("Carlos", "El mío");

        Cafeteable[] cafeteros = {comensal, clienteAsiduo};
        return cafeteros;        
    }
    
    public void servirCafe(Cafeteable[] listadoClientes) {
        for (Cafeteable clientes : listadoClientes) {
            TazaCafe taza = new TazaCafe("Capuchino");
            try {
                clientes.tomarCafe(taza);
            } catch (TooHotTemperatureException e) {
                System.out.println("El cliente se ha quemado " + e.getMessage());
                //e.printStackTrace();
            } catch (TooColdTemperatureException e) {
                System.out.println("El cliente dice que el café está frio");
            }
        }
    }

    
}
