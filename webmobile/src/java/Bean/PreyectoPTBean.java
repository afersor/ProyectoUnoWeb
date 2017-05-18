/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class PreyectoPTBean {

    private Integer anio;
    private String detalle;
    private String codigo;
    private String nombre;
    private String resumen;
    @ManagedProperty(value = "#{proyectoLstBean}")
    private ProyectoLstBean proyectoLstBean;

    public PreyectoPTBean() {
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public ProyectoLstBean getProyectoLstBean() {
        return proyectoLstBean;
    }

    public void setProyectoLstBean(ProyectoLstBean proyectoLstBean) {
        this.proyectoLstBean = proyectoLstBean;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void findByAnio() {
        this.setDetalle(this.getProyectoLstBean().cargarProyectosByAño(anio));
    }//fin findByAnio

    public void buscarPorCodigo() {
        this.setDetalle(this.getProyectoLstBean().cargarProyectosPorCodigo(codigo));
        this.setNombre("");
    }//fin buscarPorCodigo

    public void buscarPorTitulo() {
        this.setDetalle(this.getProyectoLstBean().cargarProyectosPorTitulo(nombre));
        this.setCodigo("");
    }//fin buscarPorCodigo

    public void findByAñoCodigoNombreResumen() {        
        try {
            Integer aniio = null;
            try {
                aniio = Integer.parseInt(resumen);
            } catch (NumberFormatException numberFormatException) {
            }
            this.setDetalle(this.getProyectoLstBean().cargarProyectosByAñoCodigoNombre(aniio,resumen,resumen,resumen));
            this.setNombre("");
            this.setCodigo("");
            this.setResumen("");
            this.setAnio(null);
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/proyecto.xhtml");
        } //fin buscarPorCodigo
        catch (IOException ex) {
            Logger.getLogger(PreyectoPTBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}//FIN CLASE
