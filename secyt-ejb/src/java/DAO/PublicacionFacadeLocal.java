/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.Proyecto;
import entidades.proyecto.resultado.Libro;
import entidades.proyecto.resultado.Publicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface PublicacionFacadeLocal {

    void create(Publicacion publicacion);

    void edit(Publicacion publicacion);

    void remove(Publicacion publicacion);

    Publicacion find(Object id);

    List<Publicacion> findAll();

    List<Publicacion> findRange(int[] range);

    int count();
    
    public List<Publicacion> findByInvestigador(Long idProyecto, Long idInvestigador, Class tipo) throws Exception;
    
    public void activate(Publicacion al, Boolean bEstado) throws Exception;
    
    public List<Libro> getLibros() throws Exception;
    
    
    public List<Libro> getLibrosTodos(String texto) throws Exception;
    public List<Libro> getLibrosProyecto(Proyecto proyecto) throws Exception;
}
