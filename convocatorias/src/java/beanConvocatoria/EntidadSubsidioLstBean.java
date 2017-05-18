/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyectoWeb.EntidadSubsidio;
import entidades.proyectoWeb.RN.EntidadSubsidioRNLocal;
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

    private List<EntidadSubsidio> lstEntidadSubsidio;
    private List<SelectItem> lstSIEntidadSubsidio;
    
    @EJB
    private EntidadSubsidioRNLocal entidadSubsidioRNLocal;
    
    public EntidadSubsidioLstBean() {
    }

    public List<EntidadSubsidio> getLstEntidadSubsidio() {
        return lstEntidadSubsidio;
    }

    public void setLstEntidadSubsidio(List<EntidadSubsidio> lstEntidadSubsidio) {
        this.lstEntidadSubsidio = lstEntidadSubsidio;
    }

    public List<SelectItem> getLstSIEntidadSubsidio() {
        return lstSIEntidadSubsidio;
    }

    public void setLstSIEntidadSubsidio(List<SelectItem> lstSIEntidadSubsidio) {
        this.lstSIEntidadSubsidio = lstSIEntidadSubsidio;
    }
       
    public void findEntidadesSubsidios() throws Exception{
        this.setLstEntidadSubsidio(this.entidadSubsidioRNLocal.findEntidadesSubsidio());
    }//fin findAreasTematicas
    
    public void cargarSIEntidadesSubsidios() throws Exception {
        this.setLstSIEntidadSubsidio(new ArrayList<SelectItem>());
        for(EntidadSubsidio at : this.getLstEntidadSubsidio()){
            
            SelectItem si = new SelectItem(at, at.getDescripcion());
            this.getLstSIEntidadSubsidio().add(si);
        }//fin for
    }//fin cargarSIEntidadesSubsidios
    
}//FIN CLASE
