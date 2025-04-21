package es.samujava.hibernate.dao;

import java.util.List;

import es.samujava.hibernate.dto.CaballoDTO;
import es.samujava.hibernate.entities.CaballoCarrera;

public class CaballoDAOJDBCImpl implements CaballoDAO{

    @Override
    public void insertar(CaballoCarrera caballo) {
        
    }

    @Override
    public CaballoCarrera getCaballoPorId(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CaballoDTO obtenerJinete(long caballoId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CaballoCarrera> obtenerTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }

    @Override
    public List<CaballoCarrera> obtenerActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerActivos'");
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public void actualizar(CaballoCarrera caballo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }


}
