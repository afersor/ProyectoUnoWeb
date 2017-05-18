/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.Documento;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import recursos.FileDownload;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class InvestigadorCategorizacionPagBean {
    
    private Documento documento;

    @ManagedProperty("#{unidadAcademicaLstBean}")
    private UnidadAcademicaLstBean unidadAcademicaLstBean;
    
    @ManagedProperty("#{comisionCategorizacionLstBean}")
    private ComisionCategorizacionLstBean comisionCategorizacionLstBean;
    
    @ManagedProperty("#{valorCategoriaLstBean}")
    private ValorCategoriaLstBean valorCategoriaLstBean;
    
    @ManagedProperty("#{llamadoLstBean}")
    private LlamadoLstBean llamadoLstBean; 
    
    @ManagedProperty(value = "#{documentoLstBean}")
    private DocumentoLstBean documentoLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public InvestigadorCategorizacionPagBean() {
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    

    public DocumentoLstBean getDocumentoLstBean() {
        return documentoLstBean;
    }

    public void setDocumentoLstBean(DocumentoLstBean documentoLstBean) {
        this.documentoLstBean = documentoLstBean;
    }
    
    public ValorCategoriaLstBean getValorCategoriaLstBean() {
        return valorCategoriaLstBean;
    }

    public void setValorCategoriaLstBean(ValorCategoriaLstBean valorCategoriaLstBean) {
        this.valorCategoriaLstBean = valorCategoriaLstBean;
    }
    
    public LlamadoLstBean getLlamadoLstBean() {
        return llamadoLstBean;
    }

    public void setLlamadoLstBean(LlamadoLstBean llamadoLstBean) {
        this.llamadoLstBean = llamadoLstBean;
    }
    

    public ComisionCategorizacionLstBean getComisionCategorizacionLstBean() {
        return comisionCategorizacionLstBean;
    }

    public void setComisionCategorizacionLstBean(ComisionCategorizacionLstBean comisionCategorizacionLstBean) {
        this.comisionCategorizacionLstBean = comisionCategorizacionLstBean;
    }
    

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    public UnidadAcademicaLstBean getUnidadAcademicaLstBean() {
        return unidadAcademicaLstBean;
    }

    public void setUnidadAcademicaLstBean(UnidadAcademicaLstBean unidadAcademicaLstBean) {
        this.unidadAcademicaLstBean = unidadAcademicaLstBean;
    }
    
    
    public void abrirDiagCreate(){
        try {
            this.getUnidadAcademicaLstBean().findUnidadesAcademicas();
            this.getUnidadAcademicaLstBean().cargarSIUnidadesAcademicas();
            
            this.getComisionCategorizacionLstBean().findAllComisionCategorizacion();
            this.getComisionCategorizacionLstBean().cargarSIComisionCategorizacion();
            
            this.getLlamadoLstBean().findAllLlamado();
            this.getLlamadoLstBean().cargarSILlamado();
            
            this.getValorCategoriaLstBean().findAllValorCategoria();
            this.getValorCategoriaLstBean().cargarSIValorCategoria();
            
            //limpiar tabla documentos
            this.getDocumentoLstBean().setLstDocumento(null);
            
            RequestContext context = RequestContext.getCurrentInstance();  
            context.execute("dlgCreateCategorizacion.show()");
        } //fin abrirDiagCreate
        catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
             RequestContext.getCurrentInstance().update("frmUser:dMensaje");
             RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin abrirDiagCreate
    
    public void descargarArchivo(){
        try{
            
            FileDownload.descargarArchivo(this.getDocumento().getContenidoArchivo(), this.getDocumento().getNombreArchivo());

        } catch(Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin descargarArchivo
}
