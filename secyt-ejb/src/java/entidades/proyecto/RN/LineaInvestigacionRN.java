/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.LineaInvestigacionFacadeLocal;
import entidades.proyecto.LineaInvestigacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class LineaInvestigacionRN implements LineaInvestigacionRNLocal {

    @EJB
    private LineaInvestigacionFacadeLocal lineaInvestigacionFacadeLocal;
    
    @Override
    public List<LineaInvestigacion> findLineasInvestigacion() throws Exception {
         return lineaInvestigacionFacadeLocal.findLineasInvestigacion();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
