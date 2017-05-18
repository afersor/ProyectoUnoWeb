/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    @ManagedProperty(value = "#{listadoTelefonosBean}")
    private ListadoTelefonosBean listadoTelefonosBean;
    @ManagedProperty(value = "#{listadoEmailsBean}")
    private ListadoEmailsBean listadoEmailsBean;

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
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
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {


            investigadorRNLocal.edit(inv);
            
            this.getInvestigadorLoginBean().setInvestigador(investigadorRNLocal.findById(inv.getId()));
                     
            sMensaje = "El archivo fue subido";
            severity = FacesMessage.SEVERITY_INFO;
 

        } catch (Exception ex) {

            
            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al modificar: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        
    }//fin 
    public void modificarDatosPersonales(){
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        
        this.setInvestigador(this.getInvestigadorLoginBean().getInvestigador());
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
