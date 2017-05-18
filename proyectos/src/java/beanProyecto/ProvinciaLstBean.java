/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.localidad.Provincia;
import entidades.localidad.RN.ProvinciaRNLocal;
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
public class ProvinciaLstBean implements Serializable {

    private List<Provincia> lstProvincia;
    
    private List<SelectItem> lstSIProvincia;
    
    @EJB
    private ProvinciaRNLocal provinciaRNLocal;
    
    public ProvinciaLstBean() {
    }

    public List<Provincia> getLstProvincia() {
        return lstProvincia;
    }

    public void setLstProvincia(List<Provincia> lstProvincia) {
        this.lstProvincia = lstProvincia;
    }

    public List<SelectItem> getLstSIProvincia() {
        return lstSIProvincia;
    }

    public void setLstSIProvincia(List<SelectItem> lstSIProvincia) {
        this.lstSIProvincia = lstSIProvincia;
    }
    
    
    public void findProvincias() throws Exception{
        this.setLstProvincia(this.provinciaRNLocal.findProvincias());
    }//fin findProvincias()
    
    public void cargarSIProvincias(){
        this.setLstSIProvincia(new ArrayList<SelectItem>());
        for(Provincia sdc : this.getLstProvincia()){
            SelectItem si = new SelectItem(sdc, sdc.getDescripcion());
            this.getLstSIProvincia().add(si);
        }//fin for
    }//fin cargarSISubDisciplinasCientificas
}
