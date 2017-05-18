/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import DAO.UnidadEjecutoraFacadeLocal;
import entidades.UnidadEjecutora;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class UnidadEjecutoraRN implements UnidadEjecutoraRNLocal {

    @EJB
    private UnidadEjecutoraFacadeLocal unidadEjecutoraFacadeLocal;
    
    @Override
    public List<UnidadEjecutora> findUnidadesEjecutoras() throws Exception {
       return unidadEjecutoraFacadeLocal.findUnidadesEjecutoras();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
