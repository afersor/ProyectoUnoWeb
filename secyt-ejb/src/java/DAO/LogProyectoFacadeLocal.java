/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.LogProyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface LogProyectoFacadeLocal {

    void create(LogProyecto logProyecto);

    void edit(LogProyecto logProyecto);

    void remove(LogProyecto logProyecto);

    LogProyecto find(Object id);

    List<LogProyecto> findAll();

    List<LogProyecto> findRange(int[] range);

    int count();
    
}
