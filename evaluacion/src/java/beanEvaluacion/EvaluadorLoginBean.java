/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.Evaluador;
import entidades.persona.investigador.Investigador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AFerSor
 */
@ManagedBean(name="evaluadorLoginBean")
@SessionScoped
public class EvaluadorLoginBean  implements Serializable{

    private Evaluador evaluador;
    
    private Long idUniversidad;
    
    private int cantLogin;
    
    public EvaluadorLoginBean() {
        this.cantLogin = 0;
    }

    public Long getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Long idUniversidad) {
        this.idUniversidad = idUniversidad;
    }
    
    public int getCantLogin() {
        return cantLogin;
    }

    public void setCantLogin(int cantLogin) {
        this.cantLogin = cantLogin;
    }
    
    

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }    
    
}//FIN CLASE
