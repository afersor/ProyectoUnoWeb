/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.categorizacion.RN;

import DAO.LlamadoFacadeLocal;
import entidades.categorizacion.Llamado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class LlamadoRN implements LlamadoRNLocal {

    @EJB
    private LlamadoFacadeLocal llamadoFacadeLocal;
    
    @Override
    public List<Llamado> findAll() throws Exception{
        return llamadoFacadeLocal.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
