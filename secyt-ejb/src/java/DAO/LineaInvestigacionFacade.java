/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.LineaInvestigacion;
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
public class LineaInvestigacionFacade extends AbstractFacade<LineaInvestigacion> implements LineaInvestigacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaInvestigacionFacade() {
        super(LineaInvestigacion.class);
    }

    @Override
    public List<LineaInvestigacion> findLineasInvestigacion() throws Exception {
        Query q = em.createNamedQuery("LineaInvestigacion.findLineasInvestigacion");
        return q.getResultList();
    }
    
}
