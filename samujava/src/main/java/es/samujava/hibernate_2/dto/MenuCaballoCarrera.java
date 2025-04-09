package es.samujava.hibernate_2.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.beans.container.internal.CdiBasedBeanContainer;

import es.samujava.hibernate_2.entities.CaballoCarrera;
import es.samujava.hibernate_2.entities.Persona;
import es.samujava.pruebas.utilidades.Utilidades;
import es.samujava.utils.HibernateUtil;

public class MenuCaballoCarrera {
    private static final int salirMenu = 4;
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
            case 1 -> mcc.insertarCaballos();
            case 2 -> mcc.mostrarCaballosCompetidores();
            case 3 -> mcc.iniciarCarrera();
            case 4 -> {
                System.out.println("Saliendo del menú...");
                break;
            }
            default -> System.out.println("Error al elegir opción, inténtalo de nuevo.");
        }
    }

    // Método que crea el menú
    private static void mostrarMenu() {
        System.out.printf("""
                %nMenú caballos
                ----------------
                1. Registrar caballos.
                2. Mostrar caballos competidores.
                3. Iniciar carrera.
                4. Salir.%n""");
    }

    // Método que crea los caballos de carrera
    public List<CaballoCarrera> crearCaballos() {
        List<CaballoCarrera> listadoCaballos = new ArrayList<>();
        int numCaballos = Utilidades.pideDatoInt("¿Cuántos caballos quieres registrar? ");

        for (int i = 0; i < numCaballos; i++) {
            String nombre = Utilidades.pideDatoCadena("Ingresa el nombre del caballo: ");
            int edad = Utilidades.pideDatoInt("Ingresa la edad del caballo: ");
            double velocidadMaxima = Utilidades.pideDatoDouble("Ingresa la velocidad del caballo: ");
            int numTriunfos = Utilidades.pideDatoInt("Introduce el número de triunfos: ");
            int experiencia = Utilidades.pideDatoInt("Introduce la experiencia de " + nombre + ": ");
            boolean estaActivo = Utilidades.pideDatoCadena("¿El caballo está activo? (sí/no): ").equalsIgnoreCase("sí");

            listadoCaballos
                    .add(new CaballoCarrera(nombre, edad, velocidadMaxima, numTriunfos, experiencia, estaActivo));
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
            if (tx != null)
                tx.rollback(); // Si ocurre un error, revertimos la transacción
            System.out.println(
                    "Ha habido un error al insertar el caballo " + caballo.getNombre() + ": " + e.getMessage());
        }
    }

    private void mostrarCaballosCompetidores() {
        List<CaballoCarrera> listadoCaballos = crearCaballos();
        for (CaballoCarrera caballoCarrera : listadoCaballos) {
            System.out.println(caballoCarrera);
        }
    }

    private List<CaballoCarrera> consultarCaballos() {
        Session session = HibernateUtil.getSession();

        // Query para obtener una persona por su nombre
        Query<CaballoCarrera> query = session.createQuery("from CaballoCarrera c where c.estaActivo = :si",
                CaballoCarrera.class);
        query.setParameter("si", true);
        List<CaballoCarrera> caballosCarrera = query.list();
        return caballosCarrera;
    }

    private void iniciarCarrera() {
        List<CaballoCarrera> listadoCaballos = consultarCaballos();
    
        final int DISTANCIA = 1000;
    
        // Verificamos si hay al menos dos caballos activos antes de iniciar la carrera
        if (listadoCaballos.size() < 2) {
            System.out.println("No se puede iniciar la carrera, hay solo un caballo.");
            return;
        }
    
        System.out.println("\n*** Se ha iniciado la carrera de caballos ***");
    
        while (true) {
            // Para cada caballo en la lista, calculamos el avance
            for (CaballoCarrera caballoCarrera : listadoCaballos) {
                int avanceCaballo = caballoCarrera.avanceCaballos();
                caballoCarrera.setAvance(caballoCarrera.getAvance() + avanceCaballo);  
    
                // Mostramos el avance del caballo
                System.out.print("\n" + caballoCarrera.getNombre() + " ha avanzado " + avanceCaballo + " metros" );
                System.out.println(". Avance total: " + caballoCarrera.getAvance() + " metros.");
    
                // Verificamos si algún caballo ha alcanzado la meta
                if (caballoCarrera.getAvance() >= DISTANCIA) {
                    System.out.println("\nEl caballo ganador es: " + caballoCarrera.getNombre());
                    System.out.println(caballoCarrera);
                    caballoCarrera.setExperiencia(caballoCarrera.getExperiencia() + 1);
                    return;  
                }
            }
            
            try {
                Thread.sleep(500);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
