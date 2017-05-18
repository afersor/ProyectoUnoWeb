/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.MensajeEvaluacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hugo
 */
@Stateless
public class MensajeEvaluacionFacade extends AbstractFacade<MensajeEvaluacion> implements MensajeEvaluacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeEvaluacionFacade() {
        super(MensajeEvaluacion.class);
    }

    @Override
    public int contarNoLeidos(BloqueEvaluado bloqueEvaluado) {
        Query q = em.createQuery("SELECT COUNT(m) from MensajeEvaluacion m WHERE m.bloqueEvaluado=:bloqueEvaluado AND m.leido=FALSE");
        q.setParameter("bloqueEvaluado", bloqueEvaluado);
        int cantidad = Integer.valueOf(q.getSingleResult().toString());
        return cantidad;
    }
    
}
