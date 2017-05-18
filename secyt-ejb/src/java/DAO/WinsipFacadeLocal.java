/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.categorizacion.Winsip;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface WinsipFacadeLocal {

    void create(Winsip winsip);

    void edit(Winsip winsip);

    void remove(Winsip winsip);

    Winsip find(Object id);

    List<Winsip> findAll();

    List<Winsip> findRange(int[] range);

    int count();
    
    List<Winsip> findByProyecto(Long idProyecto) throws Exception;
    
}
