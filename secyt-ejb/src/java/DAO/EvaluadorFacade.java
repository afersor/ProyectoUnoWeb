/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.Evaluador;
import entidades.persona.investigador.Investigador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hugo
 */
@Stateless
public class EvaluadorFacade extends AbstractFacade<Evaluador> implements EvaluadorFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluadorFacade() {
        super(Evaluador.class);
    }

    @Override
    public Evaluador buscarXInvestigador(Investigador investigador) {
        Query q=em.createNamedQuery("Evaluador.buscarXInvestigador");
        q.setParameter("id", investigador.getId());
        return (Evaluador)q.getSingleResult();
    }

    @Override
    public Evaluador findEvaluadorByCUIL(String cuil) throws Exception {
        
        Query q = em.createNamedQuery("Evaluador.findInvestigadorByCUIL");   
         q.setParameter("cuil", cuil);

         try{
             Evaluador ev = (Evaluador)q.getSingleResult();
             
             em.refresh(ev);
             return ev;
         }catch(NoResultException e){
             return null;
         }
    }
    
}
