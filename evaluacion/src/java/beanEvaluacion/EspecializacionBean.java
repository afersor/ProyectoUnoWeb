/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.EspecialidadActividadAcademica;
import entidades.persona.investigador.EspecialidadInvestigacion;
import entidades.persona.investigador.Especializacion;
import entidades.persona.investigador.RN.EspecializacionRNLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class EspecializacionBean {

    private Especializacion especializacion;
    
    @EJB
    private EspecializacionRNLocal especializacionRNLocal;
    
    public EspecializacionBean() {
        especializacion  = new Especializacion();
        especializacion.setEspecialidadInvestigacion(new EspecialidadInvestigacion());
        especializacion.setEspecialidadActividadAcademica(new EspecialidadActividadAcademica());
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especializacion especializacion) {
        this.especializacion = especializacion;
    }
    
    public void create() throws Exception{
        especializacionRNLocal.create(especializacion);
    }//fin create
    
    public void delete() throws Exception{
        especializacionRNLocal.delete(especializacion);
    }//fin delete
}
