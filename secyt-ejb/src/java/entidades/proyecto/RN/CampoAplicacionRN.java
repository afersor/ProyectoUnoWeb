/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.CampoAplicacionFacadeLocal;
import entidades.proyecto.CampoAplicacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class CampoAplicacionRN implements CampoAplicacionRNLocal {

    @EJB
    private CampoAplicacionFacadeLocal campoAplicacionFacadeLocal;
    
    @Override
    public List<CampoAplicacion> findLikeDescripcion(String cadena) throws Exception {
        return campoAplicacionFacadeLocal.findLikeDescripcion(cadena);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
