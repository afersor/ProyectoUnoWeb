/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.localidad.Localidad;
import entidades.persona.Domicilio;
import entidades.persona.Persona;
import entidades.persona.investigador.Investigador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AFerSor
 */
@ManagedBean(name="investigadorLoginBean")
@SessionScoped
public class InvestigadorLoginBean  implements Serializable{

    private Investigador investigador;
        
    
    public InvestigadorLoginBean() {
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    
    
    
}//FIN CLASE
