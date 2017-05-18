/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.PresupuestoWebDetallado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class PresupuestoWebDetalladoFacade extends AbstractFacade<PresupuestoWebDetallado> implements PresupuestoWebDetalladoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoWebDetalladoFacade() {
        super(PresupuestoWebDetallado.class);
    }
    
}
