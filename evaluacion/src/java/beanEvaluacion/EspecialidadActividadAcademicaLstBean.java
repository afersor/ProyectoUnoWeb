/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.EspecialidadActividadAcademica;
import entidades.persona.investigador.RN.EspecialidadActividadAcademicaRNLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class EspecialidadActividadAcademicaLstBean {

    @ManagedProperty(value = "#{especialidadActividadAcademica}")
    private List<EspecialidadActividadAcademica> lstEspecialidadActividadAcademica;
    
    @EJB
    private EspecialidadActividadAcademicaRNLocal especialidadActividadAcademicaRNLocal;
    
    public EspecialidadActividadAcademicaLstBean() {
    }

    public List<EspecialidadActividadAcademica> getLstEspecialidadActividadAcademica() {
        return lstEspecialidadActividadAcademica;
    }

    public void setLstEspecialidadActividadAcademica(List<EspecialidadActividadAcademica> lstEspecialidadActividadAcademica) {
        this.lstEspecialidadActividadAcademica = lstEspecialidadActividadAcademica;
    }

    public void findLikeDescripcion(String cadena) throws Exception{
        this.setLstEspecialidadActividadAcademica(especialidadActividadAcademicaRNLocal.findLikeDescripcion(cadena));
    }
    
}
