package es.samujava.hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.samujava.hibernate.entities.CaballoCarrera;
import es.samujava.pruebas.utilidades.Utilidades;
import es.samujava.utils.HibernateUtil;

public class MenuCaballoCarrera {
    private static final int salirMenu = 3;
    Session session = HibernateUtil.getSession();
    Transaction tx = null;

    // Método que ejecuta todo
    public void ejecutar() {
        menuCarreraCaballos();
    }
    
    // Método que ejecuta el menú
    private static void menuCarreraCaballos() {
        
        int opcion;

        do {
            // Mostrar el menú
            mostrarMenu();
            
            // Pedir la opción
            opcion = Utilidades.pideDatoInt("Elige una opción");

            // Procesar la opción
            opcionesMenu(opcion);

        } while (opcion != salirMenu);

    }

    private static void opcionesMenu(int opcion) {
        MenuCaballoCarrera mcc = new MenuCaballoCarrera();

        switch (opcion) {
            case 1 -> {
                mcc.insertarCaballos();
            }
            case 2 -> {
                System.out.println("Iniciando carrera...");
            }
            case 3 -> {
                System.out.println("Saliendo del menú...");
                break;
            }
            default -> {
                System.out.println("Error al elegir opción, inténtalo de nuevo.");
            }
        }
    }

    // Método que crea el menú
    private static void mostrarMenu() {
        System.out.printf("""
                %nMenú caballos
                ----------------
                1. Registrar caballos.
                2. Iniciar carrera.
                3. Salir.%n""");
    }

    // Método que crea los caballos de carrera
    public List<CaballoCarrera> crearCaballos() {
        List<CaballoCarrera> listadoCaballos = new ArrayList<>();
        int numCaballos = Utilidades.pideDatoInt("¿Cuántos caballos quieres registrar?");
        
        for (int i = 0; i < numCaballos; i++) {
            String nombre = Utilidades.pideDatoCadena("Ingresa el nombre del caballo: ");
            int edad = Utilidades.pideDatoInt("Ingresa la edad del caballo: ");
            double velocidadMaxima = Utilidades.pideDatoDouble("Ingresa la velocidad del caballo");
            int numTriunfos = Utilidades.pideDatoInt("Introduce el número de triunfos: ");
            int experiencia = Utilidades.pideDatoInt("Introduce la experiencia de " + nombre + ": ");
            boolean estaActivo = Utilidades.pideDatoCadena("¿El caballo está activo? (sí/no)").equalsIgnoreCase("sí");
            
            listadoCaballos.add(new CaballoCarrera(nombre, edad, velocidadMaxima, numTriunfos, experiencia, estaActivo));
        }
        return listadoCaballos;
    }

    // Método que inserta los caballos en la bbdd
    private void insertarCaballos() {
        List<CaballoCarrera> listadoCaballos = crearCaballos();
        // Obtenemos una session en hibernate
        for (CaballoCarrera caballos : listadoCaballos) {
            insertarCaballoEnBBDD(caballos);
        }
        System.out.println("Operación exitosa");
    }
    
    private void insertarCaballoEnBBDD(CaballoCarrera caballo) {
        tx = session.beginTransaction();
        try {
            System.out.println("Insertando caballo " + caballo.getNombre());
            session.persist(caballo);
            tx.commit(); // Si todo va bien, cometemos la transacción
        } catch (Exception e) {
            if (tx != null) tx.rollback(); // Si ocurre un error, revertimos la transacción
            System.out.println("Ha habido un error al insertar el caballo " + caballo.getNombre() + ": " + e.getMessage());
        }
    }
}
