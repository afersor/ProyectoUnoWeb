/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;


import entidades.RN.UnidadEjecutoraRNLocal;
import entidades.UnidadEjecutora;
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
public class UnidadEjecutoraLstBean implements Serializable {

    private List<UnidadEjecutora> lstUnidadEjecutora;
    private List<SelectItem> lstSIUnidadEjecutora;
    
    @EJB
    private UnidadEjecutoraRNLocal unidadEjecutoraRNLocal;
    
    public UnidadEjecutoraLstBean() {
    }

    public List<UnidadEjecutora> getLstUnidadEjecutora() {
        return lstUnidadEjecutora;
    }

    public void setLstUnidadEjecutora(List<UnidadEjecutora> lstUnidadEjecutora) {
        this.lstUnidadEjecutora = lstUnidadEjecutora;
    }

    public List<SelectItem> getLstSIUnidadEjecutora() {
        return lstSIUnidadEjecutora;
    }

    public void setLstSIUnidadEjecutora(List<SelectItem> lstSIUnidadEjecutora) {
        this.lstSIUnidadEjecutora = lstSIUnidadEjecutora;
    }
    
    public void findUnidadesEjecutoras() throws Exception{
        this.setLstUnidadEjecutora(this.unidadEjecutoraRNLocal.findUnidadesEjecutoras());
    }//fin findUnidadesEjecutoras
    
    public void cargarSIUnidadesEjecutoras() throws Exception{
        this.setLstSIUnidadEjecutora(new ArrayList<SelectItem>());
        for(UnidadEjecutora ue : this.getLstUnidadEjecutora()){
            
            //if(!ua.getDescripcion().trim().isEmpty()){
                SelectItem si = new SelectItem(ue, ue.getDescripcion());
                this.getLstSIUnidadEjecutora().add(si);
           // }//fin if
            
        }//fin for
    }//fin cargarSIUnidadesEjecutoras
}
