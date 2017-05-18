/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.ContenidoBloque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ContenidoBloqueRNLocal {
    List<ContenidoBloque> findByBLoque(Bloque bloque) throws Exception;
}
