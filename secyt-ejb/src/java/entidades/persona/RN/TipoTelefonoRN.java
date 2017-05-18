/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.RN;

import DAO.TipoTelefonoFacadeLocal;
import entidades.persona.TipoTelefono;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class TipoTelefonoRN implements TipoTelefonoRNLocal {

    @EJB
    private TipoTelefonoFacadeLocal tipoTelefonoFacadeLocal;
    
    @Override
    public List<TipoTelefono> findTipoTelefonos() throws Exception {
        return tipoTelefonoFacadeLocal.findTipoTelefonos();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
