/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.Especializacion;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class InvestigadorEspecializacionPagBean {

   
    @ManagedProperty(value = "#{especializacionBean}")
    private EspecializacionBean EspecializacionBean;
    
    @ManagedProperty(value = "#{especializacionLstBean}")
    private EspecializacionLstBean EspecializacionLstBean;
    
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public InvestigadorEspecializacionPagBean() {
    }

    public EspecializacionBean getEspecializacionBean() {
        return EspecializacionBean;
    }

    public void setEspecializacionBean(EspecializacionBean EspecializacionBean) {
        this.EspecializacionBean = EspecializacionBean;
    }

    public EspecializacionLstBean getEspecializacionLstBean() {
        return EspecializacionLstBean;
    }

    public void setEspecializacionLstBean(EspecializacionLstBean EspecializacionLstBean) {
        this.EspecializacionLstBean = EspecializacionLstBean;
    }

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
  
    public void findByIdInvestigador(){
        try{
            
            this.getEspecializacionLstBean().findByInvestigador(
                    this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getId());
            
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin findByIdInvestigador
}
