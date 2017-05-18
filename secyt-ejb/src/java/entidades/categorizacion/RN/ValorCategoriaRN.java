/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.categorizacion.RN;

import DAO.ValorCategoriaFacadeLocal;
import entidades.categorizacion.ValorCategoria;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class ValorCategoriaRN implements ValorCategoriaRNLocal {

    @EJB
    private ValorCategoriaFacadeLocal valorCategoriaFacadeLocal;
    
    @Override
    public List<ValorCategoria> findAll() throws Exception {
        return valorCategoriaFacadeLocal.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
