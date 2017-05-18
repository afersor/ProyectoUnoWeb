/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.EvaluacionWeb;
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
public class EvaluacionWebFacade extends AbstractFacade<EvaluacionWeb> implements EvaluacionWebFacadeLocal {

    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacionWebFacade() {
        super(EvaluacionWeb.class);
    }

    @Override
    public List<EvaluacionWeb> findAllByEvaluador(Long idEvaluador) throws Exception {
        Query q = em.createNamedQuery("EvaluacionWeb.findAllByEvaluador");

        System.out.println("idevaluador: " + idEvaluador);
        q.setParameter("idEvaluador", idEvaluador);
        List<EvaluacionWeb> ewLst = q.getResultList();
        for (EvaluacionWeb ew : ewLst) {
            em.refresh(ew);
        }
        return ewLst;
    }

    @Override
    public List<EvaluacionWeb> findByProyecto(Long idProyecto) throws Exception {
        Query q = em.createNamedQuery("EvaluacionWeb.findByProyecto");
                q.setParameter("idProyecto", idProyecto);
        return q.getResultList();
    }

}
