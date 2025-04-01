package es.samujava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.samujava.hibernate.entities.CaballoCarrera;

public class HibernateCarreraCaballosMain {
    public static void main(String[] args) {

        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure() // Carga hibernate.cfg.xml
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            System.out.println(session);

            CaballoCarrera c1 = new CaballoCarrera(25, "Spirit", 15, 70.0, 5, 5, true);
            CaballoCarrera c2 = new CaballoCarrera(25, "Ricky", 5, 20.0, 2, 5, true);
            CaballoCarrera c3 = new CaballoCarrera(25, "David", 19, 40.0, 1, 5, true);
            CaballoCarrera c4 = new CaballoCarrera(25, "Duban", 25, 70.0, 6, 5, false);
            CaballoCarrera c5 = new CaballoCarrera(25, "Victor", 7, 30.0, 8, 5, true);

            session.persist(c1);
            session.persist(c2);
            session.persist(c3);
            session.persist(c4);
            session.persist(c5);

            tx.commit();

        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
