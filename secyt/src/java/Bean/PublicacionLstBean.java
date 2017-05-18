/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.proyecto.Proyecto;
import entidades.proyecto.resultado.ArticuloRevista;
import entidades.proyecto.resultado.CapituloLibro;
import entidades.proyecto.resultado.Congreso;
import entidades.proyecto.resultado.Contrato;
import entidades.proyecto.resultado.FormacionRRHH;
import entidades.proyecto.resultado.Intelectual;
import entidades.proyecto.resultado.Libro;
import entidades.proyecto.resultado.Publicacion;
import entidades.proyecto.resultado.RN.PublicacionRNLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class PublicacionLstBean {

    @EJB
    private PublicacionRNLocal publicacionRNLocal;
    
    private List<Publicacion> lstPublicacion;
  
    public PublicacionLstBean() {
    }


    public List<Publicacion> getLstPublicacion() {
        return lstPublicacion;
    }

    public void setLstPublicacion(List<Publicacion> lstPublicacion) {
        this.lstPublicacion = lstPublicacion;
    }
     
    
    public void cargarPublicacionesByInvestigador(Long idProyecto, Long idInvestigador, Class tipo){
        
        System.out.println("Entro al cargar por investigador");
         try {
             
            this.setLstPublicacion(publicacionRNLocal.findByInvestigador(idProyecto,
                    idInvestigador, tipo));
            
            System.out.println("Litado de publicaciones: " + this.getLstPublicacion());
            
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + " ex " + ex.getCause());
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarPublicacionesByInvestigador
    
   
}
