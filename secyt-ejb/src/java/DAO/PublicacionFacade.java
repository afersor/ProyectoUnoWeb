/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.resultado.ArticuloRevista;
import entidades.proyecto.resultado.Publicacion;
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
public class PublicacionFacade extends AbstractFacade<Publicacion> implements PublicacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicacionFacade() {
        super(Publicacion.class);
    }

    @Override
    public List<Publicacion> findByInvestigador(Long idProyecto,Long idInvestigador, Class tipo) throws Exception {
        
         Query q = em.createNamedQuery("Publicacion.findByInvestigador");  
         q.setParameter("idProyecto",idProyecto);
         q.setParameter("idInvestigador",idInvestigador);
         q.setParameter("tipo", tipo);
         return q.getResultList();

    }//fin finByInvestigador
    
}//FIN CLASE
