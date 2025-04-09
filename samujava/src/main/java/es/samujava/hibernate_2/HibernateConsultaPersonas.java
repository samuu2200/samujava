package es.samujava.hibernate_2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.samujava.hibernate_2.dto.PersonaDTO;
import es.samujava.utils.HibernateUtil;

public class HibernateConsultaPersonas {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();

        // Query<Persona> query = session.createQuery("from Persona", Persona.class);
        // List<Persona> personas = query.list();

        /* List<Persona> personas2 = session.createQuery("from Persona", Persona.class).list();
        for (Persona persona : personas2) {
            System.out.println(persona);
        } */

        // Query para obtener una persona por su nombre
        /* Query<Persona> query = session.createQuery("from Persona p where p.nombre = :nombreParametro", Persona.class);
        query.setParameter("nombreParametro", "Ana");
        // List<Persona> personas = query.list();
        // System.out.println(personas.size());
        Persona p = query.uniqueResult();
        System.out.println(p); */

        // Query para obtener una persona por su edad
        // Repetimos la edad para que nos salga un error: NonUniqueResultException:
        // Query did not return a unique result: 2 results were returned
        // Ya que query2.uniqueResult() solo devuelve un resultado, si hay más de uno,
        // lanza una excepción.
        /* Query<Persona> query2 = session.createQuery("from Persona p where p.edad = :edadParametro", Persona.class);
        query2.setParameter("edadParametro", "25");
        Persona p2 = query2.uniqueResult();
        System.out.println(p2); */

        // Query para obtener solo el nombre de las personas que tienen una edad mayor a
        // 24
        // En este caso, no es necesario crear una clase Persona para obtener solo el
        // nombre, ya que no se necesita un objeto completo.
        // En este caso, se puede usar un String como tipo de resultado, ya que el
        // nombre es un String.
        String hql = "select p.nombre from Persona p where p.edad>:edadMinima";
        Query<String> query3 = session.createQuery(hql, String.class);
        query3.setParameter("edadMinima", 24);
        List<String> nombres = query3.list();
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        // Query para obtener el nombre y la edad de las personas
        // En este caso, se puede usar un Object[] como tipo de resultado, ya que se
        // obtienen dos resultados.
        String hql2 = "select p.id, p.nombre, p.apellido from Persona p";
        Query<Object[]> query4 = session.createQuery(hql2, Object[].class);
        List<Object[]> resultado = query4.list();
        System.out.println("\nDevuelve una lista con los objectos del tipo asociado al campo que se ha consultado.");
        for (Object[] personas : resultado) {
            System.out.println("\nId: " + personas[0]);
            System.out.println("Nombre: " + personas[1]);
            System.out.println("Apellido: " + personas[2]);
        }


        // Usamos patrón DTO con la clase PersonaDTO
        String hql3 = "select p.nombre, p.edad from Persona p";
        // Query<PersonaDTO> query5 = session.createQuery(hql2, PersonaDTO.class);
        Query<Object[]> query5 = session.createQuery(hql3, Object[].class);
        List<Object[]> resultado3 = query5.list();
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for (Object[] personas : resultado3) {
            System.out.println("Nombre: " + personas[0] + ", Edad: " + personas[1]);
            String nombre = (String)personas[0];
            int edad = (int)personas[1];
            PersonaDTO pdto = new PersonaDTO(nombre, edad);
            personasDTO.add(pdto);
        }

        System.out.println("Personas DTO en lista propia: " + personasDTO.size());
        // Usamos patrón DTO con la clase PersonaDTO más elegante
        String hql5 = "select new es.samujava.hibernate.dto.PersonaDTO(p.nombre, p.edad) from Persona p where p.edad>:edadMin";
        // Query<PersonaDTO> query5 = session.createQuery(hql2, PersonaDTO.class);
        Query<PersonaDTO> query6 = session.createQuery(hql5, PersonaDTO.class);
        query6.setParameter("edadMin", 20);
        List<PersonaDTO> resultado4 = query6.list();
        System.out.println("Personas DTO: " + resultado4.size());
        


    }
}
 