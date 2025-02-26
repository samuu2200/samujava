package es.samujava.excepciones.ejercicios.ejercicio2.tazacafe;

public class TazaCafe {

    // Atributos
    private String tipoCafe;
    private double temperatura;

    // Constructor
    public TazaCafe(String tipoCafe, double temperatura) {
        this.tipoCafe = tipoCafe;
        this.temperatura = temperatura;
    }
    
    // Getters Setters
    public String getTipoCafe() {
        return tipoCafe;
    }

    public void setTipoCafe(String tipoCafe) {
        this.tipoCafe = tipoCafe;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    // Métodos 
    public void excepcionesTazaCafe() throws TemperatureException {
        if (temperatura > 80) {
            throw new TooHotTemperatureException("La temperatura del café es muy caliente.");
        } else if (temperatura < 20) {
            throw new TooColdTemperatureException("La temperatura del café es muy fría.");
        }
    }

    public void tomarCafe() {
        System.out.println("El cliente está tomando café");
    }
    
}
