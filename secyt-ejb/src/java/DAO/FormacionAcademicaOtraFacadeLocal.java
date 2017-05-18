/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.investigador.formacionAcademica.FormacionAcademicaOtra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface FormacionAcademicaOtraFacadeLocal {

    void create(FormacionAcademicaOtra formacionAcademicaOtra);

    void edit(FormacionAcademicaOtra formacionAcademicaOtra);

    void remove(FormacionAcademicaOtra formacionAcademicaOtra);

    FormacionAcademicaOtra find(Object id);

    List<FormacionAcademicaOtra> findAll();

    List<FormacionAcademicaOtra> findRange(int[] range);

    int count();
    
}
