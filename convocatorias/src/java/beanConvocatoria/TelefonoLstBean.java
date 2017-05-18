/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;


import entidades.persona.Telefono;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class TelefonoLstBean implements Serializable {

    private List<Telefono> lstTelefono;
    
    public TelefonoLstBean() {
    }

    public List<Telefono> getLstTelefono() {
        return lstTelefono;
    }

    public void setLstTelefono(List<Telefono> lstTelefono) {
        this.lstTelefono = lstTelefono;
    }
}
