package es.samujava.hibernate.unoauno;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.samujava.hibernate.HibernateUtil;
import es.samujava.pruebas.utilidades.Utilidades;



public class Main {
    private static Session session = HibernateUtil.getSession();

    public static void main(String[] args) {
        
        //insertarUsuario();
        //consultarUsuarios();
        //consultarDirecciones();
        Usuario u = consultarUsuarioPorDireccionIDHQL(1);
        System.out.println(u.getNombre());

        session.close();
    }

    private static void insertarUsuario() {
        
        String nombre = Utilidades.pideDatoCadena("Nombre del usuario: ");
        String calle = Utilidades.pideDatoCadena("Calle del usuario: ");
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
            System.out.println(usuario.getNombre());
        }
    }
    private static void consultarDirecciones() {
        List<Direccion> usuarios = session.createQuery("from Direccion", Direccion.class)
                .getResultList();

        for (Direccion direccion : usuarios) {
            System.out.println(direccion.getCalle() + " " + direccion.getCiudad() + " " + direccion.getUsuario().getNombre());
        }
        
    }

    private static Usuario consultarUsuarioPorDireccionID(long id) {
        Direccion d = session.find(Direccion.class, id);
        return d.getUsuario();        
    }

    private static Usuario consultarUsuarioPorDireccionIDHQL(long id) {
        String queryHql = "from Usuario u where u.direccion.id =: idDireccion";
        Query<Usuario> query = session.createQuery(queryHql, Usuario.class);
        query.setParameter("idDireccion", id);

        Usuario usuario = query.uniqueResult();
        return usuario;
    }
}
