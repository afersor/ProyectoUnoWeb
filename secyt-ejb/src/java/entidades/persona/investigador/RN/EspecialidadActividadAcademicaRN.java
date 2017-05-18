/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.EspecialidadActividadAcademicaFacadeLocal;
import entidades.persona.investigador.EspecialidadActividadAcademica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class EspecialidadActividadAcademicaRN implements EspecialidadActividadAcademicaRNLocal {

    @EJB
    private EspecialidadActividadAcademicaFacadeLocal especialidadActividadAcademicaFacadeLocal;
    
    @Override
    public List<EspecialidadActividadAcademica> findLikeDescripcion(String cadena) throws Exception {
        return especialidadActividadAcademicaFacadeLocal.findLikeDescripcion(cadena);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
