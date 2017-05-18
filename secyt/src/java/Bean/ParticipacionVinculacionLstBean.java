/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.vinculacion.ParticipacionVinculacion;
import entidades.proyecto.vinculacion.RN.ParticipacionVinculacionRNLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ParticipacionVinculacionLstBean {

    private List<ParticipacionVinculacion> lstParticipacionVinculacion;
    
    @EJB
    private ParticipacionVinculacionRNLocal participacionVinculacionRNLocal;
    
    public ParticipacionVinculacionLstBean() {
    }

    public List<ParticipacionVinculacion> getLstParticipacionVinculacion() {
        return lstParticipacionVinculacion;
    }

    public void setLstParticipacionVinculacion(List<ParticipacionVinculacion> lstParticipacionVinculacion) {
        this.lstParticipacionVinculacion = lstParticipacionVinculacion;
    }
    
    
    public void cargarParticipacionVinculacionByInvestigador(Long idInvestigador){
        try {
            this.setLstParticipacionVinculacion(participacionVinculacionRNLocal.findByInvestigador(idInvestigador));
        } catch (Exception ex) {
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarParticipacionVinculacionByInvestigador
}
