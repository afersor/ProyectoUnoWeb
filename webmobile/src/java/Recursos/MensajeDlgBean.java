/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class MensajeDlgBean {

     private String mensaje;
    
    private String pantalla;
    
    public MensajeDlgBean() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }
    
     public void cerrarPantalla(){
        RequestContext context = RequestContext.getCurrentInstance();  
        context.execute("dlgMensaje.hide()");
        if(!pantalla.isEmpty()){
            context.execute(this.getPantalla());
        }
    }//fin cerrarPantalla
}
