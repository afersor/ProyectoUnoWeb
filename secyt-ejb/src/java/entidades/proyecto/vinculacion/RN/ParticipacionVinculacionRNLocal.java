/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.vinculacion.RN;

import entidades.proyecto.vinculacion.ParticipacionVinculacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface ParticipacionVinculacionRNLocal {
    List<ParticipacionVinculacion> findByInvestigador(Long idInvestigador) throws Exception;
}
