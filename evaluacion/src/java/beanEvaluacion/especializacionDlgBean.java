/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.Especializacion;
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
public class especializacionDlgBean {

    @ManagedProperty(value = "#{especializacionBean}")
    private EspecializacionBean especializacionBean;
    
    @ManagedProperty(value = "#{especializacionLstBean}")
    private EspecializacionLstBean especializacionLstBean;
    
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public especializacionDlgBean() {
    }

    public EspecializacionLstBean getEspecializacionLstBean() {
        return especializacionLstBean;
    }

    public void setEspecializacionLstBean(EspecializacionLstBean especializacionLstBean) {
        this.especializacionLstBean = especializacionLstBean;
    }

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }
    
    public EspecializacionBean getEspecializacionBean() {
        return especializacionBean;
    }

    public void setEspecializacionBean(EspecializacionBean especializacionBean) {
        this.especializacionBean = especializacionBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
              
    public void create(){
         try {
             
              //SI ES DE LA UNCA NO PUEDE MODIFICAR NADA
             if (this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias() != null && 
                     !this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().isEmpty()) {
                 
                 System.out.println("Universidad: " + this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().get(
                         this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().size()-1).getUniversidad());
                 
                 if (this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().get(
                         this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().size()-1).getUniversidad().getId() == 1) {
                     throw new Exception("No puede realizar cambios");
                 }
             }else{
                 throw new Exception("No puede realizar cambios");
             }
             
            
             this.getEspecializacionBean().getEspecializacion().setInvestigador(
                     this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
             
             for(Especializacion e : this.getEspecializacionLstBean().getLstEspecializacion()){
                 
                 if(this.getEspecializacionBean().getEspecializacion().getAño() == e.getAño()){
                     if(this.getEspecializacionBean().getEspecializacion().getEspecialidadActividadAcademica() == 
                             e.getEspecialidadActividadAcademica()){
                         if(this.getEspecializacionBean().getEspecializacion().getEspecialidadInvestigacion() == 
                             e.getEspecialidadInvestigacion()){
                             throw new Exception("Ya esta cargada la especialización seleccionada");
                        }//fin if
                     }//fin if
                 }//fin if
             }//fin for
             
             if(this.getEspecializacionBean().getEspecializacion().getAño() <= 0){
                 throw new Exception("No ingreso el año");
             }//fin if
             
             if(this.getEspecializacionBean().getEspecializacion().getEspecialidadInvestigacion() == null){
                 throw new Exception("No selecciono la Especialidad investigación");
             }//fin if
             
             if(this.getEspecializacionBean().getEspecializacion().getEspecialidadActividadAcademica() == null){
                 throw new Exception("No selecciono la Especialidad Actividad Académica");
             }//fin if
             
            this.getEspecializacionBean().create();
            
            /*this.getInvestigadorLoginBean().getInvestigador().getEspecializaciones().add(
                    this.getEspecializacionBean().getEspecializacion());*/           
            
            this.getEspecializacionLstBean().getLstEspecializacion().add(
                    this.getEspecializacionBean().getEspecializacion());
            
            this.getMensajeBean().setMensaje("El dato fue guardado");
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().update("frmUser:dtEspecializacion");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
            
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin create
    
    public void delete(){
         try {
             
               //SI ES DE LA UNCA NO PUEDE MODIFICAR NADA
             
             if (this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias() != null && 
                     !this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().isEmpty()) {
                 
                 System.out.println("Universidad: " + this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().get(
                         this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().size()-1).getUniversidad());
                 
                 if (this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().get(
                         this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().size()-1).getUniversidad().getId() == 1) {
                     throw new Exception("No puede realizar cambios");
                 }
             }else{
                 throw new Exception("No puede realizar cambios");
             }

            
            System.out.println("paso");
            this.getEspecializacionBean().delete();
            
            this.getEspecializacionLstBean().getLstEspecializacion().remove(
                    this.getEspecializacionBean().getEspecializacion());
            
            this.getMensajeBean().setMensaje("El dato fue borrado");
            this.getMensajeBean().setPagCerrar("dlgDeleteEspecializacion.hide()");
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");           
            RequestContext.getCurrentInstance().update("frmUser:dtEspecializacion");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
            
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
        
    }//fin delete
}
