/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.becas.evaluacion.BecasEvaluacionWeb;
import entidades.persona.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class BecasEvaluacionWebFacade extends AbstractFacade<BecasEvaluacionWeb> implements BecasEvaluacionWebFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BecasEvaluacionWebFacade() {
        super(BecasEvaluacionWeb.class);
    }

    @Override
    public List<BecasEvaluacionWeb> findByEvaluadorPrincipal(Long idEvaluador) {

        Query q = em.createNamedQuery("BecasEvaluacionWeb.findByEvaluadorPrincipal");
        q.setParameter("idEvaluador", idEvaluador);   
        return q.getResultList();
    }
    
}
