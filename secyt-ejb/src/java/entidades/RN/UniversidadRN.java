/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import DAO.UniversidadFacadeLocal;
import entidades.Universidad;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class UniversidadRN implements UniversidadRNLocal {
    
    @EJB
    private UniversidadFacadeLocal universidadFacadeLocal;

    @Override
    public List<Universidad> buscarUniversidades() throws Exception {
        return universidadFacadeLocal.buscarUniversidades();
       
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
