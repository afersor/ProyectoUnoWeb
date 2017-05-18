/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyecto.CampoAplicacion;
import entidades.proyecto.SubDisciplinaCientifica;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class ProyectoIPagBean {

   @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
   
    public ProyectoIPagBean() {
    }
    

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    
     public void quitarSubDisciplinaCientifica(SubDisciplinaCientifica sdc){
        this.getProyectoWebBean().getProyectoWeb().getSubDisciplinasCientificas().remove(sdc);
    }//fin quitarSubDisciplinaCientifica
     
    public void quitarCampoAplicacion(CampoAplicacion ca){
        this.getProyectoWebBean().getProyectoWeb().getCamposAplicacion().remove(ca);
    }//fin quitarCampoAplicacion
}
