package es.samujava.excepciones.ejercicios.ejercicio2;

import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TazaCafe;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooColdTemperatureException;
import es.samujava.excepciones.ejercicios.ejercicio2.tazacafe.TooHotTemperatureException;

public interface Cafeteable {

    void tomarCafe(TazaCafe taza) throws TooHotTemperatureException, TooColdTemperatureException;

}
