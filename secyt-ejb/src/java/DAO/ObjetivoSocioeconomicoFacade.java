/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.ObjetivoSocioeconomico;
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
public class ObjetivoSocioeconomicoFacade extends AbstractFacade<ObjetivoSocioeconomico> implements ObjetivoSocioeconomicoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivoSocioeconomicoFacade() {
        super(ObjetivoSocioeconomico.class);
    }

    @Override
    public List<ObjetivoSocioeconomico> findObjetivosSocioeconomicos() throws Exception {
        Query q = em.createNamedQuery("ObjetivoSocioeconomico.findObjetivosSocioeconomicos");
        return q.getResultList();
    }
    
}
