/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.EspecialidadActividadAcademica;
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
public class EspecialidadActividadAcademicaFacade extends AbstractFacade<EspecialidadActividadAcademica> implements EspecialidadActividadAcademicaFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecialidadActividadAcademicaFacade() {
        super(EspecialidadActividadAcademica.class);
    }

    @Override
    public List<EspecialidadActividadAcademica> findLikeDescripcion(String cadena) throws Exception {
        cadena = cadena.trim().toLowerCase();
        Query q = em.createNamedQuery("EspecialidadActividadAcademica.findLikeDescripcion");
        q.setParameter("cadena", "%" + cadena + "%");   
        
        return q.getResultList();
    }
    
}
