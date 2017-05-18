/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.vinculacion.ParticipacionVinculacion;
import entidades.proyecto.vinculacion.ProyectoVinculacion;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Franco
 */
@Stateless
public class ProyectoVinculacionFacade extends AbstractFacade<ProyectoVinculacion> implements ProyectoVinculacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoVinculacionFacade() {
        super(ProyectoVinculacion.class);
    }
     @Override
    public String getDirector(ProyectoVinculacion proy) {
        try {
            Query quDirector = em.createQuery("SELECT pa FROM ParticipacionVinculacion pa "
                    + "WHERE pa.rol.descripcion=:car AND"
                    //+ "(pa.fechaHasta IS NULL  OR pa.fechaHasta > :fecha ) AND pa.rol.descripcion=:car AND "
                    + "pa.proyectoVinculacion=:proye ORDER BY pa.id DESC");
            quDirector.setParameter("car", "Director");
            quDirector.setParameter("fecha", new Date());
            quDirector.setParameter("proye", proy);
            ParticipacionVinculacion pa = (ParticipacionVinculacion) quDirector.getResultList().get(0);
            if (pa != null) {
                return pa.getInvestigador().toString();
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}
