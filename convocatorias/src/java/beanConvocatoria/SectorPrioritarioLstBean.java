/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyectoWeb.SectorPrioritario;
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
public class SectorPrioritarioLstBean implements Serializable {

    private List<SelectItem> lstSISectorPrioritario;
    /**
     * Creates a new instance of TipoFinanciamientoLstBean
     */
    public SectorPrioritarioLstBean() {
    }

    public List<SelectItem> getLstSISectorPrioritario() {
        return lstSISectorPrioritario;
    }

    public void setLstSISectorPrioritario(List<SelectItem> lstSISectorPrioritario) {
        this.lstSISectorPrioritario = lstSISectorPrioritario;
    }

    
        
    public void cargarSISectorPrioritario() throws Exception{
        
        this.setLstSISectorPrioritario(new ArrayList<SelectItem>());
        for(SectorPrioritario tf : SectorPrioritario.values()){
            
            //if(!ua.getDescripcion().trim().isEmpty()){
                SelectItem si = new SelectItem(tf, tf.getName());
                this.getLstSISectorPrioritario().add(si);
           // }//fin if
            
        }//fin for
    }//fin cargarSIUnidadesAcademicas
    
}
