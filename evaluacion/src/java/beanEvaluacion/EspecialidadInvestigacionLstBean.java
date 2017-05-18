/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.EspecialidadInvestigacion;
import entidades.persona.investigador.RN.EspecialidadInvestigacionRNLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class EspecialidadInvestigacionLstBean {

   private List<EspecialidadInvestigacion> lstEspecialidadInvestigacion;
   
   @EJB
   private EspecialidadInvestigacionRNLocal especialidadInvestigacionRNLocal;
   
    public EspecialidadInvestigacionLstBean() {
    }

    public List<EspecialidadInvestigacion> getLstEspecialidadInvestigacion() {
        return lstEspecialidadInvestigacion;
    }

    public void setLstEspecialidadInvestigacion(List<EspecialidadInvestigacion> lstEspecialidadInvestigacion) {
        this.lstEspecialidadInvestigacion = lstEspecialidadInvestigacion;
    }
    
    public void findLikeDescripcion(String cadena) throws Exception{
        this.setLstEspecialidadInvestigacion(especialidadInvestigacionRNLocal.findLikeDescripcion(cadena));
    }
}
