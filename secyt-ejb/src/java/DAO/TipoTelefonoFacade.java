/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.TipoTelefono;
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
public class TipoTelefonoFacade extends AbstractFacade<TipoTelefono> implements TipoTelefonoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTelefonoFacade() {
        super(TipoTelefono.class);
    }

    @Override
    public List<TipoTelefono> findTipoTelefonos() throws Exception {
        Query q = em.createNamedQuery("TipoTelefono.findTipoTelefonos");
        return q.getResultList();
    }
    
}
