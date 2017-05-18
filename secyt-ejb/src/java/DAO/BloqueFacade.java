/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.Bloque;
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
public class BloqueFacade extends AbstractFacade<Bloque> implements BloqueFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BloqueFacade() {
        super(Bloque.class);
    }
    
    
       @Override
    public List<Bloque> findAll() {
        Query q = em.createNamedQuery("Bloque.findAllOrderByDescripcion");
        return q.getResultList();
    }
}
