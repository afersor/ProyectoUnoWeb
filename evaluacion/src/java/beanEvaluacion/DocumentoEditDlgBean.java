package beanEvaluacion;


import entidades.Documento;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import recursos.MensajeBean;


@ManagedBean(name = "documentoEditDlgBean")
@RequestScoped
public class DocumentoEditDlgBean {

    private String textBoton;
    private int accionBtn;
    private Boolean campoEditable;
    private String icono;
    
    @ManagedProperty(value = "#{documentoBean}")
    private DocumentoBean documentoBean;
    
    @ManagedProperty(value = "#{documentoLstBean}")
    private DocumentoLstBean documentoLstBean;
    
    @ManagedProperty(value = "#{evaluacionWebBean}")
    private EvaluacionWebBean evaluacionWebBean;
    
    @ManagedProperty(value = "#{evaluacionWebLstBean}")
    private EvaluacionWebLstBean evaluacionWebLstBean;
    
    
    @ManagedProperty(value = "#{mensajeBean}")
    private MensajeBean mensajeBean;

    public DocumentoEditDlgBean() {
    }

    public EvaluacionWebLstBean getEvaluacionWebLstBean() {
        return evaluacionWebLstBean;
    }

    public void setEvaluacionWebLstBean(EvaluacionWebLstBean evaluacionWebLstBean) {
        this.evaluacionWebLstBean = evaluacionWebLstBean;
    }

    public DocumentoLstBean getDocumentoLstBean() {
        return documentoLstBean;
    }

    public void setDocumentoLstBean(DocumentoLstBean documentoLstBean) {
        this.documentoLstBean = documentoLstBean;
    }
    
    
    public EvaluacionWebBean getEvaluacionWebBean() {
        return evaluacionWebBean;
    }

    public void setEvaluacionWebBean(EvaluacionWebBean evaluacionWebBean) {
        this.evaluacionWebBean = evaluacionWebBean;
    }
    
    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public DocumentoBean getDocumentoBean() {
        return documentoBean;
    }

    public void setDocumentoBean(DocumentoBean documentoBean) {
        this.documentoBean = documentoBean;
    }

    public Boolean getCampoEditable() {
        return campoEditable;
    }
    

    public void setCampoEditable(Boolean campoEditable) {
        this.campoEditable = campoEditable;
    }

    public String getTextBoton() {
        return textBoton;
    }

    public void setTextBoton(String textBoton) {
        this.textBoton = textBoton;
    }

    public int getAccionBtn() {
        return accionBtn;
    }

    public void setAccionBtn(int accionBtn) {
        this.accionBtn = accionBtn;
    }

    

    public void setBtnSelect(ActionEvent e) {
        
        
                
        CommandButton btnSelect = (CommandButton) e.getSource();      
        
        System.out.println("entro: " + btnSelect.getId());
        
        if (btnSelect.getId().equals("cbDocumentoCreate")) {
            this.setAccionBtn(1);
            this.setTextBoton("Guardar");
            this.getDocumentoLstBean().setDocumento(new Documento());
            RequestContext.getCurrentInstance().update(":frmPri:dDocumentoEditDlg");
        } else if (btnSelect.getId().equals("cbDocumentoDelete")) {
            this.setAccionBtn(3);
            this.setCampoEditable(Boolean.FALSE);
            this.setTextBoton("Eliminar");
        } else if (btnSelect.getId().equals("cbDocumentoEdit")) {
            this.setAccionBtn(2);
            this.setTextBoton("Modificar");
        }
        
        this.getMensajeBean().setPagCerrar(null);
    }

    public void actionBtn() {
        
        System.out.println("accion boton: " + this.getAccionBtn());
        
        switch (this.getAccionBtn()) {
            case 1:
                this.create();
                break;
            case 2:
                this.edit();
                break;
            case 3:
                this.delete();
                break;
        }
    }

    public void create() {
        String mensaje = "";
        try {
            
            if(this.getDocumentoLstBean().getDocumento().getNombreArchivo()==null || 
                    this.getDocumentoLstBean().getDocumento().getNombreArchivo().isEmpty()){
                throw new Exception("Debe seleccionar el archivo");
            }//fin if
           
            int pos = this.getEvaluacionWebLstBean().getLstEvaluacionWeb().indexOf(this.getEvaluacionWebBean().getEvaluacionWeb());
            
            System.out.println("posicion encontrada: " + pos);
            
            if(this.getEvaluacionWebLstBean().getLstEvaluacionWeb()==null){
                this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).
                        setDocumentos(new ArrayList<Documento>());
            }//fin if
            
            int cant = this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).getDocumentos().size();
            
