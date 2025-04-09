package es.samujava.hibernate_2.unoauno;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.samujava.pruebas.utilidades.Utilidades;
import es.samujava.utils.HibernateUtil;


public class Main {
    private static Session session = HibernateUtil.getSession();

    public static void main(String[] args) {
        
        //insertarUsuario();
        consultarUsuarios();
   
        session.close();
    }

    private static void insertarUsuario() {
        
        String nombre = Utilidades.pideDatoCadena("Nombre del usuario: ");
        String calle = Utilidades.pideDatoCadena("Calel del usuario: ");
        String ciudad = Utilidades.pideDatoCadena("Ciudad del usuario: ");

        Direccion direccion = new Direccion(calle, ciudad);
        Usuario usuario = new Usuario(nombre, direccion);

       
        Transaction tx = session.beginTransaction();
        session.persist(usuario);
        tx.commit();
        System.out.println("Usuario insertado.");
        
    }

    private static void consultarUsuarios() {
        List<Usuario> usuarios = session.createQuery("from Usuario", Usuario.class)
                .getResultList();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre() + " " + usuario.getDireccion().getCalle());
        }
        
    }
}
