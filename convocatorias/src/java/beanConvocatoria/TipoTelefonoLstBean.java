/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.persona.RN.TipoTelefonoRNLocal;
import entidades.persona.TipoTelefono;
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
public class TipoTelefonoLstBean implements Serializable {

   private List<TipoTelefono> lstTipoTelefono;
    
    private List<SelectItem> lstSITipoTelefono;
    
    @EJB
    private TipoTelefonoRNLocal tipoTelefonoRNLocal;
    
    public TipoTelefonoLstBean() {
    }

    public List<TipoTelefono> getLstTipoTelefono() {
        return lstTipoTelefono;
    }

    public void setLstTipoTelefono(List<TipoTelefono> lstTipoTelefono) {
        this.lstTipoTelefono = lstTipoTelefono;
    }

    public List<SelectItem> getLstSITipoTelefono() {
        return lstSITipoTelefono;
    }

    public void setLstSITipoTelefono(List<SelectItem> lstSITipoTelefono) {
        this.lstSITipoTelefono = lstSITipoTelefono;
    }
    
    
     public void findTipoTelefonos() throws Exception{
        this.setLstTipoTelefono(this.tipoTelefonoRNLocal.findTipoTelefonos());
        System.out.println("telefonos: " + this.getLstTipoTelefono());
    }//fin findTipoTelefonos()
    
    public void cargarSITipoTelefonos(){
        this.setLstSITipoTelefono(new ArrayList<SelectItem>());
        for(TipoTelefono sdc : this.getLstTipoTelefono()){
            SelectItem si = new SelectItem(sdc, sdc.getDescripcion());
            this.getLstSITipoTelefono().add(si);
        }//fin for
    }//fin cargarSISubDisciplinasCientificas
}
