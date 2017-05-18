/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.vinculacion.ProyectoVinculacion;
import entidades.proyecto.vinculacion.RN.ProyectoVinculacionRNLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fz
 */
@ManagedBean(name="proyectoVinculacionBean")
@SessionScoped
public class ProyectoVinculacionBean  implements Serializable{
  @EJB
    private ProyectoVinculacionRNLocal proyectoVinculacionRNLocal;
    private ProyectoVinculacion  proyectoVinculacion;
    
    public ProyectoVinculacionBean() {
    }

    public ProyectoVinculacion getProyecto() {
        return proyectoVinculacion;
    }

    public void setProyecto(ProyectoVinculacion proyecto) {
        
        System.out.println("Proyecto: " + proyecto);
        this.proyectoVinculacion = proyecto;
    }

  
       public String verDirector() {
        try {
            return proyectoVinculacionRNLocal.getDirector(proyectoVinculacion);
        } catch (Exception ex) {            
            return "";
        }

    }
    
}//FIN CLASE
