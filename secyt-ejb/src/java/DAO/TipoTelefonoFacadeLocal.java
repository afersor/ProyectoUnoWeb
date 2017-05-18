/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.TipoTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface TipoTelefonoFacadeLocal {

    void create(TipoTelefono tipoTelefono);

    void edit(TipoTelefono tipoTelefono);

    void remove(TipoTelefono tipoTelefono);

    TipoTelefono find(Object id);

    List<TipoTelefono> findAll();

    List<TipoTelefono> findRange(int[] range);

    int count();
    
    List<TipoTelefono> findTipoTelefonos() throws Exception;
    
}
