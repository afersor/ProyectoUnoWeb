/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.EspecialidadInvestigacionFacadeLocal;
import entidades.persona.investigador.EspecialidadInvestigacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class EspecialidadInvestigacionRN implements EspecialidadInvestigacionRNLocal {

    @EJB
    private EspecialidadInvestigacionFacadeLocal especialidadInvestigacionFacadeLocal;
    
    @Override
    public List<EspecialidadInvestigacion> findLikeDescripcion(String cadena) throws Exception {
        return especialidadInvestigacionFacadeLocal.findLikeDescripcion(cadena);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
