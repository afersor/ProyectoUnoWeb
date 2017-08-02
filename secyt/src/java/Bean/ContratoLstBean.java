/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.RN.ContratoRNLocal;
import entidades.proyecto.resultado.Contrato;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
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
public class ContratoLstBean implements Serializable {
 @EJB
    private ContratoRNLocal contratoRNLocal;
    
    private List<Contrato> lstContrato;
    /**
     * Creates a new instance of ContratoLstBean
     */
    public ContratoLstBean() {
    }

    public ContratoRNLocal getContratoRNLocal() {
        return contratoRNLocal;
    }

    public void setContratoRNLocal(ContratoRNLocal contratoRNLocal) {
        this.contratoRNLocal = contratoRNLocal;
    }

    public List<Contrato> getLstContrato() {
        return lstContrato;
    }

    public void setLstContrato(List<Contrato> lstContrato) {
        this.lstContrato = lstContrato;
    }
    
    public void cargarContratoByTypoYProyecto(Long idProyecto, Long idInvestigador){
        
         try {
             
            System.out.println("Litado de contratos: " + idProyecto + " " + idInvestigador + " ");
            
            this.setLstContrato(contratoRNLocal.findByTypeYProyecto(idProyecto,idInvestigador));
            
            System.out.println("Litado de contratos: " + this.getLstContrato());
            
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + " ex " + ex.getCause());
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarPublicacionesByInvestigador
}
