/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.RN.PropiedadRNLocal;
import entidades.proyecto.resultado.Propiedad;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class PropiedadLstBean {

    @EJB
    private PropiedadRNLocal propiedadRNLocal;
    
    private List<Propiedad> lstPropiedad;
    
    public PropiedadLstBean() {
    }

    public List<Propiedad> getLstPropiedad() {
        return lstPropiedad;
    }

    public void setLstPropiedad(List<Propiedad> lstPropiedad) {
        this.lstPropiedad = lstPropiedad;
    }
    
    public void cargarPropiedadByTypoYProyecto(Long idProyecto, Long idInvestigador, Class tipo){
        
         try {
             
            
            this.setLstPropiedad(propiedadRNLocal.findByTypeYProyecto(idProyecto,idInvestigador,tipo));
            
            
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + " ex " + ex.getCause());
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarPublicacionesByInvestigador
}
