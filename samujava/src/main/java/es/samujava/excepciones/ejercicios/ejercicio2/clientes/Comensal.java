package es.samujava.excepciones.ejercicios.ejercicio2.clientes;

import es.samujava.excepciones.ejercicios.ejercicio2.Cafeteable;
import es.samujava.excepciones.ejercicios.ejercicio2.ClientesCafeteros;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TazaCafe;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooColdTemperatureException;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooHotTemperatureException;

public class Comensal extends ClientesCafeteros implements Cafeteable{

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

    public String tosString() {
        StringBuilder sb = new StringBuilder();
        super.toString();
        sb.append("Tiene reserva: ").append(tieneReserva);
        return sb.toString();
    }

    @Override
    public void tomarCafe(TazaCafe taza) throws TooColdTemperatureException, TooHotTemperatureException {
        
        if (taza.getTemperatura() > 80) {
            throw new TooHotTemperatureException("La taza de café está muy caliente " + taza.getTemperatura());
        } else if (taza.getTemperatura() < 20) {
            throw new TooColdTemperatureException("La taza de café está muy caliente " + taza.getTemperatura());
        } else {
            System.out.println(this.getNombre() + " se está tomando el café " + taza.getTemperatura() + " placidamente");
        }
        
    }

    
}
