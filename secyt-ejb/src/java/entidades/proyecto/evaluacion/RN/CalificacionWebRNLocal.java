/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import entidades.proyecto.evaluacion.CalificacionWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface CalificacionWebRNLocal {
    List<CalificacionWeb> findAll() throws Exception;
}
