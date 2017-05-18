/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import entidades.proyecto.AreaTematica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface AreaTematicaRNLocal {

    List<AreaTematica> findAreasTematicas() throws Exception;

    AreaTematica find(Long id);

}
