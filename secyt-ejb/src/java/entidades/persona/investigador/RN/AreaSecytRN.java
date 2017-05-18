/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.AreaSecytFacadeLocal;
import entidades.persona.investigador.AreaSecyt;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class AreaSecytRN implements AreaSecytRNLocal {

    @EJB
    private AreaSecytFacadeLocal areaSecytFacadeLocal ;
    
    @Override
    public List<AreaSecyt> findAll() {
        return areaSecytFacadeLocal.findAll();
    }//FIN findAll

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
