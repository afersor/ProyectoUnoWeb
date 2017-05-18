/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;


/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class InvestigadorBean {

    private Investigador investigador;
    
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public InvestigadorBean() {
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    
    public void create(Investigador investigador) throws Exception{
        investigadorRNLocal.create(investigador);
  
    }//fin investigador
    
}
