/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Resolucion;
import entidades.persona.investigador.Investigador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class InvestigadorFacade extends AbstractFacade<Investigador> implements InvestigadorFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvestigadorFacade() {
        super(Investigador.class);
    }

    @Override
    public Investigador findInvestigadorByCUIL(String cuil) throws Exception {
        
        Query q = em.createNamedQuery("Investigador.findInvestigadorByCUIL");   
         q.setParameter("cuil", cuil);

         try{
             Investigador inv = (Investigador)q.getSingleResult();
             
             em.refresh(inv);
             return inv;
         }catch(NoResultException e){
             return null;
         }
    }//fin findInvestigadoresByCUIL
    
    @Override
    public Investigador findInvestigadorByCUILID(String cuil, Long id) throws Exception {
        Query q = em.createNamedQuery("Investigador.findInvestigadorByCUILID");   
         q.setParameter("cuil", cuil);
         q.setParameter("id", id);

         try{
             Investigador inv = (Investigador)q.getSingleResult();
             
             em.refresh(inv);
             return inv;
         }catch(NoResultException e){
             return null;
         }
    }

    @Override
    public List<Investigador> findLikeNombreyApellido(String cadena) throws Exception {
        cadena = cadena.trim().toLowerCase();
        Query q = em.createNamedQuery("Investigador.findLikeNombreyApellido");
        q.setParameter("cadena", "%" + cadena + "%");   
        return q.getResultList();
    }

    
    
}
