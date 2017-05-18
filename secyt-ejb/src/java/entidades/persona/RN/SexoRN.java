/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.RN;

import DAO.SexoFacadeLocal;
import entidades.persona.Sexo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class SexoRN implements SexoRNLocal {

    @EJB
    private SexoFacadeLocal sexoFacadeLocal;
    
    @Override
    public List<Sexo> findSexos() throws Exception {
        return sexoFacadeLocal.findSexos();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
