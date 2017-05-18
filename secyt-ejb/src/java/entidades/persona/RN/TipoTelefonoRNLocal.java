/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.RN;

import entidades.persona.TipoTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface TipoTelefonoRNLocal {
    List<TipoTelefono> findTipoTelefonos() throws Exception;
}
