package es.samujava.excepciones.ejercicios.ejercicio2.clientes;

public class ClienteAsiduo extends Clientes{

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
    
}
