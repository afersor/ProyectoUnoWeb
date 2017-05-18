/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import DAO.ContenidoBloqueFacadeLocal;
import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.ContenidoBloque;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class ContenidoBloqueRN implements ContenidoBloqueRNLocal {

    @EJB
    private ContenidoBloqueFacadeLocal contenidoBloqueFacadeLocal;
    
    @Override
    public List<ContenidoBloque> findByBLoque(Bloque bloque) throws Exception {
        return contenidoBloqueFacadeLocal.findByBLoque(bloque);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
