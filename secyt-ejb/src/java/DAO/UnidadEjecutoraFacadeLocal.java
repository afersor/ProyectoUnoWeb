/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.UnidadAcademica;
import entidades.UnidadEjecutora;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface UnidadEjecutoraFacadeLocal {

    void create(UnidadEjecutora unidadEjecutora);

    void edit(UnidadEjecutora unidadEjecutora);

    void remove(UnidadEjecutora unidadEjecutora);

    UnidadEjecutora find(Object id);

    List<UnidadEjecutora> findAll();

    List<UnidadEjecutora> findRange(int[] range);

    int count();
    
    List<UnidadEjecutora> findUnidadesEjecutoras() throws Exception;
    
}
