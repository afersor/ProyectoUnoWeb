/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.Sexo;
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
public class SexoFacade extends AbstractFacade<Sexo> implements SexoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SexoFacade() {
        super(Sexo.class);
    }

    @Override
    public List<Sexo> findSexos() throws Exception {
        Query q = em.createNamedQuery("Sexo.findSexos");
        return q.getResultList();
    }
    
}
