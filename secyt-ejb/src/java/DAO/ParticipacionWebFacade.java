/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.ParticipacionWeb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class ParticipacionWebFacade extends AbstractFacade<ParticipacionWeb> implements ParticipacionWebFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParticipacionWebFacade() {
        super(ParticipacionWeb.class);
    }
    
}
