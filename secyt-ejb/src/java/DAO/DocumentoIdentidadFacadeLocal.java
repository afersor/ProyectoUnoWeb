/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.DocumentoIdentidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface DocumentoIdentidadFacadeLocal {

    void create(DocumentoIdentidad documentoIdentidad);

    void edit(DocumentoIdentidad documentoIdentidad);

    void remove(DocumentoIdentidad documentoIdentidad);

    DocumentoIdentidad find(Object id);

    List<DocumentoIdentidad> findAll();

    List<DocumentoIdentidad> findRange(int[] range);

    int count();
    
}
