/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.Contrasena;
import entidades.persona.investigador.Investigador;
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
public class ContrasenaFacade extends AbstractFacade<Contrasena> implements ContrasenaFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContrasenaFacade() {
        super(Contrasena.class);
    }

    @Override
    public Boolean bFindByInvestigador(String cuil) throws Exception {
        Query q = em.createNamedQuery("Contrasena.findByInvestigador");       
         q.setParameter("cuil", cuil);
         try{
             q.getSingleResult();
             return true;
         }catch(NoResultException e){
             return false;
         }
    }//fin bFindByInvestigador

    @Override
    public Boolean bFindByInvestigadorYcontrasena(String cuil, String contrasena) throws Exception {
         Query q = em.createNamedQuery("Contrasena.findByInvestigadorYcontrasena");       
         q.setParameter("cuil", cuil);
         q.setParameter("contrasena", contrasena);
         try{
             q.getSingleResult();
             return true;
         }catch(NoResultException e){
             return false;
         }
    }//fin bFindByInvestigadorYcontrasena

    @Override
    public void updateContrasena(String cuil, String contrasena) throws Exception {
        
         Query q = em.createNamedQuery("Contrasena.updateContrasena");       
         q.setParameter("cuil", cuil);
         q.setParameter("contrasena", contrasena);

         q.executeUpdate();

    }//fin updateContrasena
    
}
