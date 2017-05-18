/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.becas.PostulacionBeca;
import java.util.Date;
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
public class PostulacionBecaFacade extends AbstractFacade<PostulacionBeca> implements PostulacionBecaFacadeLocal {

    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostulacionBecaFacade() {
        super(PostulacionBeca.class);
    }

    @Override
    public List<PostulacionBeca> finByPostulanteAcreditado(Long idPostulante) throws Exception {
        Query q = em.createNamedQuery("PostulacionBeca.finByPostulanteAcreditado");
        q.setParameter("idPostulante", idPostulante);
        return q.getResultList();
    }//fin finByPostulanteAcreditado

    @Override
    public List<PostulacionBeca> finByDirectorProyecto(Long idPostulante) throws Exception {
        Query q = em.createNamedQuery("PostulacionBeca.finByDirectorProyecto");
        q.setParameter("idPostulante", idPostulante);
        q.setParameter("fecha", new Date());
        return q.getResultList();
    }
}
