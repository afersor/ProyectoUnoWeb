/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import entidades.proyecto.evaluacion.Bloque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface BloqueRNLocal {
    List<Bloque> findAll() throws Exception;
}
