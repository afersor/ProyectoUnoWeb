/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.PropiedadFacadeLocal;
import entidades.proyecto.resultado.Propiedad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class PropiedadRN implements PropiedadRNLocal {

    @EJB
    private PropiedadFacadeLocal propiedadFacadeLocal;
    
    @Override
    public List<Propiedad> findByTypeYProyecto(Long idProyecto,Long idInvestigador, Class tipo) throws Exception {
        return propiedadFacadeLocal.findByTypeYProyecto(idProyecto,idInvestigador, tipo);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
