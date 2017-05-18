/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.UnidadInvestigacionFacadeLocal;
import entidades.proyecto.UnidadInvestigacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class UnidadInvestigacionRN implements UnidadInvestigacionRNLocal {

    @EJB
    private UnidadInvestigacionFacadeLocal unidadInvestigacionFacadeLocal;
    
    @Override
    public List<UnidadInvestigacion> findLikeDescripcion(String cadena) throws Exception {
        return unidadInvestigacionFacadeLocal.findLikeDescripcion(cadena);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
