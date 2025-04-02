package es.samujava.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.samujava.hibernate.entities.CaballoCarrera;
import es.samujava.utils.HibernateUtil;

public class HibernateCarreraCaballosMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        // CaballoCarrera c11 = new CaballoCarrera("Liz", 100, 30.0, 8, 5, true);
        CaballoCarrera c14 = new CaballoCarrera("Longeva mucho", 350, 30.0, 8, 5, true);
        CaballoCarrera c15 = new CaballoCarrera("Hola", 100, 30.0, 8, 5, true);
        CaballoCarrera c16 = new CaballoCarrera("caballo", 4, 30.0, 8, 5, true);
        CaballoCarrera c17 = new CaballoCarrera("mucho", 20, 30.0, 8, 5, true);
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
