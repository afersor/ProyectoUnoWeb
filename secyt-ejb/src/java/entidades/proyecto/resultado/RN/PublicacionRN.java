/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.resultado.RN;

import DAO.PublicacionFacadeLocal;
import entidades.proyecto.resultado.Publicacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class PublicacionRN implements PublicacionRNLocal {

    @EJB
    private PublicacionFacadeLocal publicacionFacadeLocal;
    
    @Override
    public List<Publicacion> findByInvestigador(Long idProyecto,Long idInvestigador, Class tipo) throws Exception {
        return publicacionFacadeLocal.findByInvestigador(idProyecto,idInvestigador, tipo);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
