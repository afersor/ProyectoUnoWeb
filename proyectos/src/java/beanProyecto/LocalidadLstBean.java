/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import entidades.localidad.Provincia;
import entidades.localidad.RN.LocalidadRNLocal;
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
public class LocalidadLstBean implements Serializable {

    private List<Localidad> lstLocalidad;
    
    private List<SelectItem> lstSILocalidad;
    
    @EJB
    private LocalidadRNLocal localidadRNLocal;
    
    public LocalidadLstBean() {
    }

    public List<Localidad> getLstLocalidad() {
        return lstLocalidad;
    }

    public void setLstLocalidad(List<Localidad> lstLocalidad) {
        this.lstLocalidad = lstLocalidad;
    }

    public List<SelectItem> getLstSILocalidad() {
        return lstSILocalidad;
    }

    public void setLstSILocalidad(List<SelectItem> lstSILocalidad) {
        this.lstSILocalidad = lstSILocalidad;
    }
    
    
     public void findLocalidadesByDpto(Departamento d) throws Exception{
        this.setLstLocalidad(this.localidadRNLocal.findLocalidadesByDpto(d));
    }//fin findLocalidads()
    
    public void cargarSILocalidades(){
        this.setLstSILocalidad(new ArrayList<SelectItem>());
        for(Localidad sdc : this.getLstLocalidad()){
            SelectItem si = new SelectItem(sdc, sdc.getDescripcion());
            this.getLstSILocalidad().add(si);
        }//fin for
    }//fin cargarSISubDisciplinasCientificas
}
