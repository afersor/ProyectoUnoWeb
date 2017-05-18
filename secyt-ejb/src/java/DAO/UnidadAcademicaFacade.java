/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.UnidadAcademica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class UnidadAcademicaFacade extends AbstractFacade<UnidadAcademica> implements UnidadAcademicaFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadAcademicaFacade() {
        super(UnidadAcademica.class);
    }

    @Override
    public List<UnidadAcademica> findUnidadesAcademicasUnca() throws Exception {
        Query q = em.createNamedQuery("UnidadAcademica.findUnidadesAcademicasUnca");
        return q.getResultList();
    }

    @Override
    public Boolean findUnidadAcademicaByNombre(String nombre) throws Exception {
        try{
        Query q = em.createNamedQuery("UnidadAcademica.findUnidadesAcademicasByNombre");
        q.setParameter("nombre", nombre.trim().toLowerCase());
        q.getSingleResult();
        return true;
        }catch(NoResultException ex){
            return false;
        }
    }
    
}
