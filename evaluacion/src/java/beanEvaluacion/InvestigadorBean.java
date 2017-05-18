/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

/**
 *
 * @author AFerSor
 */
@ManagedBean(name = "investigadorBean")
@RequestScoped
public class InvestigadorBean {

    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    private Investigador investigador;
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    @ManagedProperty(value = "#{listadoTelefonosBean}")
    private ListadoTelefonosBean listadoTelefonosBean;
    @ManagedProperty(value = "#{listadoEmailsBean}")
    private ListadoEmailsBean listadoEmailsBean;
    
    @ManagedProperty(value = "#{mensajeBean}")
    private MensajeBean mensajeBean;

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    public ListadoTelefonosBean getListadoTelefonosBean() {
        return listadoTelefonosBean;
    }

    public void setListadoTelefonosBean(ListadoTelefonosBean listadoTelefonosBean) {
        this.listadoTelefonosBean = listadoTelefonosBean;
    }

    public ListadoEmailsBean getListadoEmailsBean() {
        return listadoEmailsBean;
    }

    public void setListadoEmailsBean(ListadoEmailsBean listadoEmailsBean) {
        this.listadoEmailsBean = listadoEmailsBean;
    }
    

    public InvestigadorRNLocal getInvestigadorRNLocal() {
        return investigadorRNLocal;
    }

    public void setInvestigadorRNLocal(InvestigadorRNLocal investigadorRNLocal) {
        this.investigadorRNLocal = investigadorRNLocal;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    
    
    
    public InvestigadorBean() {
    }
    
    public void edit(Investigador inv){
        String mensaje = "";

        try {


            investigadorRNLocal.edit(inv);
            
            
            mensaje = "Los datos fueron modificados";
            RequestContext.getCurrentInstance().update("frmUser:pgDatosPersonales");
            this.getMensajeBean().setTipoIcono('I');
            this.getMensajeBean().setPagCerrar("dlgInvestigador.hide()");
        } catch (Exception ex) {
            this.getMensajeBean().setTipoIcono('E');
            mensaje = "Error: " + ex.getMessage();
        } finally {
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
        
    }//fin 
    public void modificarDatosPersonales(){
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        
        this.setInvestigador(this.getEvaluadorLoginBean().getEvaluador().getInvestigador());
        this.getInvestigador().getPersona().setTelefonos(this.getListadoTelefonosBean().getLstTelefonos());
        this.getInvestigador().getPersona().setCorreosElectronicos(this.getListadoEmailsBean().getLstCorreosElectronicos());
        try {
            investigadorRNLocal.edit(investigador);
            
            sMensaje = "Datos Modificados!!";
            severity = FacesMessage.SEVERITY_INFO;
        } catch (Exception ex) {
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al modificar: " + ex.getMessage();
        }finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }
}
