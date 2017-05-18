/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.categorizacion.RN;

import DAO.ComisionCategorizacionFacadeLocal;
import entidades.categorizacion.ComisionCategorizacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class ComisionCategorizacionRN implements ComisionCategorizacionRNLocal {

    @EJB
    private ComisionCategorizacionFacadeLocal comisionCategorizacionFacadeLocal;
    @Override
    public List<ComisionCategorizacion> findAll() throws Exception {
        return comisionCategorizacionFacadeLocal.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
