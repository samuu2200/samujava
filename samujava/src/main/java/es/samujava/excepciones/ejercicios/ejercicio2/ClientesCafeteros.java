package es.samujava.excepciones.ejercicios.ejercicio2;

import es.samujava.excepciones.ejercicios.ejercicio2.clientes.Clientes;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TazaCafe;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooColdTemperatureException;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooHotTemperatureException;

public abstract class ClientesCafeteros extends Clientes implements Cafeteable {

    public ClientesCafeteros(String nombre) {
        super(nombre);
    }

    public void tomarCafe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException {
        if (taza.getTemperatura() > 80) {
            throw new TooHotTemperatureException("La taza de café está muy caliente " + taza.getTemperatura());
        } else if (taza.getTemperatura() < 20) {
            throw new TooColdTemperatureException("La taza de café está muy caliente " + taza.getTemperatura());
        } else {
            System.out.println(getNombre() + " se está tomando el café " + taza.getTemperatura() + " placidamente");
        }
    }

}
