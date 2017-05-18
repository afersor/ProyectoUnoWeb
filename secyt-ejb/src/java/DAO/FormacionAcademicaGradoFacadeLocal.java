/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface FormacionAcademicaGradoFacadeLocal {

    void create(FormacionAcademicaGrado formacionAcademicaGrado);

    void edit(FormacionAcademicaGrado formacionAcademicaGrado);

    void remove(FormacionAcademicaGrado formacionAcademicaGrado);

    FormacionAcademicaGrado find(Object id);

    List<FormacionAcademicaGrado> findAll();

    List<FormacionAcademicaGrado> findRange(int[] range);

    int count();
    
}
