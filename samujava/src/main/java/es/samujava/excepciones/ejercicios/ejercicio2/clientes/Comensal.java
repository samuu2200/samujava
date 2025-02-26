package es.samujava.excepciones.ejercicios.ejercicio2.clientes;

public class Comensal extends Clientes{

    // Atributos
    private boolean tieneReserva;

    // Constructor
    public Comensal(String nombre, boolean tieneReserva) {
        super(nombre);
        this.tieneReserva = tieneReserva;
    }
    
    //Getter Setters
    public boolean isTieneReserva() {
        return tieneReserva;
    }

    public void setTieneReserva(boolean tieneReserva) {
        this.tieneReserva = tieneReserva;
    }
}
