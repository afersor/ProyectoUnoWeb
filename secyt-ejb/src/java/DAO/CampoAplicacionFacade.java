/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.CampoAplicacion;
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
public class CampoAplicacionFacade extends AbstractFacade<CampoAplicacion> implements CampoAplicacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CampoAplicacionFacade() {
        super(CampoAplicacion.class);
    }

    @Override
    public List<CampoAplicacion> findLikeDescripcion(String cadena) throws Exception {
        cadena = cadena.trim().toLowerCase();
        Query q = em.createNamedQuery("CampoAplicacion.findLikeDescripcion");
        q.setParameter("cadena", "%" + cadena + "%");   
        
        return q.getResultList();
    }
    
}
