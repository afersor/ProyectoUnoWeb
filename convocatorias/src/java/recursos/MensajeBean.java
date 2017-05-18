/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class MensajeBean {

    private String mensaje;
    
    public MensajeBean() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
