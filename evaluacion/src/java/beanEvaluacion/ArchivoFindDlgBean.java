/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.Documento;
import entidades.proyectoWeb.ArchivoWeb;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import recursos.MensajeBean;


/**
 *
 * @author diego
 */

@ManagedBean
@RequestScoped
public class ArchivoFindDlgBean {

    private int tipo;
    private Documento documento;
    
    @ManagedProperty(value = "#{categorizacionBean}")
    private CategorizacionBean categorizacionBean;
    
    @ManagedProperty(value = "#{documentoLstBean}")
    private DocumentoLstBean documentoLstBean;
    
    @ManagedProperty(value = "#{documentoBean}")
    private DocumentoBean documentoBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    

    public ArchivoFindDlgBean() {
        documento = new Documento();
    }

    public DocumentoBean getDocumentoBean() {
        return documentoBean;
    }

    public void setDocumentoBean(DocumentoBean documentoBean) {
        this.documentoBean = documentoBean;
    }
    
    public DocumentoLstBean getDocumentoLstBean() {
        return documentoLstBean;
    }

    public void setDocumentoLstBean(DocumentoLstBean documentoLstBean) {
        this.documentoLstBean = documentoLstBean;
    }
    
    public CategorizacionBean getCategorizacionBean() {
        return categorizacionBean;
    }

    public void setCategorizacionBean(CategorizacionBean categorizacionBean) {
        this.categorizacionBean = categorizacionBean;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public void quitarArchivo(Documento doc) {

        System.out.println("Entro: " + this.getDocumento());
        System.out.println("Entro 1: " + doc.getId());
        this.getDocumentoLstBean().getLstDocumento().remove(this.getDocumento());
        
        
        for(int i =0; i < this.getDocumentoLstBean().getLstDocumento().size(); i++){
            if(this.getDocumentoLstBean().getLstDocumento().get(i).getNombreArchivo().equals(doc.getNombreArchivo())){
                this.getDocumentoLstBean().getLstDocumento().remove(i);
            }//fin if
        }//fin for

        
        System.out.println("cant datos: " + this.getDocumentoLstBean().getLstDocumento().size());
        
        
    }//fin quitarSubDisciplinaCientifica

    public void handleFileUpload(FileUploadEvent event) {


        try {
            
            if (this.getDocumentoLstBean().getLstDocumento() == null) {
                this.getDocumentoLstBean().setLstDocumento(new ArrayList<Documento>());
            }//fin if

            for (Documento d : this.getDocumentoLstBean().getLstDocumento()) {
                if (d.getNombreArchivo().toLowerCase().toLowerCase().equals(event.getFile().getFileName().toLowerCase())) {
                    throw new Exception("El Archivo ya fue cargado.");
                }//fin if
            }//fin for

  
            this.getDocumentoBean().setDocumento(new Documento());
            this.getDocumentoBean().getDocumento().setContenidoArchivo(this.getFileContents(event.getFile().getInputstream()));
            
            this.getDocumentoBean().getDocumento().setNombreArchivo(event.getFile().getFileName());

            this.getDocumentoLstBean().getLstDocumento().add(this.getDocumentoBean().getDocumento());

            RequestContext context = RequestContext.getCurrentInstance();
            context.update("frmUser:frmTablaDoc:dtDocumento");
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin handleFileUpload

    private byte[] getFileContents(InputStream in) {
        byte[] bytes = null;
        try {
            // write the inputStream to a FileOutputStream            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read = 0;
            bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
            bytes = bos.toByteArray();
            in.close();
            in = null;
            bos.flush();
            bos.close();
            bos = null;
            //logger.debug("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }//fin getFileContents
}
