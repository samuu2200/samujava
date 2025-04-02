package es.samujava.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilidadesHibernate {

    public static Session obtenerSesion() {
        Session session = null;
        try {
            // Creamos la SessionFactory solo si no está previamente creada
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga el archivo hibernate.cfg.xml
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return session; // Retorna la sesión para ser utilizada en otras partes del código
    }
    
}
