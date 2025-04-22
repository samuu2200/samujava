package es.cursojava.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.hibernate.entities.Cliente;

public class HibernateIndices {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        
        //insertarDatos(session);
        consultarDatos(session);


    }

    private static void insertarDatos (Session session){
        Transaction tx = session.beginTransaction();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            Cliente cliente = new Cliente("Nombre " + i , "usuario" + i + "@ejemplo.com");
            session.persist(cliente);

            if (i % 1000 == 0 && i!=0) {
                session.flush();//empuja los cambios pendientes (inserciones, actualizaciones, eliminaciones) a la base de datos, pero sin cerrar la transacción.
                session.clear();//elimina todos los objetos gestionados por Hibernate en esa sesión.
                
            }
            if (i % 100000 == 0 && i!=0) {
                System.out.println("Insertados "+i);
                long end = System.currentTimeMillis();
                System.out.println("Tiempo de búsqueda: " + (end - start) + " ms");
                start = System.currentTimeMillis();
            }    
        }
        tx.commit();
    }

    private static void consultarDatos (Session session){
        long start = System.currentTimeMillis();

        String emailBusqueda = "usuario4000000@ejemplo.com";
        Cliente resultado = session.createQuery("FROM Cliente WHERE email = :email", Cliente.class)
            .setParameter("email", emailBusqueda)
            .uniqueResult();

        long end = System.currentTimeMillis();
        System.out.println("Tiempo de búsqueda: " + (end - start) + " ms");
        session.close();
    }
}
