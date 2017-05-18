/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.investigador.Investigador;
import entidades.proyecto.Proyecto;
import entidades.proyecto.RN.ProyectoRNLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import recursos.FileDownload;

/**
 *
 * @author Fz
 */
@ManagedBean(name = "proyectoBean")
@SessionScoped
public class ProyectoBean implements Serializable {

    @EJB
    private ProyectoRNLocal proyectoRNLocal;
    private Proyecto proyecto;

    public ProyectoBean() {
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {

        this.proyecto = proyecto;
    }

    public String verDirector() {
        try {
            return proyectoRNLocal.getDirector(proyecto);
        } catch (Exception ex) {
            return "";
        }
    }

    public Investigador getDirector() {
        try {
            return proyectoRNLocal.getDirectorInvestigador(proyecto);
        } catch (Exception ex) {
            return null;
        }

    }
    
    public void descargarArchivo(byte[] archivo, String nombre){
        try{
                        
            FileDownload.descargarArchivo(archivo, nombre);

        } catch(Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin descargarArchivo
}//FIN CLASE
