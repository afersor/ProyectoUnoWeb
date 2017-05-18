/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyectoPidWeb.ProyectoPidWeb;
import java.util.Date;
import javax.inject.Named;
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
public class ConvocatoriaPagBean {

    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    @ManagedProperty("#{convocatoriaLstBean}")
    private ConvocatoriaLstBean convocatoriaLstBean;
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    @ManagedProperty("#{proyectoWebLstBean}")
    private ProyectoWebLstBean proyectoWebLstBean;

    public ConvocatoriaPagBean() {
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public ProyectoWebLstBean getProyectoWebLstBean() {
        return proyectoWebLstBean;
    }

    public void setProyectoWebLstBean(ProyectoWebLstBean proyectoWebLstBean) {
        this.proyectoWebLstBean = proyectoWebLstBean;
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }

    public ConvocatoriaLstBean getConvocatoriaLstBean() {
        return convocatoriaLstBean;
    }

    public void setConvocatoriaLstBean(ConvocatoriaLstBean convocatoriaLstBean) {
        this.convocatoriaLstBean = convocatoriaLstBean;
    }

    public void findConvocatoriasAbiertas() {
        String sMensaje = "";
        try {

            this.getConvocatoriaLstBean().findConvocatoriasAbiertas();

        } catch (Exception ex) {

            sMensaje = "Error: " + ex.getMessage();
            this.getMensajeBean().setMensaje(sMensaje);
            RequestContext.getCurrentInstance().update("dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");

        }//fin try-catch

    }//fin findConvocatoriasActivas

    public void deleteProyecto(ProyectoPidWeb pw) {
        try {

            this.getProyectoWebBean().delete(pw);
            this.getProyectoWebLstBean().getLstProyectoWeb().remove(pw);

            this.getMensajeBean().setMensaje("El proyecto fue eliminado");
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        } catch (Exception ex) {

            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");

        }
    }//fin deleteProyecto

    public Boolean activarBotonEditar(ProyectoPidWeb pw) {
        if (new Date().compareTo(pw.getConvocatoria().getFechaFin()) >= 0) {
            return false;
        } else {
            if (!pw.getFinalizado()) {
                return true;
            } else {
                if (pw.getObservaciones() != null) {
                    if (!pw.getObservaciones().isEmpty()) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (pw.getFechaArchivo() != null) {
                    if (pw.getFechaArchivo().compareTo(new Date()) >= 0) {
                        return false;
                    } else {
                        return true;//fin if
                    }
                } else {
                    return false;
                }
            }
        }
    }
}
