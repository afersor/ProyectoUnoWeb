/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.PresupuestoWebDetallado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface PresupuestoWebDetalladoFacadeLocal {

    void create(PresupuestoWebDetallado presupuestoWebDetallado);

    void edit(PresupuestoWebDetallado presupuestoWebDetallado);

    void remove(PresupuestoWebDetallado presupuestoWebDetallado);

    PresupuestoWebDetallado find(Object id);

    List<PresupuestoWebDetallado> findAll();

    List<PresupuestoWebDetallado> findRange(int[] range);

    int count();
    
}
