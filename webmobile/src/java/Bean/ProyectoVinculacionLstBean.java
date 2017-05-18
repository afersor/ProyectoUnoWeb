/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.Proyecto;
import entidades.proyecto.RN.ProyectoRNLocal;
import entidades.proyecto.vinculacion.ProyectoVinculacion;
import entidades.proyecto.vinculacion.RN.ProyectoVinculacionRNLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class ProyectoVinculacionLstBean implements Serializable {

    
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    private List<ProyectoVinculacion> lstProyectoVinculacion;
    private List<ProyectoVinculacion> proyectosVinculacionFiltrados;
    private List<String> aniosDeProyecto;

    public ProyectoVinculacionLstBean() {
    }

    public List<ProyectoVinculacion> getProyectosFiltrados() {
        return proyectosVinculacionFiltrados;
    }

    public void setProyectosFiltrados(List<ProyectoVinculacion> proyectosFiltrados) {
        this.proyectosVinculacionFiltrados = proyectosFiltrados;
    }

    @PostConstruct
    public void initIt()  {
    }

    public List<String> getAniosDeProyecto() {
        return aniosDeProyecto;
    }

    public void setAniosDeProyecto(List<String> aniosDeProyecto) {
        this.aniosDeProyecto = aniosDeProyecto;
    }

    public List<ProyectoVinculacion> getLstProyecto() {
        return lstProyectoVinculacion;
    }

    public void setLstProyecto(List<ProyectoVinculacion> lstProyecto) {
        this.lstProyectoVinculacion = lstProyecto;
    }

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

   
    private boolean isNumeric(String cadena) {
        try {
            int parseInt = Integer.parseInt(cadena);

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    
}//FIN CLASE
