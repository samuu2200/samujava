package es.samujava.excepciones;

public class MiExcepcion extends Exception {

    public MiExcepcion(String mensaje) {
        super(mensaje); // Llamamos al constructor de la clase padre utilizando el super() pasandole como parametro el mensaje
    }
    
}
