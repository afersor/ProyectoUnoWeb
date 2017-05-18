/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.persona.investigador.Investigador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AFerSor
 */
@ManagedBean(name="investigadorLoginBean")
@SessionScoped
public class InvestigadorLoginBean  implements Serializable{

    private Investigador investigador;
    
    private int cantLogin;
    
    public InvestigadorLoginBean() {
        this.cantLogin = 0;
    }

    public int getCantLogin() {
        return cantLogin;
    }

    public void setCantLogin(int cantLogin) {
        this.cantLogin = cantLogin;
    }
    
    

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    
    
}//FIN CLASE
