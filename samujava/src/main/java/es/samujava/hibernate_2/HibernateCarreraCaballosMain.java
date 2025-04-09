package es.samujava.hibernate_2;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.samujava.hibernate_2.entities.CaballoCarrera;
import es.samujava.utils.HibernateUtil;

public class HibernateCarreraCaballosMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        // CaballoCarrera c11 = new CaballoCarrera("Liz", 100, 30.0, 8, 5, true);
        CaballoCarrera c14 = new CaballoCarrera("Spirit", 5, 80.0, 8, 2, true);
        CaballoCarrera c15 = new CaballoCarrera("Joah", 20, 40.0, 3, 5, true);
        CaballoCarrera c16 = new CaballoCarrera("Smith", 7, 70.0, 2, 1, true);
        CaballoCarrera c17 = new CaballoCarrera("Holland", 25, 50.0, 8, 5, false);
        List<CaballoCarrera> caballos = Arrays.asList(c14, c15, c16, c17);

        // Obtenemos una session en hibernate
        for (CaballoCarrera caballoCarrera : caballos) {
            // Comenzamos una transacción
            tx = session.beginTransaction();
            try {
                System.out.println("Insertando caballos " + caballoCarrera.getNombre());
                session.persist(caballoCarrera);
                tx.commit();
            } catch (Exception e) {
                System.out.println("Ha habido un error: " + e);
            }

        }

        System.out.println("Operación exitosa");

    }

}
