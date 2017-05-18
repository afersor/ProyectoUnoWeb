/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.localidad.RN;

import DAO.ProvinciaFacadeLocal;
import entidades.localidad.Provincia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class ProvinciaRN implements ProvinciaRNLocal {

    @EJB
    private ProvinciaFacadeLocal provinciaFacadeLocal;
    
    @Override
    public List<Provincia> findProvincias() throws Exception {
        return provinciaFacadeLocal.findProvincias();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
