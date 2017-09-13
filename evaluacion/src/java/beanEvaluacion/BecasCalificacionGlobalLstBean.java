/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.becas.evaluacion.BecasCalificacionGlobal;
import entidades.becas.evaluacion.BecasItemCalificacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class BecasCalificacionGlobalLstBean implements Serializable {

    /**
     * Creates a new instance of CalificacionWebLstBean
     */
    private List<SelectItem> lstSIBecasCalificacionGlobal;
    
    public BecasCalificacionGlobalLstBean() {
    }

    public List<SelectItem> getLstSIBecasCalificacionGlobal() {
        return lstSIBecasCalificacionGlobal;
    }

    public void setLstSIBecasCalificacionGlobal(List<SelectItem> lstSIBecasCalificacionGlobal) {
        this.lstSIBecasCalificacionGlobal = lstSIBecasCalificacionGlobal;
    }

    

    

    
    public void cargarSI(){
        
        this.setLstSIBecasCalificacionGlobal(new ArrayList<SelectItem>());
        
        for(BecasCalificacionGlobal cw : BecasCalificacionGlobal.values()){
            SelectItem si = new SelectItem(cw, cw.getName());
            this.getLstSIBecasCalificacionGlobal().add(si);
        }
        
    }//fin cargarSI
}
