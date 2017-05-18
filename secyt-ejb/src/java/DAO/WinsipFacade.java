/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.categorizacion.Winsip;
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
public class WinsipFacade extends AbstractFacade<Winsip> implements WinsipFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WinsipFacade() {
        super(Winsip.class);
    }

    @Override
    public List<Winsip> findByProyecto(Long idProyecto) throws Exception {
        Query q = em.createNamedQuery("Winsip.findByProyecto");
        q.setParameter("idProyecto", idProyecto);
        return q.getResultList();
    }//fin 
    
}
