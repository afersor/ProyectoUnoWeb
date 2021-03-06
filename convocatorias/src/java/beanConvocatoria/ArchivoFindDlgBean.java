/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

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
    private ArchivoWeb archivoWeb;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    public ArchivoFindDlgBean() {
        archivoWeb = new ArchivoWeb();
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

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }

    public ArchivoWeb getArchivoWeb() {
        return archivoWeb;
    }

    public void setArchivoWeb(ArchivoWeb archivoWeb) {
        this.archivoWeb = archivoWeb;
    }

    public void quitarArchivo(ArchivoWeb aw) {
        
        System.out.println("archivo web: " + aw);
        
        this.getProyectoWebBean().getProyectoWeb().getLstArchivoWeb().remove(aw);
    }//fin quitarSubDisciplinaCientifica

    public void handleFileUpload(FileUploadEvent event) {

        System.out.println("archivo: " + event.getFile().getFileName());

        try {
            if (this.getProyectoWebBean().getProyectoWeb().getLstArchivoWeb() == null) {
                this.getProyectoWebBean().getProyectoWeb().setLstArchivoWeb(new ArrayList<ArchivoWeb>());
            }//fin if

            for (ArchivoWeb aw : this.getProyectoWebBean().getProyectoWeb().getLstArchivoWeb()) {
                if (aw.getNombre().toLowerCase().equals(event.getFile().getFileName().toLowerCase())) {
                    throw new Exception("El Archivo ya fue cargado.");
                }//fin if
            }//fin for

  
            this.getArchivoWeb().setContenidoArchivo(this.getFileContents(event.getFile().getInputstream()));
            this.getArchivoWeb().setNombre(event.getFile().getFileName());



            this.getProyectoWebBean().getProyectoWeb().getLstArchivoWeb().add(this.archivoWeb);

            RequestContext context = RequestContext.getCurrentInstance();
            context.update("frmUser:dtArchivoWeb");
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
