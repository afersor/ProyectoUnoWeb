/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.titulo.TituloGrado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hugo
 */
@Stateless
public class TituloGradoFacade extends AbstractFacade<TituloGrado> implements TituloGradoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TituloGradoFacade() {
        super(TituloGrado.class);
    }

    @Override
    public List<TituloGrado> findTitulosGrado() {
        Query query=em.createNamedQuery("TituloGrado.findTitulosGrado");
        return query.getResultList();
    }

    
    
}
