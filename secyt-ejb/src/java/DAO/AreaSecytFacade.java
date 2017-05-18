/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.AreaSecyt;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AFerSor
 */
@Stateless
public class AreaSecytFacade extends AbstractFacade<AreaSecyt> implements AreaSecytFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaSecytFacade() {
        super(AreaSecyt.class);
    }
    
}
