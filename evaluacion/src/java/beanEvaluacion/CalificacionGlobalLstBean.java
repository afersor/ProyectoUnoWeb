/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.evaluacion.CalificacionGlobal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */

@ManagedBean
@SessionScoped
public class CalificacionGlobalLstBean implements Serializable {

    private List<SelectItem> lstSICalificacionGlobal;
    
    public CalificacionGlobalLstBean() {
    }

    public List<SelectItem> getLstSICalificacionGlobal() {
        return lstSICalificacionGlobal;
    }

    public void setLstSICalificacionGlobal(List<SelectItem> lstSICalificacionGlobal) {
        this.lstSICalificacionGlobal = lstSICalificacionGlobal;
    }
    
    public void cargarSI(){
        this.setLstSICalificacionGlobal(new ArrayList<SelectItem>());
        for(CalificacionGlobal cg: CalificacionGlobal.values()){
            SelectItem si = new SelectItem(cg, cg.getName());
            this.getLstSICalificacionGlobal().add(si);
        }//fin for
        
    }//fin cargarSI
}
