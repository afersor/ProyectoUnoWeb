/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

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
public class EspecialidadInvestigacionFindDlgBean {

    private String descripcion;
    
    private EspecialidadInvestigacion especialidadInvestigacionSelect;
    
    private int tipo;

    @ManagedProperty("#{especializacionBean}")
    private EspecializacionBean especializacionBean;
    
    @ManagedProperty("#{especialidadInvestigacionLstBean}")
    private EspecialidadInvestigacionLstBean especialidadInvestigacionLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public EspecialidadInvestigacionFindDlgBean() {
    }

    public EspecialidadInvestigacionLstBean getEspecialidadInvestigacionLstBean() {
        return especialidadInvestigacionLstBean;
    }

    public void setEspecialidadInvestigacionLstBean(EspecialidadInvestigacionLstBean especialidadInvestigacionLstBean) {
        this.especialidadInvestigacionLstBean = especialidadInvestigacionLstBean;
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

    public EspecialidadInvestigacion getEspecialidadInvestigacionSelect() {
        return especialidadInvestigacionSelect;
    }

    public void setEspecialidadInvestigacionSelect(EspecialidadInvestigacion especialidadInvestigacionSelect) {
        this.especialidadInvestigacionSelect = especialidadInvestigacionSelect;
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
                        setEspecialidadInvestigacion(
                        this.getEspecialidadInvestigacionSelect());

                
                //actualiza.
                RequestContext context = RequestContext.getCurrentInstance();  
                context.update("frmUser:ihIdEspecialidadInvC"); 
                context.update("frmUser:ihDescripcionEspecialidadInvC"); 
                context.update("frmUser:otEspInvC"); 
                break;

        }//fin switch
    }//fin if
    
    public void findLikeDescripcion(){
         try {

             if (!this.getDescripcion().isEmpty()) {
                 this.getEspecialidadInvestigacionLstBean().findLikeDescripcion(descripcion);

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
