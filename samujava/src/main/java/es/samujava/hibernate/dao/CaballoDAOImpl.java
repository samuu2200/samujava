package es.samujava.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.samujava.hibernate.dto.CaballoDTO;
import es.samujava.hibernate.entities.CaballoCarrera;
import es.samujava.utils.HibernateUtil;

public class CaballoDAOImpl implements CaballoDAO {
    @Override
    public void insertar(CaballoCarrera caballo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(caballo);
        tx.commit();
    }

    @Override
    public CaballoCarrera getCaballoPorId(long id) {
        Session session = HibernateUtil.getSession();
        CaballoCarrera cc = session.find(CaballoCarrera.class, id);
        return cc;
    }

    @Override
    public CaballoDTO obtenerJinete(long caballoId) {
        Session session = HibernateUtil.getSession();
        String queryJinete = "select es.samujava.hibernate.dtoCaballoDTO(cc.Jinete.nombre, cc.Jinete.nacionalidad) from CaballoCarrera cc where id =: param1";

        Query<CaballoDTO> query = session.createQuery(queryJinete, CaballoDTO.class);
        query.setParameter("param1", caballoId);

        CaballoDTO dto = query.uniqueResult();
        
        return dto;
    }

    @Override
    public List<CaballoCarrera> obtenerTodos() {
        Session session = HibernateUtil.getSession();
        List<CaballoCarrera> lista = session.createQuery("from CaballoCarrera", CaballoCarrera.class).list();
        return lista;
    }

    @Override
    public List<CaballoCarrera> obtenerActivos() {
        Session session = HibernateUtil.getSession();
        String queryActivos = "from CaballoCarrera cc where cc.estaActivo =: param1";

        Query<CaballoCarrera> query = session.createQuery(queryActivos, CaballoCarrera.class);
        query.setParameter("param1", true);
        List<CaballoCarrera> lista = query.list();
        
        return lista;
    }

    @Override
    public void eliminar(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        CaballoCarrera c = session.find(CaballoCarrera.class, id);
        if (c != null) session.remove(c);
        tx.commit();
    }

    @Override
    public void actualizar(CaballoCarrera caballo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(caballo);
        tx.commit();
    }
}
