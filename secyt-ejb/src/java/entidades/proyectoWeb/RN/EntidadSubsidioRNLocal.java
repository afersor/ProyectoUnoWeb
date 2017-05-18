/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb.RN;

import entidades.proyectoWeb.EntidadSubsidio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface EntidadSubsidioRNLocal {
    List<EntidadSubsidio> findEntidadesSubsidio() throws Exception;
}
