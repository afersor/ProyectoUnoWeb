/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.titulo.TituloPosgrado;
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
public class TituloPosgradoFacade extends AbstractFacade<TituloPosgrado> implements TituloPosgradoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TituloPosgradoFacade() {
        super(TituloPosgrado.class);
    }

    @Override
    public List<TituloPosgrado> buscarTitulosPosgrado() {
        Query q=em.createNamedQuery("TituloPosgrado.buscarTitulosPosgrado");
        return q.getResultList();
    }
    
}
