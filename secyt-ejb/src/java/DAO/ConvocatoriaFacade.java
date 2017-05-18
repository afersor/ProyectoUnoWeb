/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.Convocatoria;
import java.util.Date;
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
public class ConvocatoriaFacade extends AbstractFacade<Convocatoria> implements ConvocatoriaFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConvocatoriaFacade() {
        super(Convocatoria.class);
    }

    @Override
    public List<Convocatoria> findConvocatorias(Date fechaActual) throws Exception {
        
        Query q = em.createNamedQuery("Convocatoria.findConvocatorias");
        q.setParameter("fechaActual", fechaActual);
        System.out.println("fecha: " + fechaActual);
        System.out.println("convocatorias : " + q.getResultList());
        return q.getResultList();
        
    }//fin findConvocatorias
    
}
