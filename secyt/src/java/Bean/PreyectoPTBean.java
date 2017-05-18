/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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
        
        this.setDetalle(this.getProyectoLstBean().cargarProyectosByAñoCodigoNombre(anio,codigo,nombre,resumen));
        this.setNombre("");
        this.setCodigo("");
        this.setResumen("");
        this.setAnio(null);
    }//fin buscarPorCodigo
}//FIN CLASE
