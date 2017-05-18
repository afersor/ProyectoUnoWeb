/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.vinculacion.ProyectoVinculacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Franco
 */
@Local
public interface ProyectoVinculacionFacadeLocal {

    void create(ProyectoVinculacion proyectoVinculacion);

    void edit(ProyectoVinculacion proyectoVinculacion);

    void remove(ProyectoVinculacion proyectoVinculacion);

    ProyectoVinculacion find(Object id);

    List<ProyectoVinculacion> findAll();

    List<ProyectoVinculacion> findRange(int[] range);

    int count();

    public java.lang.String getDirector(entidades.proyecto.vinculacion.ProyectoVinculacion proy);
    
}
