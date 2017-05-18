/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.DedicacionDocente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface DedicacionDocenteFacadeLocal {

    void create(DedicacionDocente dedicacionDocente);

    void edit(DedicacionDocente dedicacionDocente);

    void remove(DedicacionDocente dedicacionDocente);

    DedicacionDocente find(Object id);

    List<DedicacionDocente> findAll();

    List<DedicacionDocente> findRange(int[] range);

    int count();
    
}
