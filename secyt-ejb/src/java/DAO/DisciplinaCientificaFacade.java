/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.AreaTematica;
import entidades.proyecto.DisciplinaCientifica;
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
public class DisciplinaCientificaFacade extends AbstractFacade<DisciplinaCientifica> implements DisciplinaCientificaFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DisciplinaCientificaFacade() {
        super(DisciplinaCientifica.class);
    }
    
    @Override
    public List<DisciplinaCientifica> findDisciplinasCientificas() throws Exception {
        Query q = em.createNamedQuery("DisciplinaCientifica.findDisciplinasCientificas");
        return q.getResultList();
    }
    
     @Override
    public List<DisciplinaCientifica> findDisciplinasCientificasByAreaTematica(AreaTematica areaTematica) throws Exception {
        Query q = em.createNamedQuery("DisciplinaCientifica.findDisciplinasCientificasByAreaTematica");
        q.setParameter("areaTematica", areaTematica);
        return q.getResultList();
    }
}
