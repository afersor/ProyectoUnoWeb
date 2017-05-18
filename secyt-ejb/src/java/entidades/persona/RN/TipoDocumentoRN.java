/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.RN;

import DAO.TipoDocumentoFacadeLocal;
import entidades.persona.TipoDocumento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class TipoDocumentoRN implements TipoDocumentoRNLocal {

    @EJB
    private TipoDocumentoFacadeLocal tipoDocumentoFacadeLocal;
    
    @Override
    public List<TipoDocumento> findTipoDocumentos() throws Exception {
        return tipoDocumentoFacadeLocal.findTipoDocumentos();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<TipoDocumento> findAll() throws Exception {
        return tipoDocumentoFacadeLocal.findAll();
    }

}
