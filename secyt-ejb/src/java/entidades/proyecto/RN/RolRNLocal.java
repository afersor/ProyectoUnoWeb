/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import entidades.proyecto.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface RolRNLocal {
    List<Rol> findRolesSinDirector() throws Exception;
    List<Rol> findRolesSinDirectorCoDirector() throws Exception;
}
