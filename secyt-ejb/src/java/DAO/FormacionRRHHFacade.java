/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.resultado.FormacionRRHH;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alumno
 */
@Stateless
public class FormacionRRHHFacade extends AbstractFacade<FormacionRRHH> implements FormacionRRHHFacadeLocal {

    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormacionRRHHFacade() {
        super(FormacionRRHH.class);
    }

    @Override
    public List<FormacionRRHH> findByTypeYProyecto(Long idProyecto, Long idInvestigador) throws Exception {
       System.out.println("Entro");
        Query q = em.createNamedQuery("FormacionRRHH.findByInvestigador");  
         q.setParameter("idProyecto",idProyecto);
         q.setParameter("idInvestigador",idInvestigador);
        
         return q.getResultList();
    
    }
    
}
