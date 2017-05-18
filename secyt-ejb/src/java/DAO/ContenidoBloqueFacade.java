/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.ContenidoBloque;
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
public class ContenidoBloqueFacade extends AbstractFacade<ContenidoBloque> implements ContenidoBloqueFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContenidoBloqueFacade() {
        super(ContenidoBloque.class);
    }

    @Override
    public List<ContenidoBloque> findByBLoque(Bloque bloque) {
        Query q = em.createNamedQuery("ContenidoBloque.findByBLoque");
        q.setParameter("bloque", bloque);
        return q.getResultList();
    }//fin findByBLoque
    
}
