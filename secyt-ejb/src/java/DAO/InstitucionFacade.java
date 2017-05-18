/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Institucion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hugo
 */
@Stateless
public class InstitucionFacade extends AbstractFacade<Institucion> implements InstitucionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstitucionFacade() {
        super(Institucion.class);
    }

    @Override
    public List<Institucion> buscarInstituciones() throws Exception {
       Query q=em.createNamedQuery("Institucion.buscarInstituciones");
       return q.getResultList();
    }
    
}
