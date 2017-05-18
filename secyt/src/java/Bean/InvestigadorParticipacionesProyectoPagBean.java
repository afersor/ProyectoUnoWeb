/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Recursos.MensajeDlgBean;
import entidades.categorizacion.EvaluacionWinsipIntegrantes;
import entidades.persona.investigador.Investigador;
import entidades.proyecto.Proyecto;
import entidades.proyecto.RN.ProyectoRNLocal;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class InvestigadorParticipacionesProyectoPagBean {

    @EJB
    private ProyectoRNLocal proyectoRNLocal;

    private Proyecto proyectoSelect;

    @ManagedProperty(value = "#{winsipLstBean}")
    private WinsipLstBean winsipLstBean;

    @ManagedProperty("#{mensajeDlgBean}")
    private MensajeDlgBean mensajeDlgBean;

    public InvestigadorParticipacionesProyectoPagBean() {
    }

    public Proyecto getProyectoSelect() {
        return proyectoSelect;
    }

    public void setProyectoSelect(Proyecto proyectoSelect) {
        this.proyectoSelect = proyectoSelect;
    }

    public MensajeDlgBean getMensajeDlgBean() {
        return mensajeDlgBean;
    }

    public void setMensajeDlgBean(MensajeDlgBean mensajeDlgBean) {
        this.mensajeDlgBean = mensajeDlgBean;
    }

    public WinsipLstBean getWinsipLstBean() {
        return winsipLstBean;
    }

    public void setWinsipLstBean(WinsipLstBean winsipLstBean) {
        this.winsipLstBean = winsipLstBean;
    }

    public List<EvaluacionWinsipIntegrantes> obtenerIntegrantesWinsip(List<EvaluacionWinsipIntegrantes> inte) {
        List<EvaluacionWinsipIntegrantes> list = new ArrayList<EvaluacionWinsipIntegrantes>();
        for (EvaluacionWinsipIntegrantes integrante : inte) {
            if (integrante.getEvaluacion() != null && integrante.getInforme() != null && integrante.getFecha() != null) {
                list.add(integrante);
            }
        }
        return list;
    }

    public boolean tieneWinsip(Proyecto proyecto) {
        try {
            this.setProyectoSelect(proyecto);
            System.out.println("idPoryecto: " + proyecto.getId());
            this.getWinsipLstBean().findByProyecto(proyecto.getId());
            System.out.println("Datos: " + this.getWinsipLstBean().getLstWinsip());
            return this.getWinsipLstBean().getLstWinsip() != null && !this.getWinsipLstBean().getLstWinsip().isEmpty();
        } catch (Exception ex) {
            return false;
        }

    }

    public String verWinzip(Proyecto proyecto) {
        try {

            this.setProyectoSelect(proyecto);
            System.out.println("idPoryecto: " + proyecto.getId());
            this.getWinsipLstBean().findByProyecto(proyecto.getId());

            System.out.println("Datos: " + this.getWinsipLstBean().getLstWinsip());

            if (this.getWinsipLstBean().getLstWinsip() == null
                    || this.getWinsipLstBean().getLstWinsip().isEmpty()) {
                this.getMensajeDlgBean().setMensaje("No hay winsip cargados para el proyecto");
                RequestContext.getCurrentInstance().update("frmUser:dMensaje");
                RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
                return "";
            } else {
                return "proyectoWinsip.xhtml";

                //mostrar el dialogo winzip
//                RequestContext.getCurrentInstance().update("frmUser:dWinsip");
//                RequestContext.getCurrentInstance().execute("dlgWinsip.show()");
            }//fin if-else

        } catch (Exception ex) {
            this.getMensajeDlgBean().setMensaje("No hay winsip cargados para el proyecto");
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
            return "";
        }
    }//fin ver Winzip

    public Investigador getDirector(Proyecto proyecto) {
        try {
            return proyectoRNLocal.getDirectorInvestigador(proyecto);
        } catch (Exception ex) {
            return null;
        }

    }
}
