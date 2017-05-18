/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.localidad.Departamento;
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
public class DepartamentoBean {

    @ManagedProperty("#{localidadLstBean}")
    private LocalidadLstBean localidadLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public DepartamentoBean() {
    }

    public LocalidadLstBean getLocalidadLstBean() {
        return localidadLstBean;
    }

    public void setLocalidadLstBean(LocalidadLstBean localidadLstBean) {
        this.localidadLstBean = localidadLstBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    //cambio del valor del combo
    public void handleChange(ValueChangeEvent event){  
        
        try {
        if(!event.getNewValue().equals("Seleccionar")){
       // if(event.getNewValue() != null){
            this.getLocalidadLstBean().findLocalidadesByDpto(
                (Departamento)event.getNewValue());
        
            this.getLocalidadLstBean().cargarSILocalidades();
        }//fin if
        
        }catch(Exception ex){
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin handleChange
}
