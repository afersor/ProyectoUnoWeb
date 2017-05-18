/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.RolFacadeLocal;
import entidades.proyecto.Rol;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class RolRN implements RolRNLocal {

    @EJB
    private RolFacadeLocal rolFacadeLocal;
    
    @Override
    public List<Rol> findRolesSinDirector() throws Exception {
        return rolFacadeLocal.findRolesSinDirector();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Rol> findRolesSinDirectorCoDirector() throws Exception {
        return rolFacadeLocal.findRolesSinDirectorCoDirector();
    }

}
