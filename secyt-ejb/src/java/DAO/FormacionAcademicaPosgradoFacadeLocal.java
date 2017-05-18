/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.investigador.formacionAcademica.FormacionAcademicaPosgrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface FormacionAcademicaPosgradoFacadeLocal {

    void create(FormacionAcademicaPosgrado formacionAcademicaPosgrado);

    void edit(FormacionAcademicaPosgrado formacionAcademicaPosgrado);

    void remove(FormacionAcademicaPosgrado formacionAcademicaPosgrado);

    FormacionAcademicaPosgrado find(Object id);

    List<FormacionAcademicaPosgrado> findAll();

    List<FormacionAcademicaPosgrado> findRange(int[] range);

    int count();
    
}
