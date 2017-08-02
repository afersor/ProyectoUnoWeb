/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.RN.FormacionRNLocal;
import entidades.proyecto.resultado.FormacionRRHH;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author alumno
 */
@ManagedBean
@SessionScoped
public class FormacionRRHHLstBean implements Serializable {
 @EJB
    private FormacionRNLocal formacionRRHHRNLocal;
    
    private List<FormacionRRHH> lstFormacionRRHH;
    /**
     * Creates a new instance of FormacionRRHHLstBean
     */
    public FormacionRRHHLstBean() {
    }

    public FormacionRNLocal getFormacionRRHHRNLocal() {
        return formacionRRHHRNLocal;
    }

    public void setFormacionRRHHRNLocal(FormacionRNLocal formacionRRHHRNLocal) {
        this.formacionRRHHRNLocal = formacionRRHHRNLocal;
    }

    public List<FormacionRRHH> getLstFormacionRRHH() {
        return lstFormacionRRHH;
    }

    public void setLstFormacionRRHH(List<FormacionRRHH> lstFormacionRRHH) {
        this.lstFormacionRRHH = lstFormacionRRHH;
    }
    
    public void cargarFormacionByTypoYProyecto(Long idProyecto, Long idInvestigador){
        
         try {
             
            System.out.println("Litado de formacion: " + idProyecto + " " + idInvestigador + " ");
            
            this.setLstFormacionRRHH(formacionRRHHRNLocal.findByTypeYProyecto(idProyecto,idInvestigador));
            
            System.out.println("Litado de formacion: " + this.getLstFormacionRRHH());
            
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + " ex " + ex.getCause());
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarPublicacionesByInvestigador
}
