/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.PresupuestoWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface PresupuestoWebFacadeLocal {

    void create(PresupuestoWeb presupuestoWeb);

    void edit(PresupuestoWeb presupuestoWeb);

    void remove(PresupuestoWeb presupuestoWeb);

    PresupuestoWeb find(Object id);

    List<PresupuestoWeb> findAll();

    List<PresupuestoWeb> findRange(int[] range);

    int count();
    
}
