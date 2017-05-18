/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.RN.TipoProyectoRNLocal;
import entidades.TipoProyecto;
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
public class TipoProyectoLstBean implements Serializable {

    private List<TipoProyecto> lstTipoProyecto;
    private List<SelectItem> lstSITipoProyecto;
    
    @EJB
    private TipoProyectoRNLocal tipoProyectoRNLocal;
    
    public TipoProyectoLstBean() {
    }

    public List<TipoProyecto> getLstTipoProyecto() {
        return lstTipoProyecto;
    }

    public void setLstTipoProyecto(List<TipoProyecto> lstTipoProyecto) {
        this.lstTipoProyecto = lstTipoProyecto;
    }

    public List<SelectItem> getLstSITipoProyecto() {
        return lstSITipoProyecto;
    }

    public void setLstSITipoProyecto(List<SelectItem> lstSITipoProyecto) {
        this.lstSITipoProyecto = lstSITipoProyecto;
    }
    
    
    public void findTiposProyectos() throws Exception{
        this.setLstTipoProyecto(this.tipoProyectoRNLocal.findTiposProyectos());
    }//fin findTipoActividades
    
    public void cargarSITiposProyectos() throws Exception{
        this.setLstSITipoProyecto(new ArrayList<SelectItem>());
        
        for(TipoProyecto tp : this.getLstTipoProyecto()){
            
            if(!tp.getDescripcion().isEmpty()){
                SelectItem si = new SelectItem(tp, tp.getDescripcion());
                this.getLstSITipoProyecto().add(si);
            }//fin if

        }//fin for
    }//fin cargarSITiposActividades
}
