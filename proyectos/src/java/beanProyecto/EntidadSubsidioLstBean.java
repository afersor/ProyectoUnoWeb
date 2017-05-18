/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyectoPidWeb.EntidadSubsidioPid;
import entidades.proyectoPidWeb.RN.EntidadSubsidioPidRNLocal;
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
public class EntidadSubsidioLstBean {

    private List<EntidadSubsidioPid> lstEntidadSubsidio;
    private List<SelectItem> lstSIEntidadSubsidio;
    
    @EJB
    private EntidadSubsidioPidRNLocal entidadSubsidioPidRNLocal;
    
    public EntidadSubsidioLstBean() {
    }

    public List<EntidadSubsidioPid> getLstEntidadSubsidio() {
        return lstEntidadSubsidio;
    }

    public void setLstEntidadSubsidio(List<EntidadSubsidioPid> lstEntidadSubsidio) {
        this.lstEntidadSubsidio = lstEntidadSubsidio;
    }

    public List<SelectItem> getLstSIEntidadSubsidio() {
        return lstSIEntidadSubsidio;
    }

    public void setLstSIEntidadSubsidio(List<SelectItem> lstSIEntidadSubsidio) {
        this.lstSIEntidadSubsidio = lstSIEntidadSubsidio;
    }
       
    public void findEntidadesSubsidios() throws Exception{
        this.setLstEntidadSubsidio(this.entidadSubsidioPidRNLocal.findEntidadesSubsidio());
    }//fin findAreasTematicas
    
    public void cargarSIEntidadesSubsidios() throws Exception {
        this.setLstSIEntidadSubsidio(new ArrayList<SelectItem>());
        for(EntidadSubsidioPid at : this.getLstEntidadSubsidio()){
            
            SelectItem si = new SelectItem(at, at.getDescripcion());
            this.getLstSIEntidadSubsidio().add(si);
        }//fin for
    }//fin cargarSIEntidadesSubsidios
    
}//FIN CLASE
