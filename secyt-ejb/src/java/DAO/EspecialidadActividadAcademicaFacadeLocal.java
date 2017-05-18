/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.EspecialidadActividadAcademica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface EspecialidadActividadAcademicaFacadeLocal {

    void create(EspecialidadActividadAcademica especialidadActividadAcademica);

    void edit(EspecialidadActividadAcademica especialidadActividadAcademica);

    void remove(EspecialidadActividadAcademica especialidadActividadAcademica);

    EspecialidadActividadAcademica find(Object id);

    List<EspecialidadActividadAcademica> findAll();

    List<EspecialidadActividadAcademica> findRange(int[] range);

    int count();
    
    List<EspecialidadActividadAcademica> findLikeDescripcion(String cadena) throws Exception;
    
}
