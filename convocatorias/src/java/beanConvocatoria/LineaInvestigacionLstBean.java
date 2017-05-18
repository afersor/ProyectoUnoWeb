/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.LineaInvestigacion;
import entidades.proyecto.RN.LineaInvestigacionRNLocal;
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
public class LineaInvestigacionLstBean implements Serializable {

    private List<LineaInvestigacion> lstLineaInvestigacion;
    
    private List<SelectItem> lstSILineaInvestigacion; 
    
    @EJB
    private LineaInvestigacionRNLocal lineaInvestigacionRNLocal;
    
    public LineaInvestigacionLstBean() {
    }

    public LineaInvestigacionRNLocal getLineaInvestigacionRNLocal() {
        return lineaInvestigacionRNLocal;
    }

    public void setLineaInvestigacionRNLocal(LineaInvestigacionRNLocal lineaInvestigacionRNLocal) {
        this.lineaInvestigacionRNLocal = lineaInvestigacionRNLocal;
    }
    
    public List<LineaInvestigacion> getLstLineaInvestigacion() {
        return lstLineaInvestigacion;
    }

    public void setLstLineaInvestigacion(List<LineaInvestigacion> lstLineaInvestigacion) {
        this.lstLineaInvestigacion = lstLineaInvestigacion;
    }

    public List<SelectItem> getLstSILineaInvestigacion() {
        return lstSILineaInvestigacion;
    }

    public void setLstSILineaInvestigacion(List<SelectItem> lstSILineaInvestigacion) {
        this.lstSILineaInvestigacion = lstSILineaInvestigacion;
    }
    
    public void findLineasDeInvestigacion() throws Exception{
        this.setLstLineaInvestigacion(this.lineaInvestigacionRNLocal.findLineasInvestigacion());
    }//fin findLineasDeInvestigacion
    
    public void cargarSILineaInvestigacion() throws Exception{
        this.setLstSILineaInvestigacion(new ArrayList<SelectItem>());
        int i = 0;
        for(LineaInvestigacion li : this.getLstLineaInvestigacion()){
            if (i <= 7) {
                if (!li.getDescripcion().trim().isEmpty()) {
                    SelectItem si = new SelectItem(li, li.getDescripcion());
                    this.getLstSILineaInvestigacion().add(si);
                }//fin if
            } else {
                break;
            }
            i++;
            
        }//fin for
    }//fin cargarSILineaInvestigacion
}
