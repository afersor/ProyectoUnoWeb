/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;


import entidades.persona.CorreoElectronico;
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
public class CorreoElectronicoLstBean implements Serializable {

    private List<CorreoElectronico> lstCorreoElectronico;
    
    public CorreoElectronicoLstBean() {
    }

    public List<CorreoElectronico> getLstCorreoElectronico() {
        return lstCorreoElectronico;
    }

    public void setLstCorreoElectronico(List<CorreoElectronico> lstCorreoElectronico) {
        this.lstCorreoElectronico = lstCorreoElectronico;
    }
    
}
