/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hugo
 */
@Stateless
public class BloqueEvaluadoFacade extends AbstractFacade<BloqueEvaluado> implements BloqueEvaluadoFacadeLocal {

    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BloqueEvaluadoFacade() {
        super(BloqueEvaluado.class);
    }

    @Override
    public BloqueEvaluado buscarPorId(Long id) {
        Query q = em.createNamedQuery("BloqueEvaluado.buscarPorId");
        q.setParameter("id", id);
        try {
            BloqueEvaluado bloqueEvaluado = (BloqueEvaluado) q.getSingleResult();
            em.refresh(bloqueEvaluado);
            return bloqueEvaluado;
        } catch (Exception e) {
            return null;
        }


    }
}
