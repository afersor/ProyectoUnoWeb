/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.UnidadAcademica;
import entidades.UnidadEjecutora;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author diego
 */
@Stateless
public class UnidadEjecutoraFacade extends AbstractFacade<UnidadEjecutora> implements UnidadEjecutoraFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadEjecutoraFacade() {
        super(UnidadEjecutora.class);
    }

    @Override
    public List<UnidadEjecutora> findUnidadesEjecutoras() throws Exception {
        Query q = em.createNamedQuery("UnidadEjecutora.findUnidadesEjecutoras");
        return q.getResultList();
    }

   
    
}
