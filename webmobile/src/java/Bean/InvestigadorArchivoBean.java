/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Recursos.FileDownload;
import entidades.Documento;
import entidades.Resolucion;
import entidades.persona.investigador.Investigador;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class InvestigadorArchivoBean {
    
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    
    @ManagedProperty(value = "#{investigadorBean}")
    private InvestigadorBean investigadorBean;
    
    private Documento documento;
    
    public InvestigadorArchivoBean() {
    }
    
    public Documento getDocumento() {
        return documento;
    }
    
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    
    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }
    
    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }
    
    public InvestigadorBean getInvestigadorBean() {
        return investigadorBean;
    }
    
    public void setInvestigadorBean(InvestigadorBean investigadorBean) {
        this.investigadorBean = investigadorBean;
    }
    
    public void handleFileUpload(FileUploadEvent event) {        
        
        System.out.println("paso 1: " + event.getFile());
        Documento doc = new Documento();
        doc.setNombreArchivo(event.getFile().getFileName());
        doc.setContenidoArchivo(event.getFile().getContents());
        
        Resolucion resol = new Resolucion();
        resol.setFecha(new Date());
        resol.setDocumento(doc);
        resol.setDescripcion(event.getFile().getFileName());
        System.out.println("paso 2");
        Investigador investigador = this.getInvestigadorLoginBean().getInvestigador();
        
        if (investigador.getResoluciones() == null) {
            investigador.setResoluciones(new ArrayList<Resolucion>());
        }//fin if
        
        System.out.println("paso 3");
        investigador.getResoluciones().add(resol);
        
        System.out.println("paso 4");
        //modifica el investigador
        this.getInvestigadorBean().edit(investigador);
        
        RequestContext.getCurrentInstance().update("dtArchivos");
        
    }//fin  handleFileUpload
    
    public void descargarArchivo() {
        try {
            
            FileDownload.descargarArchivo(this.getDocumento().getContenidoArchivo(), this.getDocumento().getNombreArchivo());
            
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin descargarArchivo
    
    public void eliminarArchivo(Resolucion resolucion) {
        
        Investigador investigador = this.getInvestigadorLoginBean().getInvestigador();
        
        System.out.println("Resolucion: " + resolucion.getId());
        
        investigador.getResoluciones().remove(resolucion);
        
        System.out.println("paso 4");
        //modifica el investigador
        this.getInvestigadorBean().edit(investigador);
        
    }//fin eliminarArchivo
}//fin 
