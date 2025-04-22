package es.samujava.hibernate.dao;

import java.util.List;

import es.samujava.hibernate.dto.CaballoDTO;
import es.samujava.hibernate.entities.CaballoCarrera;

public interface CaballoDAO {
    void insertar(CaballoCarrera caballo);
    List<CaballoCarrera> obtenerTodos();
    List<CaballoCarrera> obtenerActivos();
    List<CaballoCarrera> buscarJinetePorNacionalidad(String nacionalidad);
    void eliminar(Long id);
    void actualizar(CaballoCarrera caballo);
    CaballoDTO obtenerJinete (long caballoId);
    CaballoCarrera getCaballoPorId (long id);
    
}