/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.TipoProyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface TipoProyectoFacadeLocal {

    void create(TipoProyecto tipoProyecto);

    void edit(TipoProyecto tipoProyecto);

    void remove(TipoProyecto tipoProyecto);

    TipoProyecto find(Object id);

    List<TipoProyecto> findAll();

    List<TipoProyecto> findRange(int[] range);

    int count();
    
    List<TipoProyecto> findTiposProyectos() throws Exception;
    
}
