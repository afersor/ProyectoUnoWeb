/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.persona.investigador.Especializacion;
import entidades.persona.investigador.RN.EspecializacionRNLocal;
import entidades.proyecto.Especialidad;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class EspecializacionLstBean implements Serializable {

    private List<Especializacion> lstEspecializacion;
    
    @EJB
    private EspecializacionRNLocal especializacionRNLocal;
    
    public EspecializacionLstBean() {
    }

    public List<Especializacion> getLstEspecializacion() {
        return lstEspecializacion;
    }

    public void setLstEspecializacion(List<Especializacion> lstEspecializacion) {
        this.lstEspecializacion = lstEspecializacion;
    }

    public void findByInvestigador(Long idInvestigador) throws Exception{
        
        lstEspecializacion = especializacionRNLocal.findByInvestigador(idInvestigador);
        
    }//fin findByInvestigador
}
