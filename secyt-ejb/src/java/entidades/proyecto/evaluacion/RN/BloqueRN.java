/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import DAO.BloqueFacadeLocal;
import entidades.proyecto.evaluacion.Bloque;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class BloqueRN implements BloqueRNLocal {

    @EJB
    private BloqueFacadeLocal bloqueFacadeLocal;
    
    @Override
    public List<Bloque> findAll() throws Exception {
        return bloqueFacadeLocal.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
