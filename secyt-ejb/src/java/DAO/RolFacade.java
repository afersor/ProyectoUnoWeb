/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.Rol;
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
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

    @Override
    public List<Rol> findRolesSinDirector() throws Exception {
        Query q = em.createNamedQuery("Rol.findRolesSinDirector");
        return q.getResultList();
    }

    @Override
    public List<Rol> findRolesSinDirectorCoDirector() throws Exception {
        Query q = em.createNamedQuery("Rol.findRolesSinDirectorCoDirector");
        return q.getResultList();
    }
    
}
