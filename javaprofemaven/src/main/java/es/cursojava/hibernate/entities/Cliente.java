package es.cursojava.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/*
 * 
 * Un índice es una estructura que mejora la velocidad de las operaciones de búsqueda 
 * en una tabla. 
 * Funciona como el índice de un libro: en lugar de leer todo el contenido, 
 * puedes ir directo a la página que buscas.
 * 
 * Se crea sobre una o varias columnas.
 * Hace más rápidas las consultas con condiciones WHERE, JOIN, ORDER BY, etc.
 * Puede ralentizar las inserciones y actualizaciones, 
 * ya que el índice también debe mantenerse actualizado.
 * 
 */

@Entity
// @Table(name = "TB_CLIENTES_IDX", indexes = {
//      @Index(name = "idx_email", columnList = "email")
// })
@Table(name = "TB_CLIENTES")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false)
    private String email;


    

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}