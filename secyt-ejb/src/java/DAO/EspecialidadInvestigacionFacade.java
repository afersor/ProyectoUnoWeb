/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.EspecialidadInvestigacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class EspecialidadInvestigacionFacade extends AbstractFacade<EspecialidadInvestigacion> implements EspecialidadInvestigacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecialidadInvestigacionFacade() {
        super(EspecialidadInvestigacion.class);
    }

    @Override
    public List<EspecialidadInvestigacion> findLikeDescripcion(String cadena) throws Exception {
        cadena = cadena.trim().toLowerCase();
        Query q = em.createNamedQuery("EspecialidadInvestigacion.findLikeDescripcion");
        q.setParameter("cadena", "%" + cadena + "%");   
        
        return q.getResultList();
    }
    
}
