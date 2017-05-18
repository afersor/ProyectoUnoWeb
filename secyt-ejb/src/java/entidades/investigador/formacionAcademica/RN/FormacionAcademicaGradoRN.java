/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.investigador.formacionAcademica.RN;

import DAO.FormacionAcademicaGradoFacadeLocal;
import entidades.investigador.formacionAcademica.FormacionAcademicaGrado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class FormacionAcademicaGradoRN implements FormacionAcademicaGradoRNLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private FormacionAcademicaGradoFacadeLocal formacionAcademicaGradoFacadeLocal;

    @Override
    public List<FormacionAcademicaGrado> buscarFAG() throws Exception {
        return formacionAcademicaGradoFacadeLocal.findAll();
    }

}
