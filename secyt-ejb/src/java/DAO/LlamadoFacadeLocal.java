/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.categorizacion.Llamado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface LlamadoFacadeLocal {

    void create(Llamado llamado);

    void edit(Llamado llamado);

    void remove(Llamado llamado);

    Llamado find(Object id);

    List<Llamado> findAll();

    List<Llamado> findRange(int[] range);

    int count();
    
}
