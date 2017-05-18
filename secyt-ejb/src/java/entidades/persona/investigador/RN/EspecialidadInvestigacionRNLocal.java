/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import entidades.persona.investigador.EspecialidadInvestigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface EspecialidadInvestigacionRNLocal {
    List<EspecialidadInvestigacion> findLikeDescripcion(String cadena) throws Exception;
}
