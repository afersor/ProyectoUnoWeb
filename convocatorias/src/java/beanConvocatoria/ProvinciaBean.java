/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.localidad.Provincia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;



/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class ProvinciaBean {

    @ManagedProperty("#{departamentoLstBean}")
    private DepartamentoLstBean departamentoLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public ProvinciaBean() {
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public DepartamentoLstBean getDepartamentoLstBean() {
        return departamentoLstBean;
    }

    public void setDepartamentoLstBean(DepartamentoLstBean departamentoLstBean) {
        this.departamentoLstBean = departamentoLstBean;
    }
        
    //cambio del valor del combo
    public void handleChange(ValueChangeEvent event){  
        
        try {
        if(!event.getNewValue().equals("Seleccionar")){
       // if(event.getNewValue() != null){
            this.getDepartamentoLstBean().findDepartamentosByProvincia(
                (Provincia)event.getNewValue());
        
            this.getDepartamentoLstBean().cargarSIDepartamentos();
        }//fin if
        
        }catch(Exception ex){
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin handleChange
}
