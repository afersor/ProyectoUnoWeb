/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.UnidadAcademica;
import entidades.proyecto.LineaInvestigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface UnidadAcademicaFacadeLocal {

    void create(UnidadAcademica unidadAcademica);

    void edit(UnidadAcademica unidadAcademica);

    void remove(UnidadAcademica unidadAcademica);

    UnidadAcademica find(Object id);

    List<UnidadAcademica> findAll();

    List<UnidadAcademica> findRange(int[] range);

    int count();
    
    List<UnidadAcademica> findUnidadesAcademicasUnca() throws Exception;
    
    Boolean findUnidadAcademicaByNombre(String nombre) throws Exception;
    
}
