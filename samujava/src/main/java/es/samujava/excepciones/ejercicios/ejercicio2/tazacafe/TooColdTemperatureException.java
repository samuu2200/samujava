package es.samujava.excepciones.ejercicios.ejercicio2.tazacafe;

public class TooColdTemperatureException extends TemperatureException{
    
    public TooColdTemperatureException(String mensaje) {
        super(mensaje);
    }
}
