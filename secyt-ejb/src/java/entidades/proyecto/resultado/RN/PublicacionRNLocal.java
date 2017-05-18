/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.resultado.RN;

import entidades.proyecto.resultado.Publicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface PublicacionRNLocal {
    public List<Publicacion> findByInvestigador(Long idProyecto,Long idInvestigador, Class tipo) throws Exception;
}
