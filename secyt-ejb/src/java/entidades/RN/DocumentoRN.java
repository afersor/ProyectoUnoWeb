/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.RN;

import DAO.DocumentoFacadeLocal;
import entidades.Documento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class DocumentoRN implements DocumentoRNLocal {

    @EJB
    private DocumentoFacadeLocal documentoFacadeLocal;
    
    @Override
    public void create(Documento documento) throws Exception {
        documentoFacadeLocal.create(documento);
    }

    @Override
    public void edit(Documento documento) throws Exception {
        documentoFacadeLocal.edit(documento);
    }

    @Override
    public void remove(Documento documento) throws Exception {
      documentoFacadeLocal.remove(documento);
    }

    @Override
    public List<Documento> findAll() throws Exception {
        return documentoFacadeLocal.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
