/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
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
public class LocalidadFacade extends AbstractFacade<Localidad> implements LocalidadFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadFacade() {
        super(Localidad.class);
    }

    @Override
    public List<Localidad> findLocalidadesByDpto(Departamento departamento) throws Exception {
       Query q = em.createNamedQuery("Localidad.findLocalidadesByDpto");
        q.setParameter("departamento", departamento);
        return q.getResultList();
    }
    
}
