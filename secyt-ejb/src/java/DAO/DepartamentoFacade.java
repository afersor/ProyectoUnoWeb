/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.localidad.Departamento;
import entidades.localidad.Provincia;
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
public class DepartamentoFacade extends AbstractFacade<Departamento> implements DepartamentoFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }

    @Override
    public List<Departamento> findDepartamentosByProvincia(Provincia provincia) throws Exception {
        Query q = em.createNamedQuery("Departamento.findDepartamentosByProvincia");
        q.setParameter("provincia", provincia);
        return q.getResultList();
    }
    
}
