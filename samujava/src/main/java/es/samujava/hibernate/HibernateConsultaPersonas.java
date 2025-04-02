package es.samujava.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.samujava.utils.HibernateUtil;

public class HibernateConsultaPersonas {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        /*
         * Query<Persona> query = session.createQuery("from Persona", Persona.class);
         * List<Persona> personas = query.list();
         */

        /*
         * List<Persona> persona2 = session.createQuery("from Persona",
         * Persona.class).list();
         * for (Persona persona : persona2) {
         * System.out.println(persona);
         * }
         */
        /* String hql = "SELECT p.nombre FROM Persona p WHERE p.edad>:nombreParametro";
        Query<Persona> query = session.createQuery(hql, Persona.class);
        query.setParameter("nombreParametro", "25"); */

        /* Query<String> query = session.createQuery("SELECT p.nombre FROM Persona p WHERE p.edad>=:edadMin",
                String.class);
        query.setParameter("edadMin", "25"); // Aquí pones el nombre que deseas buscar

        // Ejecutar la consulta y obtener el resultado
        List<String> nombres = query.list();

        // Imprimir los nombres obtenidos
        for (String nombre : nombres) {
            System.out.println(nombre);
        } */

        String hql2 = "select p.nombre, p.apellido from Persona p";
        Query<Object[]> query2 = session.createQuery(hql2, Object[].class);
        List<Object[]> nombres2 = query2.list();
        for (Object[] resultado : nombres2) {
            System.out.println("\nNombre: " + resultado[0] + "\nApellido: " + resultado[1]);
        }

        /*
         * List<Persona> personas = query.getResultList();
         * for (Persona persona : personas) {
         * System.out.println(persona.getNombre());
         * }
         */
        /*
         * System.out.println(personas.size());
         * Persona p = query.uniqueResult();
         * System.out.println(p);
         */
    }

}
