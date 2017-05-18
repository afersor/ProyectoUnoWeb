/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.categorizacion.Categorizacion;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class CategorizacionDlgBean {

    @ManagedProperty(value = "#{categorizacionBean}")
    private CategorizacionBean categorizacionBean;
    
    @ManagedProperty(value = "#{categorizacionLstBean}")
    private CategorizacionLstBean categorizacionLstBean;
    
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    
    @ManagedProperty(value = "#{investigadorBean}")
    private InvestigadorBean investigadorBean;
    
    @ManagedProperty(value = "#{documentoLstBean}")
    private DocumentoLstBean documentoLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    public CategorizacionDlgBean() {
    }

    public DocumentoLstBean getDocumentoLstBean() {
        return documentoLstBean;
    }

    public void setDocumentoLstBean(DocumentoLstBean documentoLstBean) {
        this.documentoLstBean = documentoLstBean;
    }
    
    public InvestigadorBean getInvestigadorBean() {
        return investigadorBean;
    }

    public void setInvestigadorBean(InvestigadorBean investigadorBean) {
        this.investigadorBean = investigadorBean;
    }
    
    public CategorizacionLstBean getCategorizacionLstBean() {
        return categorizacionLstBean;
    }

    public void setCategorizacionLstBean(CategorizacionLstBean categorizacionLstBean) {
        this.categorizacionLstBean = categorizacionLstBean;
    }
    
    public CategorizacionBean getCategorizacionBean() {
        return categorizacionBean;
    }

    public void setCategorizacionBean(CategorizacionBean categorizacionBean) {
        this.categorizacionBean = categorizacionBean;
    }

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    public InvestigadorRNLocal getInvestigadorRNLocal() {
        return investigadorRNLocal;
    }

    public void setInvestigadorRNLocal(InvestigadorRNLocal investigadorRNLocal) {
        this.investigadorRNLocal = investigadorRNLocal;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    public void create(){
         try {
             
             /*for(Categorizacion c : this.getCategorizacionLstBean().getLstCategorizacion()){
                 
                 if(this.getCategorizacionBean().getCategorizacion(). == e.getAño()){
                     if(this.getEspecializacionBean().getEspecializacion().getEspecialidadActividadAcademica() == 
                             e.getEspecialidadActividadAcademica()){
                         if(this.getEspecializacionBean().getEspecializacion().getEspecialidadInvestigacion() == 
                             e.getEspecialidadInvestigacion()){
                             throw new Exception("Ya esta cargada la especialización seleccionada");
                        }//fin if
                     }//fin if
                 }//fin if
             }//fin for*/
             
            if(this.getCategorizacionLstBean().getLstCategorizacion() == null){
                this.getCategorizacionLstBean().setLstCategorizacion(new ArrayList<Categorizacion>());
            }//fin if
            
            this.getCategorizacionBean().getCategorizacion().setResoluciones(this.getDocumentoLstBean().getLstDocumento());
            
            
            //validar categorizaciones
            
            
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
            
            if(this.getCategorizacionBean().getCategorizacion().getUnidadAcademica() == null){
                throw new Exception("No selecciono la unidad academica");
            }//fin if
            
            if(this.getCategorizacionBean().getCategorizacion().getComision() == null){
                throw new Exception("No selecciono la desciplina");
            }//fin if
            
            if(this.getCategorizacionBean().getCategorizacion().getLlamado() == null){
                throw new Exception("No selecciono el llamado");
            }//fin if
            
            if(this.getCategorizacionBean().getCategorizacion().getCondicion() == null){
                throw new Exception("No selecciono la condición");
            }//fin if
            
            if(this.getCategorizacionBean().getCategorizacion().getCategoriaAsignada().getValorCategoria() == null){
                throw new Exception("No selecciono la categoría");
            }//fin if
            
            if(this.getCategorizacionBean().getCategorizacion().getCategoriaAsignada().getFechaCategoria() == null){
                throw new Exception("No selecciono la fecha de la categoría");
            }//fin if
            
            
            this.getCategorizacionLstBean().getLstCategorizacion().add(this.getCategorizacionBean().getCategorizacion());
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().setCategorizaciones(this.getCategorizacionLstBean().getLstCategorizacion());
            
            this.getInvestigadorBean().edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
            
            
            //actualizo los valores
            this.getCategorizacionLstBean().setLstCategorizacion(
                investigadorRNLocal.findById(
                this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getId()).getCategorizaciones());

            /*this.getInvestigadorLoginBean().getInvestigador().getCategorizaciones().add(
                    this.getCategorizacionBean().getCategorizacion());           
            
            this.getCategorizacionLstBean().getLstCategorizacion().add(
                    this.getCategorizacionBean().getCategorizacion());*/
            
            this.getMensajeBean().setMensaje("El dato fue guardado");
            
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().update("frmUser:dtInvCategorizacion");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
            
            System.out.println("Termino");
            
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

             
            if(this.getCategorizacionLstBean().getLstCategorizacion() == null){
                this.getCategorizacionLstBean().setLstCategorizacion(new ArrayList<Categorizacion>());
            }//fin if
            
            this.getCategorizacionLstBean().getLstCategorizacion().remove(this.getCategorizacionBean().getCategorizacion());
            this.getEvaluadorLoginBean().getEvaluador().getInvestigador().setCategorizaciones(this.getCategorizacionLstBean().getLstCategorizacion());
            this.getInvestigadorBean().edit(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
            
            /*this.getInvestigadorLoginBean().getInvestigador().getCategorizaciones().add(
                    this.getCategorizacionBean().getCategorizacion());           
            
            this.getCategorizacionLstBean().getLstCategorizacion().add(
                    this.getCategorizacionBean().getCategorizacion());*/
            
            
            this.getMensajeBean().setMensaje("El dato fue eliminado");
            this.getMensajeBean().setPagCerrar("dlgDeleteCategorizacion.hide()");
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().update("frmUser:dtInvCategorizacion");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
            
            
            
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin create
    
    
}
