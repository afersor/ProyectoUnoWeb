/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.SubDisciplinaCientifica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author franco
 */
@Stateless
public class SubDisciplinaCientificaFacade extends AbstractFacade<SubDisciplinaCientifica> implements SubDisciplinaCientificaFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubDisciplinaCientificaFacade() {
        super(SubDisciplinaCientifica.class);
    }
     @Override
    public List<SubDisciplinaCientifica> findConLatLong() throws Exception {
        Query q = em.createNamedQuery("SubDisciplinaCientifica.findConLatLong");
        return q.getResultList();
    }//fin SubDisciplinaCientifica.findConLatLong
}
