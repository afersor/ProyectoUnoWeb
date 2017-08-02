/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.resultado.Contrato;
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
public class ContratoFacade extends AbstractFacade<Contrato> implements ContratoFacadeLocal {

    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratoFacade() {
        super(Contrato.class);
    }

    @Override
    public List<Contrato> findByTypeYProyecto(Long idProyecto, Long idInvestigador) throws Exception {
     System.out.println("Entro");
        Query q = em.createNamedQuery("Contrato.findByInvestigador");  
         q.setParameter("idProyecto",idProyecto);
         q.setParameter("idInvestigador",idInvestigador);
        
         return q.getResultList();
    }
    
}
