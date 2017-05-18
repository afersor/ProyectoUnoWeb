/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.AreaTematica;
import entidades.proyecto.RN.AreaTematicaRNLocal;
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
public class AreaTematicaLstBean implements Serializable {

    private List<AreaTematica> lstAreaTematica;
    private List<SelectItem> lstSIAreaTematica;
    
    @EJB
    private AreaTematicaRNLocal areaTematicaRNLocal;
    
    public AreaTematicaLstBean() {
    }

    public List<AreaTematica> getLstAreaTematica() {
        return lstAreaTematica;
    }

    public void setLstAreaTematica(List<AreaTematica> lstAreaTematica) {
        this.lstAreaTematica = lstAreaTematica;
    }

    public List<SelectItem> getLstSIAreaTematica() {
        return lstSIAreaTematica;
    }

    public void setLstSIAreaTematica(List<SelectItem> lstSIAreaTematica) {
        this.lstSIAreaTematica = lstSIAreaTematica;
    }
    
    public void findAreasTematicas() throws Exception{
        this.setLstAreaTematica(this.areaTematicaRNLocal.findAreasTematicas());
    }//fin findAreasTematicas
    
    public void cargarSIAreasTematicas() throws Exception {
        this.setLstSIAreaTematica(new ArrayList<SelectItem>());
        for(AreaTematica at : this.getLstAreaTematica()){
            
            SelectItem si = new SelectItem(at, at.getDescripcion());
            this.getLstSIAreaTematica().add(si);

        }//fin for
    }

}
