/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.EspecialidadActividadAcademica;
import entidades.persona.investigador.EspecialidadInvestigacion;
import entidades.proyecto.Especialidad;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@javax.faces.bean.RequestScoped
public class EspecialidadActividadAcademicaFindDlgBean {

    private String descripcion;
    
    private EspecialidadActividadAcademica especialidadActividadAcademicaSelect;
    
    private int tipo;

    @ManagedProperty("#{especializacionBean}")
    private EspecializacionBean especializacionBean;
    
    @ManagedProperty("#{especialidadActividadAcademicaLstBean}")
    private EspecialidadActividadAcademicaLstBean especialidadActividadAcademicaLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public EspecialidadActividadAcademicaFindDlgBean() {
    }

    public EspecialidadActividadAcademicaLstBean getEspecialidadActividadAcademicaLstBean() {
        return especialidadActividadAcademicaLstBean;
    }

    public void setEspecialidadActividadAcademicaLstBean(EspecialidadActividadAcademicaLstBean especialidadActividadAcademicaLstBean) {
        this.especialidadActividadAcademicaLstBean = especialidadActividadAcademicaLstBean;
    }
    
    public EspecializacionBean getEspecializacionBean() {
        return especializacionBean;
    }

    public void setEspecializacionBean(EspecializacionBean especializacionBean) {
        this.especializacionBean = especializacionBean;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EspecialidadActividadAcademica getEspecialidadActividadAcademicaSelect() {
        return especialidadActividadAcademicaSelect;
    }

    public void setEspecialidadActividadAcademicaSelect(EspecialidadActividadAcademica especialidadActividadAcademicaSelect) {
        this.especialidadActividadAcademicaSelect = especialidadActividadAcademicaSelect;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    
    //depende la pantalla que llame al dialog va actualizar algun componente
    public void definirComponentesActualizar(){
        switch(this.getTipo()){
            
            
            
            case 0: //pagina especializacionCreateDlg
                this.getEspecializacionBean().getEspecializacion().
                        setEspecialidadActividadAcademica(
                        this.getEspecialidadActividadAcademicaSelect());

                
                //actualiza.
                RequestContext context = RequestContext.getCurrentInstance();  
                context.update("frmUser:ihIdEspActAcaC"); 
                context.update("frmUser:ihDescripcionEspActAcaC");
                context.update("frmUser:otEspActAcaC"); 
                break;

        }//fin switch
    }//fin if
    
    public void findLikeDescripcion(){
         try {

             if (!this.getDescripcion().isEmpty()) {
                 this.getEspecialidadActividadAcademicaLstBean().findLikeDescripcion(descripcion);

             } else {
                 this.getMensajeBean().setMensaje("Error. No ingreso un valor a buscar.");
                 RequestContext.getCurrentInstance().update("frmUser:dMensaje");
                 RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
             }
         } catch (Exception ex) {
             this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
             RequestContext.getCurrentInstance().update("frmUser:dMensaje");
             RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
         }

    }//fin findLikeNombreApellido
}
