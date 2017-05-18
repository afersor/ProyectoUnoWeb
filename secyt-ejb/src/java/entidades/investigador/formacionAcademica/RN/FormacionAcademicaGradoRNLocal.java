/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.investigador.formacionAcademica.RN;

import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface FormacionAcademicaGradoRNLocal {

    public List<FormacionAcademicaGrado> buscarFAG() throws Exception;
    
}
