/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.AreaTematica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface AreaTematicaFacadeLocal {

    void create(AreaTematica areaTematica);

    void edit(AreaTematica areaTematica);

    void remove(AreaTematica areaTematica);

    AreaTematica find(Object id);

    List<AreaTematica> findAll();

    List<AreaTematica> findRange(int[] range);

    int count();
    
    List<AreaTematica> findAreasTematicas() throws Exception;
               
            
}