            for(int i=0; i<cant; i++){
                
               
                if(this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).
                        getDocumentos().get(i).getNombreArchivo().equals(
                                this.getDocumentoLstBean().getDocumento().
                                        getNombreArchivo())){

                    throw new Exception("Ya esta adjuntado un documento con el mismo nombre");
                }//fin if
            }//fin for
            
            this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).getDocumentos().add(
                    this.getDocumentoLstBean().getDocumento());
            
            this.getEvaluacionWebBean().setEvaluacionWeb(
                    this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos));
            
            this.getEvaluacionWebBean().edit();
            
            this.getMensajeBean().setTipoIcono('I');
            this.getMensajeBean().setPagCerrar("dlgDocumentoEditDlg.hide()");
            this.getMensajeBean().setMensaje("El documento fue guardado");
            
            RequestContext.getCurrentInstance().update("frmUser:pArchivo");
                                
            /*if(this.getDocumentoBean().getDocumento().getId()==null){
                this.getDocumentoBean().create();
            }
            
            

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "La operación se realizo con exito", null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
            
            //RequestContext.getCurrentInstance().update("frmPri:pExpediente");

            
           

            
            mensaje = "Los datos fueron guardados";
            RequestContext.getCurrentInstance().update("frmPri:dtDocumentoD");
            RequestContext.getCurrentInstance().update("frmUsu:dtDocumentoD");
            
            this.getMensajeBean().setTipoIcono('I');
            this.getMensajeBean().setPagCerrar("dlgDocumentoEditDlg.hide()");*/
        } catch (Exception ex) {
                        
            this.getMensajeBean().setTipoIcono('E');
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
        } finally {
            
            System.out.println("Entro al finali: " + mensaje);
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }

    public void edit() {
        /*String mensaje = "";
        try {
            this.getDocumentoBean().edit();
            
            //actualizar la tabla

            
            mensaje = "Los datos fueron modificados";
            RequestContext.getCurrentInstance().update("frmPri:dtDocumento");
            RequestContext.getCurrentInstance().update("frmUsu:dtDocumento");
            this.getMensajeBean().setTipoIcono('I');
            this.getMensajeBean().setPagCerrar("dlgDocumentoEditDlg.hide()");
        } catch (Exception ex) {
            this.getMensajeBean().setTipoIcono('E');
            mensaje = "Error: " + ex.getMessage();
        } finally {
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update("frmPri:dMensaje");
            RequestContext.getCurrentInstance().update("frmUsu:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }*/
    }

    public void delete() {
        String mensaje = "";
        try {
            int pos = this.getEvaluacionWebLstBean().getLstEvaluacionWeb().indexOf(this.getEvaluacionWebBean().getEvaluacionWeb());
            
            
            int cant = this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).getDocumentos().size();
            
            for(int i=0; i<cant; i++){
                
               
                if(this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).
                        getDocumentos().get(i).getNombreArchivo().equals(
                                this.getDocumentoLstBean().getDocumento().
                                        getNombreArchivo())){

                    this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).getDocumentos().remove(i);
                    break;
                }//fin if
            }//fin for

            System.out.println("pos: " + pos + " tam2: " + this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos).getDocumentos().size());
            
            this.getEvaluacionWebBean().setEvaluacionWeb(
                    this.getEvaluacionWebLstBean().getLstEvaluacionWeb().get(pos));
            
            this.getEvaluacionWebBean().edit();
            
            this.getMensajeBean().setTipoIcono('I');
            this.getMensajeBean().setPagCerrar("dlgDocumentoEditDlg.hide()");
            this.getMensajeBean().setMensaje("El documento fue borrado");
            
            RequestContext.getCurrentInstance().update("frmUser:pArchivo");

            
            

        } catch (Exception ex) {
            this.getMensajeBean().setTipoIcono('E');
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());

        } finally {
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) {

        System.out.println("entro al archivo");
       
        try {
            
            System.out.println("entro al archivo2: "+event.getFile().getFileName());
            /*if (!event.getFile().getFileName().matches("\\S+")) {
                    throw new Exception("El nombre de archivo no puede tener espacios en blanco. ");
                }*/
            
            
            this.getDocumentoLstBean().setDocumento(new Documento());

            this.getDocumentoLstBean().getDocumento().setNombreArchivo(event.getFile().getFileName());
            this.getDocumentoLstBean().getDocumento().setContenidoArchivo(this.getFileContents(event.getFile().getInputstream()));
            
            

            System.out.println("paso; " + this.getDocumentoLstBean().getDocumento().getNombreArchivo());
            //d
            /*this.getArchivoBean().getArchivo().setNombre(
                    event.getFile().getFileName());*/

            
            
  
            //this.getArchivoLstBean().setContenidoArchivo(this.getFileContents(event.getFile().getInputstream()));

           // this.getArchivoWeb().setNombre(event.getFile().getFileName());

            //this.getArchivoLstBean().getLstArchivo().add(this.archivoBean.getArchivo());

            //RequestContext context = RequestContext.getCurrentInstance();
            //context.update("frmPri:dtArchivo");
        } catch (Exception ex) {
            this.getMensajeBean().setTipoIcono('E');
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
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
