/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.UnidadInvestigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface UnidadInvestigacionFacadeLocal {

    void create(UnidadInvestigacion unidadInvestigacion);

    void edit(UnidadInvestigacion unidadInvestigacion);

    void remove(UnidadInvestigacion unidadInvestigacion);

    UnidadInvestigacion find(Object id);

    List<UnidadInvestigacion> findAll();

    List<UnidadInvestigacion> findRange(int[] range);

    int count();
    
    List<UnidadInvestigacion> findLikeDescripcion(String cadena) throws Exception;
    
}
