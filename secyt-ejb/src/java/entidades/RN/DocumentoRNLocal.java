/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades.RN;

import entidades.Documento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface DocumentoRNLocal {
    void create(Documento documento) throws Exception;

    void edit(Documento documento) throws Exception;

    void remove(Documento documento) throws Exception;
    
    List<Documento> findAll() throws Exception;
}
