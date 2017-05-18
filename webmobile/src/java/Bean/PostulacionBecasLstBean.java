/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.becas.PostulacionBeca;
import entidades.becas.RN.PostulacionBecaRNLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class PostulacionBecasLstBean {
    
    private List<PostulacionBeca> lstPostulacionBeca;
    private List<PostulacionBeca> lstPostulacionBecasDirector;
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    @EJB
    private PostulacionBecaRNLocal postulacionBecasRNLocal;
    
    public PostulacionBecasLstBean() {
    }
    
    public List<PostulacionBeca> getLstPostulacionBecasDirector() {
        return lstPostulacionBecasDirector;
    }
    
    public void setLstPostulacionBecasDirector(List<PostulacionBeca> lstPostulacionBecasDirector) {
        this.lstPostulacionBecasDirector = lstPostulacionBecasDirector;
    }
    
    public List<PostulacionBeca> getLstPostulacionBeca() {
        return lstPostulacionBeca;
    }
    
    public void setLstPostulacionBeca(List<PostulacionBeca> lstPostulacionBeca) {
        this.lstPostulacionBeca = lstPostulacionBeca;
    }
    
    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }
    
    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }
    
    public void cargarPostulacionBecas() {
        try {
            this.setLstPostulacionBeca(this.postulacionBecasRNLocal.finByPostulanteAcreditado(
                    this.getInvestigadorLoginBean().getInvestigador().getId()));
            setLstPostulacionBecasDirector(postulacionBecasRNLocal.finByDirectorProyecto(getInvestigadorLoginBean().getInvestigador().getId()));
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarPostulacionBecas
}
