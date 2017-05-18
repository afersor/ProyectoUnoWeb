/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.EspecialidadInvestigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface EspecialidadInvestigacionFacadeLocal {

    void create(EspecialidadInvestigacion especialidadInvestigacion);

    void edit(EspecialidadInvestigacion especialidadInvestigacion);

    void remove(EspecialidadInvestigacion especialidadInvestigacion);

    EspecialidadInvestigacion find(Object id);

    List<EspecialidadInvestigacion> findAll();

    List<EspecialidadInvestigacion> findRange(int[] range);

    int count();
    
    List<EspecialidadInvestigacion> findLikeDescripcion(String cadena) throws Exception;
    
}
