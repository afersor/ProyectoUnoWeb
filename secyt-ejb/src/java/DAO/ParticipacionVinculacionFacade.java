/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.vinculacion.ParticipacionVinculacion;
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
public class ParticipacionVinculacionFacade extends AbstractFacade<ParticipacionVinculacion> implements ParticipacionVinculacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParticipacionVinculacionFacade() {
        super(ParticipacionVinculacion.class);
    }

    @Override
    public List<ParticipacionVinculacion> findByInvestigador(Long idInvestigador) throws Exception {
        Query q = em.createNamedQuery("ParticipacionVinculacion.findByInvestigador");
        q.setParameter("idInvestigador", idInvestigador);
        return q.getResultList();
    }
    
}
