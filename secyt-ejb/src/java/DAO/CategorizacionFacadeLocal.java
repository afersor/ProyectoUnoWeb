/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.categorizacion.Categorizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface CategorizacionFacadeLocal {

    void create(Categorizacion categorizacion);

    void edit(Categorizacion categorizacion);

    void remove(Categorizacion categorizacion);

    Categorizacion find(Object id);

    List<Categorizacion> findAll();

    List<Categorizacion> findRange(int[] range);

    int count();
    
}
