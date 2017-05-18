/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.persona.investigador.Mensaje;
import entidades.persona.investigador.RN.MensajeRNLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hugo
 */
@ManagedBean
@SessionScoped
public class MensajeLstBean implements Serializable {

    /**
     * Creates a new instance of MensajeLstBean
     */
    @EJB
    private MensajeRNLocal mensajeRNLocal;
    private List<Mensaje> lstMensajes;
    private List<Mensaje> lstMensajesRecibidos;
    private List<Mensaje> lstMensajesEnviados;
    private List<Mensaje> lstMensajesFiltrados;
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;

    public List<Mensaje> getLstMensajes() {
        return lstMensajes;
    }

    public void setLstMensajes(List<Mensaje> lstMensajes) {
        this.lstMensajes = lstMensajes;
    }

    public List<Mensaje> getLstMensajesRecibidos() {
        return lstMensajesRecibidos;
    }

    public void setLstMensajesRecibidos(List<Mensaje> lstMensajesRecibidos) {
        this.lstMensajesRecibidos = lstMensajesRecibidos;
    }

    public List<Mensaje> getLstMensajesEnviados() {
        return lstMensajesEnviados;
    }

    public void setLstMensajesEnviados(List<Mensaje> lstMensajesEnviados) {
        this.lstMensajesEnviados = lstMensajesEnviados;
    }

    public List<Mensaje> getLstMensajesFiltrados() {
        return lstMensajesFiltrados;
    }

    public void setLstMensajesFiltrados(List<Mensaje> lstMensajesFiltrados) {
        this.lstMensajesFiltrados = lstMensajesFiltrados;
    }
    
    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    public MensajeLstBean() {
    }

    @PostConstruct
    public void inicializarComponetes() {
        cargarMensajesRecibidosPorInvestigador();
        cargarMensajesEnviados();
    }

    public void cargarMensajesRecibidosPorInvestigador() {
        RequestContext context = RequestContext.getCurrentInstance();
        this.setLstMensajesRecibidos(null);
        try {
            this.setLstMensajesRecibidos(mensajeRNLocal.buscarMensajesRecibidos(this.getInvestigadorLoginBean().getInvestigador()));

        } catch (Exception ex) {
            Logger.getLogger(MensajeLstBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.update(":frmUser:dtMensajesRecibidos");

    }

    public void cargarMensajesEnviados() {
        this.setLstMensajesEnviados(null);
        try {
            this.setLstMensajesEnviados(mensajeRNLocal.buscarMensajesEnviados(this.getInvestigadorLoginBean().getInvestigador()));
        } catch (Exception ex) {
            Logger.getLogger(MensajeLstBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

    
