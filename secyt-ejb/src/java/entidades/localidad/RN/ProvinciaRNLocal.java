/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.localidad.RN;

import entidades.localidad.Provincia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ProvinciaRNLocal {
    List<Provincia> findProvincias() throws Exception;
}
