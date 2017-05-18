/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.categorizacion.RN;

import DAO.WinsipFacadeLocal;
import entidades.categorizacion.Winsip;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class WinsipRN implements WinsipRNLocal {

    @EJB
    private WinsipFacadeLocal winsipFacadeLocal;
    
    @Override
    public List<Winsip> findByProyecto(Long idProyecto) throws Exception {
        return winsipFacadeLocal.findByProyecto(idProyecto);
    }


}
