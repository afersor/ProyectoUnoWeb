/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.EntidadSubsidio;
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
public class EntidadSubsidioFacade extends AbstractFacade<EntidadSubsidio> implements EntidadSubsidioFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadSubsidioFacade() {
        super(EntidadSubsidio.class);
    }

    @Override
    public List<EntidadSubsidio> findEntidadesSubsidio() throws Exception {
        Query q = em.createNamedQuery("Provincia.findEntidadesSubsidios");
        return q.getResultList();
    }
    
}
