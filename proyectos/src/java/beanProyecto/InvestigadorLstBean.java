/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
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
public class InvestigadorLstBean implements Serializable {

    private List<Investigador> lstInvestigador;
    
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    public InvestigadorLstBean() {
    }

    public List<Investigador> getLstInvestigador() {
        return lstInvestigador;
    }

    public void setLstInvestigador(List<Investigador> lstInvestigador) {
        this.lstInvestigador = lstInvestigador;
    }
    
    
    public void findLikeNombreyApellido(String cadena) throws Exception{
        this.setLstInvestigador(investigadorRNLocal.findLikeNombreyApellido(cadena));

    }//fin findInvestigadores
}
