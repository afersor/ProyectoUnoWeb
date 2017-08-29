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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
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
    
     private DataTable tablaArticuloRevista;
     private List<ArticuloRevista> lstArticuloRevista;
     private int iActionBtnSelect;
     private String nombreClasePublicacion;
     private Proyecto proyecto;
  
    public PublicacionLstBean() {
         lstArticuloRevista = new ArrayList<>();
         proyecto = new Proyecto();
    }


    public List<Publicacion> getLstPublicacion() {
        return lstPublicacion;
    }

    public void setLstPublicacion(List<Publicacion> lstPublicacion) {
        this.lstPublicacion = lstPublicacion;
    }

    public PublicacionRNLocal getPublicacionRNLocal() {
        return publicacionRNLocal;
    }

    public void setPublicacionRNLocal(PublicacionRNLocal publicacionRNLocal) {
        this.publicacionRNLocal = publicacionRNLocal;
    }

    public DataTable getTablaArticuloRevista() {
        return tablaArticuloRevista;
    }

    public void setTablaArticuloRevista(DataTable tablaArticuloRevista) {
        this.tablaArticuloRevista = tablaArticuloRevista;
    }

    public List<ArticuloRevista> getLstArticuloRevista() {
        return lstArticuloRevista;
    }

    public void setLstArticuloRevista(List<ArticuloRevista> lstArticuloRevista) {
        this.lstArticuloRevista = lstArticuloRevista;
    }
     
     public ArticuloRevista getArticuloSeleccionado() {
        return (ArticuloRevista) this.tablaArticuloRevista.getRowData();
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public String getNombreClasePublicacion() {
        return nombreClasePublicacion;
    }

    public void setNombreClasePublicacion(String nombreClasePublicacion) {
        this.nombreClasePublicacion = nombreClasePublicacion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
     
    public void cargarPublicacionesByInvestigador(Long idProyecto, Long idInvestigador, Class tipo){
        
       
         try {
             
            this.setLstPublicacion(publicacionRNLocal.findByInvestigador(idProyecto,
                    idInvestigador, tipo));
            
                        
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage() + " ex " + ex.getCause());
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarPublicacionesByInvestigador
    
   
}
