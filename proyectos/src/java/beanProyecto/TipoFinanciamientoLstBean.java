/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyectoPidWeb.TipoFinanciamiento;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class TipoFinanciamientoLstBean implements Serializable {

    private List<SelectItem> lstSITipoFinanciamiento;
    /**
     * Creates a new instance of TipoFinanciamientoLstBean
     */
    public TipoFinanciamientoLstBean() {
    }

    public List<SelectItem> getLstSITipoFinanciamiento() {
        return lstSITipoFinanciamiento;
    }

    public void setLstSITipoFinanciamiento(List<SelectItem> lstSITipoFinanciamiento) {
        this.lstSITipoFinanciamiento = lstSITipoFinanciamiento;
    }
        
    public void cargarSITipoFinanciamiento() throws Exception{
        
        this.setLstSITipoFinanciamiento(new ArrayList<SelectItem>());
        for(TipoFinanciamiento tf : TipoFinanciamiento.values()){
            
            //if(!ua.getDescripcion().trim().isEmpty()){
                SelectItem si = new SelectItem(tf, tf.getName());
                this.getLstSITipoFinanciamiento().add(si);
           // }//fin if
            
        }//fin for
    }//fin cargarSIUnidadesAcademicas
    
}
