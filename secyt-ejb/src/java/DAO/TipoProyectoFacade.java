/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.TipoProyecto;
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
public class TipoProyectoFacade extends AbstractFacade<TipoProyecto> implements TipoProyectoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProyectoFacade() {
        super(TipoProyecto.class);
    }

    @Override
    public List<TipoProyecto> findTiposProyectos() throws Exception {
        Query q = em.createNamedQuery("TipoProyecto.findTiposProyectos");
        return q.getResultList();
    }
    
}
