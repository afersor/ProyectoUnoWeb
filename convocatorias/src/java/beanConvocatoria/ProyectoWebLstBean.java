/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyectoWeb.ProyectoWeb;
import entidades.proyectoWeb.RN.ProyectoWebRNLocal;
import java.io.Serializable;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;



/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class ProyectoWebLstBean implements Serializable{

    private List<ProyectoWeb> lstProyectoWeb;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    
    @EJB
    private ProyectoWebRNLocal proyectoWebRNLocal;
    
    public ProyectoWebLstBean() {
    }

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }
    
    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    public List<ProyectoWeb> getLstProyectoWeb() {
        return lstProyectoWeb;
    }

    public void setLstProyectoWeb(List<ProyectoWeb> lstProyectoWeb) {
        this.lstProyectoWeb = lstProyectoWeb;
    }
    
    public void cargarProyectoWebByFechas(Date fecha){
        String sMensaje = "";
        try {

            this.setLstProyectoWeb(
                this.proyectoWebRNLocal.findProyectoWebByDirector( 
                    this.getInvestigadorLoginBean().getInvestigador().getId()));          
            
        } catch (Exception ex) {

            sMensaje = "Error: " + ex.getMessage();
            this.getMensajeBean().setMensaje(sMensaje);
            RequestContext.getCurrentInstance().update("dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");

        }//fin try-catch
       
    }//fin findProyectoWebByFechas
}//FIN CLASES
