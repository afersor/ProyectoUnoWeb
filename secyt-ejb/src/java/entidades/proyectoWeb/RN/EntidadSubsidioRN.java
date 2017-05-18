/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb.RN;

import DAO.EntidadSubsidioFacadeLocal;
import entidades.proyectoWeb.EntidadSubsidio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class EntidadSubsidioRN implements EntidadSubsidioRNLocal {

    @EJB
    private EntidadSubsidioFacadeLocal entidadSubsidioFacadeLocal;
    
    @Override
    public List<EntidadSubsidio> findEntidadesSubsidio() throws Exception {
        return entidadSubsidioFacadeLocal.findEntidadesSubsidio();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
