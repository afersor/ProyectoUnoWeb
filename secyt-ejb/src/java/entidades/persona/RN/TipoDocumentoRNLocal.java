/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.RN;

import entidades.persona.TipoDocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface TipoDocumentoRNLocal {
    public List<TipoDocumento> findTipoDocumentos() throws Exception;

    public List<TipoDocumento> findAll() throws Exception;
}
