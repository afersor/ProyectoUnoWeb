/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.vinculacion.RN;

import DAO.ParticipacionVinculacionFacadeLocal;
import entidades.proyecto.vinculacion.ParticipacionVinculacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class ParticipacionVinculacionRN implements ParticipacionVinculacionRNLocal {

    @EJB
    private ParticipacionVinculacionFacadeLocal participacionVinculacionFacadeLocal;
    
    @Override
    public List<ParticipacionVinculacion> findByInvestigador(Long idInvestigador) throws Exception {
        return participacionVinculacionFacadeLocal.findByInvestigador(idInvestigador);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
