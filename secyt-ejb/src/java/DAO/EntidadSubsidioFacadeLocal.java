/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.EntidadSubsidio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface EntidadSubsidioFacadeLocal {

    void create(EntidadSubsidio entidadSubsidio);

    void edit(EntidadSubsidio entidadSubsidio);

    void remove(EntidadSubsidio entidadSubsidio);

    EntidadSubsidio find(Object id);

    List<EntidadSubsidio> findAll();

    List<EntidadSubsidio> findRange(int[] range);

    int count();
    
    List<EntidadSubsidio> findEntidadesSubsidio() throws Exception;
    
}
