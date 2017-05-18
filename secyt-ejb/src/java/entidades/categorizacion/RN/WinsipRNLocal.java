/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.categorizacion.RN;

import entidades.categorizacion.Winsip;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface WinsipRNLocal {
    List<Winsip> findByProyecto(Long idProyecto) throws Exception;
}
