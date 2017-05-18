/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.persona.investigador.Destinatario;
import entidades.persona.investigador.Mensaje;
import entidades.persona.investigador.RN.MensajeRNLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class MensajeBean {

    @EJB
    private MensajeRNLocal mensajeRNLocal;
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    @ManagedProperty(value = "#{mensajeLstBean}")
    private MensajeLstBean mensajeLstBean;
    private Mensaje mensaje;

    public MensajeBean() {
        mensaje = new Mensaje();
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        System.out.println("mensajeee" + mensaje);
        this.mensaje = mensaje;
    }

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    public MensajeLstBean getMensajeLstBean() {
        return mensajeLstBean;
    }

    public void setMensajeLstBean(MensajeLstBean mensajeLstBean) {
        this.mensajeLstBean = mensajeLstBean;
    }
    
    public void create() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            mensaje.setInvestigador(this.getInvestigadorLoginBean().getInvestigador());
            mensaje.setDestinatario(Destinatario.AREASECYT);
            mensajeRNLocal.create(mensaje);

            sMensaje = "Su mensaje fue enviado";
            severity = FacesMessage.SEVERITY_INFO;

            this.limpiar();
            this.getMensajeLstBean().cargarMensajesEnviados();

        } catch (Exception ex) {

            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin create

    private void limpiar() {
        this.setMensaje(new Mensaje());
    }//fin limpiar

    public void cambiarEstadoMje(Mensaje m) {
        this.setMensaje(m);
        this.getMensaje().setLeido(true);
        try {
            mensajeRNLocal.modificar(this.getMensaje());
        } catch (Exception ex) {
            Logger.getLogger(MensajeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String strLeido(Mensaje m) {
        if (m.getLeido()) {
            return "Leído";
        } else {
            return "No leído";
        }
    }
    public String mensajeResumen(Mensaje m){
        if(m.getDescripcion().length()>50){
            return m.getDescripcion().substring(0, 50);
        }else{
            return m.getDescripcion();
        }
    }
}
