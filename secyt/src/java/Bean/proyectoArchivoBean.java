/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Recursos.FileDownload;
import entidades.Documento;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fz
 */
@ManagedBean
@RequestScoped
public class proyectoArchivoBean {

    
      
    public proyectoArchivoBean() {
    }

      
    
    public void descargarArchivo(Documento documento){
        try{
            
            
            FileDownload.descargarArchivo(documento.getContenidoArchivo(), documento.getNombreArchivo());

        } catch(Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin descargarArchivo
}//fin 
