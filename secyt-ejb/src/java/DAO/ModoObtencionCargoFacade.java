/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.ModoObtencionCargo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AFerSor
 */
@Stateless
public class ModoObtencionCargoFacade extends AbstractFacade<ModoObtencionCargo> implements ModoObtencionCargoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModoObtencionCargoFacade() {
        super(ModoObtencionCargo.class);
    }
    
}
