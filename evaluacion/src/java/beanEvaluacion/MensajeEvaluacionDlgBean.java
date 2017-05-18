/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.evaluacion.MensajeEvaluacion;
import entidades.proyecto.evaluacion.RN.MensajeEvaluacionRNLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hugo
 */

@ManagedBean(name = "mensajeEvaluacionDlgBean")
@SessionScoped
public class MensajeEvaluacionDlgBean implements Serializable {

    /**
     * Creates a new instance of MensajeDlgBean
     */
    public MensajeEvaluacionDlgBean() {
    }
    private MensajeEvaluacion mensajeEvaluacion;
    @ManagedProperty("#{foroEvaluacionPagBean}")
    private foroEvaluacionPagBean foroEvaluacionPagBean;
    @EJB
    private MensajeEvaluacionRNLocal mensajeEvaluacionRNLocal; 
    
    @PostConstruct
    private void init(){
        mensajeEvaluacion=new MensajeEvaluacion();
    }
            
    public MensajeEvaluacion getMensajeEvaluacion() {
        return mensajeEvaluacion;
    }

    public foroEvaluacionPagBean getForoEvaluacionPagBean() {
        return foroEvaluacionPagBean;
    }

    public void setForoEvaluacionPagBean(foroEvaluacionPagBean foroEvaluacionPagBean) {
        this.foroEvaluacionPagBean = foroEvaluacionPagBean;
    }
    
    public void setMensajeEvaluacion(MensajeEvaluacion mensajeEvaluacion) {
        this.mensajeEvaluacion = mensajeEvaluacion;
    }
    
    public void create(){
        this.getMensajeEvaluacion().setBloqueEvaluado(this.getForoEvaluacionPagBean().getBloqueEvaluado());
        System.out.println("bloque evaluado mensajeDLG:"+this.getMensajeEvaluacion());
        try {
            mensajeEvaluacionRNLocal.create(this.getMensajeEvaluacion());
        } catch (Exception ex) {
            Logger.getLogger(MensajeEvaluacionDlgBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getForoEvaluacionPagBean().getBloqueEvaluado().getMensajes().add(mensajeEvaluacion);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("dlgMensajeBloque.hide();");
        
        
        
        
    }
}
