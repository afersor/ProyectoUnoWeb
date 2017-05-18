/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.DepartamentoDocente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AFerSor
 */
@Stateless
public class DepartamentoDocenteFacade extends AbstractFacade<DepartamentoDocente> implements DepartamentoDocenteFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoDocenteFacade() {
        super(DepartamentoDocente.class);
    }
    
}
