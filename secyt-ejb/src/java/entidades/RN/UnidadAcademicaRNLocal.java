/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import entidades.UnidadAcademica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface UnidadAcademicaRNLocal {
    List<UnidadAcademica> findUnidadesAcademicasUNCa() throws Exception;
    List<UnidadAcademica> findAll() throws Exception;
    void create(UnidadAcademica unidadAcademica) throws Exception;
    
}
