/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.AreaTematica;
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
public class AreaTematicaFacade extends AbstractFacade<AreaTematica> implements AreaTematicaFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaTematicaFacade() {
        super(AreaTematica.class);
    }

    @Override
    public List<AreaTematica> findAreasTematicas() throws Exception {
        Query q = em.createNamedQuery("AreaTematica.findAreasTematicas");
        return q.getResultList();
    }
    
}
