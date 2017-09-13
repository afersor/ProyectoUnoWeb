/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.becas.Becas;
import entidades.becas.PostulacionBeca;
import entidades.becas.evaluacion.BecasEvaluacionWeb;
import entidades.becas.evaluacion.RN.BecasEvaluacionWebRNLocal;
import entidades.persona.investigador.Investigador;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import recursos.FileDownload;

/**
 *
 * @author Fz
 */
@ManagedBean(name = "becasEvaluacionWebBean")
@SessionScoped
public class BecasEvaluacionWebBean implements Serializable {

    @ManagedProperty(value = "#{becasEvaluacionWebLstBean}")
    private BecasEvaluacionWebLstBean becasEvaluacionWebLstBean;
    
    @EJB
    private BecasEvaluacionWebRNLocal becasEvaluacionWebRNLocal;

    public BecasEvaluacionWebBean() {
    }

    public BecasEvaluacionWebLstBean getBecasEvaluacionWebLstBean() {
        return becasEvaluacionWebLstBean;
    }

    public void setBecasEvaluacionWebLstBean(BecasEvaluacionWebLstBean becasEvaluacionWebLstBean) {
        this.becasEvaluacionWebLstBean = becasEvaluacionWebLstBean;
    }
    
    public void edit() throws Exception{
        becasEvaluacionWebRNLocal.edit(this.getBecasEvaluacionWebLstBean().getBecasEvaluacionWebSelect());
    }//fin create

    
   
    
    
    public void descargarArchivo(byte[] archivo, String nombre){
        try{
                        
            FileDownload.descargarArchivo(archivo, nombre);

        } catch(Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin descargarArchivo
}//FIN CLASE
