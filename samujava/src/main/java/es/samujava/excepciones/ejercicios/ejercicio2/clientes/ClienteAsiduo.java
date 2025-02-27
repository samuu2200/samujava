package es.samujava.excepciones.ejercicios.ejercicio2.clientes;

import es.samujava.excepciones.ejercicios.ejercicio2.Cafeteable;
import es.samujava.excepciones.ejercicios.ejercicio2.ClientesCafeteros;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TazaCafe;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooColdTemperatureException;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooHotTemperatureException;

public class ClienteAsiduo extends ClientesCafeteros implements Cafeteable{

    // Atributos
    private String mote;

    // Constructores
    public ClienteAsiduo(String nombre, String mote) {
        super(nombre);
        this.mote = mote;
    }
    
    // Getters Setters
    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }
    
    public String toString() {
        super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Mote cliente").append(mote);
        return sb.toString();
    }

/*     @Override
    public void tomarCafe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException {
        if (taza.getTemperatura() > 80) {
            throw new TooHotTemperatureException("La taza de café está muy caliente " + taza.getTemperatura());
        } else if (taza.getTemperatura() < 20) {
            throw new TooColdTemperatureException("La taza de café está muy caliente " + taza.getTemperatura());
        } else {
            System.out.println(this.getNombre() + " se está tomando el café " + taza.getTemperatura() + " placidamente");
        }
    } */

    
}
