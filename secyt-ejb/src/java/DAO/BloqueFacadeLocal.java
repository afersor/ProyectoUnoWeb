/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.Bloque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface BloqueFacadeLocal {

    void create(Bloque bloque);

    void edit(Bloque bloque);

    void remove(Bloque bloque);

    Bloque find(Object id);

    List<Bloque> findAll();

    List<Bloque> findRange(int[] range);

    int count();
    
    
}
