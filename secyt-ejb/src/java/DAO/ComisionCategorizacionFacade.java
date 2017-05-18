/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.categorizacion.ComisionCategorizacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class ComisionCategorizacionFacade extends AbstractFacade<ComisionCategorizacion> implements ComisionCategorizacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionCategorizacionFacade() {
        super(ComisionCategorizacion.class);
    }
    
}
