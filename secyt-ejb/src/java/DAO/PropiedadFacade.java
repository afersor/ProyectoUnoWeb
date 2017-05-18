/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.resultado.Propiedad;
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
public class PropiedadFacade extends AbstractFacade<Propiedad> implements PropiedadFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropiedadFacade() {
        super(Propiedad.class);
    }

    @Override
    public List<Propiedad> findByTypeYProyecto(Long idProyecto,Long idInvestigador, Class tipo) throws Exception {
        
        System.out.println("Entro");
        Query q = em.createNamedQuery("Propiedad.findByTypeYProyecto");  
         q.setParameter("idProyecto",idProyecto);
         q.setParameter("idInvestigador",idInvestigador);
         q.setParameter("tipo", tipo);
         return q.getResultList();
    }//fin findByTypeYProyecto
    
}
