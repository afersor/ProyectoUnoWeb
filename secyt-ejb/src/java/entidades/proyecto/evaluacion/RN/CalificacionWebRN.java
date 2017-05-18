/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import DAO.CalificacionWebFacadeLocal;
import entidades.proyecto.evaluacion.CalificacionWeb;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class CalificacionWebRN implements CalificacionWebRNLocal {

    @EJB
    private CalificacionWebFacadeLocal calificacionWebFacadeLocal;
            
    @Override
    public List<CalificacionWeb> findAll() throws Exception {
        return calificacionWebFacadeLocal.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
