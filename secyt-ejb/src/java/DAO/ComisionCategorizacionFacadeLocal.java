/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.categorizacion.ComisionCategorizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ComisionCategorizacionFacadeLocal {

    void create(ComisionCategorizacion comisionCategorizacion);

    void edit(ComisionCategorizacion comisionCategorizacion);

    void remove(ComisionCategorizacion comisionCategorizacion);

    ComisionCategorizacion find(Object id);

    List<ComisionCategorizacion> findAll();

    List<ComisionCategorizacion> findRange(int[] range);

    int count();
    
}
