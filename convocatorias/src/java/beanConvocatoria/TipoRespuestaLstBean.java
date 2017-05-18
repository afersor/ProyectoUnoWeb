/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyectoWeb.TipoRespuesta;
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
public class TipoRespuestaLstBean implements Serializable {

    private List<SelectItem> lstSITipoRespuesta;
    /**
     * Creates a new instance of TipoRespuestaLstBean
     */
    public TipoRespuestaLstBean() {
    }

    public List<SelectItem> getLstSITipoRespuesta() {
        return lstSITipoRespuesta;
    }

    public void setLstSITipoRespuesta(List<SelectItem> lstSITipoRespuesta) {
        this.lstSITipoRespuesta = lstSITipoRespuesta;
    }
        
    public void cargarSITipoRespuesta() throws Exception{
        
        this.setLstSITipoRespuesta(new ArrayList<SelectItem>());
        for(TipoRespuesta tf : TipoRespuesta.values()){
            
            //if(!ua.getDescripcion().trim().isEmpty()){
                SelectItem si = new SelectItem(tf, tf.getName());
                this.getLstSITipoRespuesta().add(si);
           // }//fin if
            
        }//fin for
    }//fin cargarSIUnidadesAcademicas
    
}
