/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.RN.InvestigadorRNLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class NavegarBean {
    
    @ManagedProperty("#{evaluacionWebLstBean}")
    private EvaluacionWebLstBean evaluacionWebLstBean;
    
    @ManagedProperty("#{becasEvaluacionWebLstBean}")
    private BecasEvaluacionWebLstBean becasEvaluacionWebLstBean;
    
    @ManagedProperty("#{bloqueEvaluadoLstBean}")
    private BloqueEvaluadoLstBean bloqueEvaluadoLstBean;
  
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    
    @ManagedProperty(value = "#{especializacionLstBean}")
    private EspecializacionLstBean especializacionLstBean;
    
    @ManagedProperty(value = "#{categorizacionLstBean}")
    private CategorizacionLstBean categorizacionLstBean;
    
    @ManagedProperty("#{bloqueLstBean}")
    private BloqueLstBean bloqueLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{foroEvaluacionPagBean}")
    private foroEvaluacionPagBean foroEvaluacionPagBean;
    
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    public NavegarBean() {
    }

    public BecasEvaluacionWebLstBean getBecasEvaluacionWebLstBean() {
        return becasEvaluacionWebLstBean;
    }

    public void setBecasEvaluacionWebLstBean(BecasEvaluacionWebLstBean becasEvaluacionWebLstBean) {
        this.becasEvaluacionWebLstBean = becasEvaluacionWebLstBean;
    }
    
    public InvestigadorRNLocal getInvestigadorRNLocal() {
        return investigadorRNLocal;
    }

    public void setInvestigadorRNLocal(InvestigadorRNLocal investigadorRNLocal) {
        this.investigadorRNLocal = investigadorRNLocal;
    }
    
    public foroEvaluacionPagBean getForoEvaluacionPagBean() {
        return foroEvaluacionPagBean;
    }

    public void setForoEvaluacionPagBean(foroEvaluacionPagBean foroEvaluacionPagBean) {
        this.foroEvaluacionPagBean = foroEvaluacionPagBean;
    }
    
    public EvaluacionWebLstBean getEvaluacionWebLstBean() {
        return evaluacionWebLstBean;
    }

    public void setEvaluacionWebLstBean(EvaluacionWebLstBean evaluacionWebLstBean) {
        this.evaluacionWebLstBean = evaluacionWebLstBean;
    }
    
    public BloqueEvaluadoLstBean getBloqueEvaluadoLstBean() {
        return bloqueEvaluadoLstBean;
    }

    public void setBloqueEvaluadoLstBean(BloqueEvaluadoLstBean bloqueEvaluadoLstBean) {
        this.bloqueEvaluadoLstBean = bloqueEvaluadoLstBean;
    }
    
    public BloqueLstBean getBloqueLstBean() {
        return bloqueLstBean;
    }

    public void setBloqueLstBean(BloqueLstBean bloqueLstBean) {
        this.bloqueLstBean = bloqueLstBean;
    }
    

    public CategorizacionLstBean getCategorizacionLstBean() {
        return categorizacionLstBean;
    }

    public void setCategorizacionLstBean(CategorizacionLstBean categorizacionLstBean) {
        this.categorizacionLstBean = categorizacionLstBean;
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

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    
    
    public String entrarPagPri(){
        return "Usuario/evaluacion.xhtml?faces-redirect=true"; //?faces-redirect=true
    }
    
    public String pInvestigadorDatosPersonales(){
        return "investigadorDatosPersonales.xhtml?faces-redirect=true";
    }//fin pInvestigadorDatosPersonales
    public String pInvestigadorFormacionAcademica(){
        

        return "investigadorFormacionAcademica.xhtml?faces-redirect=true";
    }
    
    public String pInvestigadorEspecializacion(){
        try {
            this.getEspecializacionLstBean().findByInvestigador(this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getId());
        } catch (Exception ex) {
            
        }
        return "investigadorEspecializacion.xhtml?faces-redirect=true";
    }//fin pInvestigadorEspecializacion
    
    public String pInvestigadorCategorizacion(){
        try {
            this.getCategorizacionLstBean().setLstCategorizacion(
                investigadorRNLocal.findById(
                this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getId()).getCategorizaciones());
        } catch (Exception ex) {
            
        }
        return "investigadorCategorizacion.xhtml?faces-redirect=true";
    }//fin pInvestigadorCategorizacion
    
     public String pEvaluacionBecas(){
        try {
            this.getBecasEvaluacionWebLstBean().findAllByEvaluador(
                    this.getEvaluadorLoginBean().getEvaluador().getId());
            
        } catch (Exception ex) {

        }
        return "becasEvaluacionWeb.xhtml?faces-redirect=true";
    }
    
    
    public String pEvaluacionWeb(){
        try {
            this.getEvaluacionWebLstBean().findAllByEvaluador(
                    this.getEvaluadorLoginBean().getEvaluador().getId());
            
        } catch (Exception ex) {

        }
        return "proyecto.xhtml?faces-redirect=true";
    }
    
    public String pArchivo(){
        try {
            this.getEvaluacionWebLstBean().findAllByEvaluador(
                    this.getEvaluadorLoginBean().getEvaluador().getId());
            
        } catch (Exception ex) {

        }
        return "archivos.xhtml?faces-redirect=true";
    }
    
    public String pForoEvaluacion(){
        this.getForoEvaluacionPagBean().renderizarAcordionPanel(false);
                try {
            this.getEvaluacionWebLstBean().findAllByEvaluador(
                    this.getEvaluadorLoginBean().getEvaluador().getId());
            
        } catch (Exception ex) {

        }
        return "foroEvaluacion.xhtml?faces-redirect=true";
    }
    

      

}//FIN CLASE
