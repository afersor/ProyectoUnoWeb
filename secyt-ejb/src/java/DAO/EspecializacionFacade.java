/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.Especializacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author diego
 */
@Stateless
public class EspecializacionFacade extends AbstractFacade<Especializacion> implements EspecializacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecializacionFacade() {
        super(Especializacion.class);
    }

    @Override
    public List<Especializacion> findByInvestigador(Long idInvestigador) throws Exception {
        Query q = em.createNamedQuery("Especializacion.findByInvestigador");
        q.setParameter("idInvestigador", idInvestigador);
        return q.getResultList();
    }//fin findByInvestigador

    @Override
    public Boolean findByInvestigadorYEspecializacion(Especializacion esp) throws Exception {
        try{
            Query q = em.createNamedQuery("Especializacion.findByInvestigadorYEspecializacion");
            System.out.println("paso" + esp.getInvestigador().getId() +  " " +
                    esp.getAño() + " " +
                        esp.getEspecialidadInvestigacion() + " " + 
                    esp.getEspecialidadActividadAcademica());
            q.setParameter("idInvestigador", esp.getInvestigador().getId());
            q.setParameter("anio", esp.getAño());
            q.setParameter("especialidadInvestigacion", esp.getEspecialidadInvestigacion());
            q.setParameter("especialidadActividadAcademica", esp.getEspecialidadActividadAcademica());
            q.getSingleResult();
            System.out.println("paso");
            return true;
        }catch(NoResultException nre){
            return false;
        }
    }
    
}
