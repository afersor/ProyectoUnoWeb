/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.proyecto.evaluacion.CalificacionWeb;
import entidades.proyecto.evaluacion.RN.CalificacionWebRNLocal;
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
public class CalificacionWebLstBean implements Serializable {

    /**
     * Creates a new instance of CalificacionWebLstBean
     */
    private List<SelectItem> lstSICalificacionWeb;
    private List<CalificacionWeb> lstCalificacionWeb;
    
    @EJB
    private CalificacionWebRNLocal calificacionWebRNLocal;
    
    public CalificacionWebLstBean() {
    }
    

    public List<SelectItem> getLstSICalificacionWeb() {
        return lstSICalificacionWeb;
    }

    public void setLstSICalificacionWeb(List<SelectItem> lstSICalificacionWeb) {
        this.lstSICalificacionWeb = lstSICalificacionWeb;
    }
    
    public List<CalificacionWeb> getLstCalificacionWeb() {
        return lstCalificacionWeb;
    }

    public void setLstCalificacionWeb(List<CalificacionWeb> lstCalificacionWeb) {
        this.lstCalificacionWeb = lstCalificacionWeb;
    }
    
    public void findAll() throws Exception{
        this.setLstCalificacionWeb(calificacionWebRNLocal.findAll());
    }
    
    public void cargarSI(){
        this.setLstSICalificacionWeb(new ArrayList<SelectItem>());
        for(CalificacionWeb cw : this.getLstCalificacionWeb()){
            SelectItem si = new SelectItem(cw, " ");
            this.getLstSICalificacionWeb().add(si);
        }
    }//fin cargarSI
}
