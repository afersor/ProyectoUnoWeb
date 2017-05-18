/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.titulo.TituloOtro;
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
public class TituloOtroFacade extends AbstractFacade<TituloOtro> implements TituloOtroFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TituloOtroFacade() {
        super(TituloOtro.class);
    }

    @Override
    public List<TituloOtro> buscarTitulosOtro() {
        Query q=em.createNamedQuery("TituloOtro.buscarTitulosOtro");
        return q.getResultList();
    }
    
}
