/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import DAO.TipoProyectoFacadeLocal;
import entidades.TipoProyecto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class TipoProyectoRN implements TipoProyectoRNLocal {

    @EJB
    private TipoProyectoFacadeLocal tipoProyectoFacadeLocal;
    
    @Override
    public List<TipoProyecto> findTiposProyectos() throws Exception {
        return tipoProyectoFacadeLocal.findTiposProyectos();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
