/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.UnidadInvestigacion;
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
public class UnidadInvestigacionFacade extends AbstractFacade<UnidadInvestigacion> implements UnidadInvestigacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadInvestigacionFacade() {
        super(UnidadInvestigacion.class);
    }
    
    @Override
    public List<UnidadInvestigacion> findLikeDescripcion(String cadena) throws Exception {
        cadena = cadena.trim().toLowerCase();
        Query q = em.createNamedQuery("UnidadInvestigacion.findLikeDescripcion");
        q.setParameter("cadena", "%" + cadena + "%");   
        
        return q.getResultList();
    }
    
}
