/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.CalificacionWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface CalificacionWebFacadeLocal {

    void create(CalificacionWeb calificacionWeb);

    void edit(CalificacionWeb calificacionWeb);

    void remove(CalificacionWeb calificacionWeb);

    CalificacionWeb find(Object id);

    List<CalificacionWeb> findAll();

    List<CalificacionWeb> findRange(int[] range);

    int count();
    
}
