/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


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
public class BecasItemCalificacionLstBean implements Serializable {

    /**
     * Creates a new instance of CalificacionWebLstBean
     */
    private List<SelectItem> lstSIBecasItemCalificacion;
    
    public BecasItemCalificacionLstBean() {
    }

    public List<SelectItem> getLstSIBecasItemCalificacion() {
        
        System.out.println("Entro al get si: " + lstSIBecasItemCalificacion);
        
        return lstSIBecasItemCalificacion;
    }

    public void setLstSIBecasItemCalificacion(List<SelectItem> lstSIBecasItemCalificacion) {
        this.lstSIBecasItemCalificacion = lstSIBecasItemCalificacion;
    }

    

    
    public void cargarSI(){
        System.out.println("Entro a cargar item si");
        
        this.setLstSIBecasItemCalificacion(new ArrayList<SelectItem>());
        
        for(BecasItemCalificacion cw : BecasItemCalificacion.values()){
            SelectItem si = new SelectItem(cw, "");
            this.getLstSIBecasItemCalificacion().add(si);
        }
        
        System.out.println("dESPUES SI " + this.getLstSIBecasItemCalificacion());
    }//fin cargarSI
}
