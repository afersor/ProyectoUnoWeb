/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.AccesoFacadeLocal;
import entidades.persona.investigador.Acceso;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class AccesoRN implements AccesoRNLocal {

    @EJB
    private AccesoFacadeLocal accesoFacadeLocal;
    
    @Override
    public void create(Acceso acceso) throws Exception {
        accesoFacadeLocal.create(acceso);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
