package beanConvocatoria;

import entidades.localidad.Departamento;
import entidades.localidad.Provincia;
import entidades.proyectoWeb.Ubicacion;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

@ManagedBean
@RequestScoped
public class UbicacionEditDlgBean {

    private String textBoton;
    private char accionBtn;
    private Boolean campoEditable;
    private String icono;
    
    @ManagedProperty("#{ubicacionBean}")
    private UbicacionBean ubicacionBean;
    
    @ManagedProperty("#{ubicacionLstBean}")
    private UbicacionLstBean ubicacionLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;

    public UbicacionEditDlgBean() {
    }
    

    public UbicacionLstBean getUbicacionLstBean() {
        return ubicacionLstBean;
    }

    public void setUbicacionLstBean(UbicacionLstBean ubicacionLstBean) {
        this.ubicacionLstBean = ubicacionLstBean;
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

    public UbicacionBean getUbicacionBean() {
        return ubicacionBean;
    }

    public void setUbicacionBean(UbicacionBean ubicacionBean) {
        this.ubicacionBean = ubicacionBean;
    }

    public Boolean isCampoEditable() {
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

    public char getAccionBtn() {
        return accionBtn;
    }

    public void setAccionBtn(char accionBtn) {
        this.accionBtn = accionBtn;
    }

    public void setBtnSelect(ActionEvent e) {
        
        
        CommandButton btnSelect = (CommandButton) e.getSource();
                
        if (btnSelect.getId().equals("cbUbicacionCreate")) {
            this.setAccionBtn('C');
            this.setTextBoton("Guardar");
            this.getUbicacionBean().setUbicacion(new Ubicacion());
            RequestContext.getCurrentInstance().update(":frmUser:dUbicacionEditDlg");
        } else if (btnSelect.getId().equals("cbUbicacionDelete")) {
            this.setAccionBtn('D');
            this.setCampoEditable(Boolean.FALSE);
            this.setTextBoton("Eliminar");
        } else if (btnSelect.getId().equals("cbUbicacionEdit")) {
            this.setAccionBtn('M');
            this.setTextBoton("Modificar");
        }
        
        RequestContext.getCurrentInstance().execute("dlgUbicacionEditDlg.show();");
    }


    public void agregar() {
        String mensaje = "";
        try {
            
            
            if(ubicacionBean.getUbicacion().getLocalidad()==null){
                throw new Exception("Debe seleccionar la localidad");
            }
            
            if(ubicacionBean.getUbicacion().getLatitud() == 0){
                throw new Exception("Debe ingresar la latitud");
            }
            
            if(ubicacionBean.getUbicacion().getLongitud()== 0){
                throw new Exception("Debe ingresar la longitud");
            }
            //this.getUbicacionBean().create();           
            
            System.out.println("Paso 1");
            if(this.getUbicacionLstBean().getLstUbicacion() == null){
                this.getUbicacionLstBean().setLstUbicacion(new ArrayList<Ubicacion>());
            }//fin if
            
            System.out.println("Paso 2");
            
            //validar si hay una igual cargada
            for(Ubicacion u : this.getUbicacionLstBean().getLstUbicacion()){
                if(this.getUbicacionBean().getUbicacion().getLocalidad() == u.getLocalidad() &&
                        this.getUbicacionBean().getUbicacion().getLatitud() == u.getLatitud() &&
                        this.getUbicacionBean().getUbicacion().getLongitud() == u.getLongitud()){
                    throw new Exception("Ya esta cargada la localidad con las cordenadas ingresadas");
                }//fin if
            }//fin for
            
            System.out.println("Paso 3");
            //actualizar la tabla
            this.getUbicacionLstBean().getLstUbicacion().add(this.getUbicacionBean().getUbicacion());
            
            mensaje = "Los datos fueron guardados";
            RequestContext.getCurrentInstance().update("frmUser:dtUbicacion");

        } catch (Exception ex) {
            mensaje = "Error: "+ex.getMessage();
        } finally {
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }

    public void edit() {
        /*String mensaje = "";
        try {
            this.getUbicacionBean().edit();
            
            //actualizar la tabla
            int pos = this.getUbicacionLstBean().getLstUbicacion().indexOf(this.getUbicacionBean().getUbicacion());
            this.getUbicacionLstBean().getLstUbicacion().remove(this.getUbicacionBean().getUbicacion());
            this.getUbicacionLstBean().getLstUbicacion().add(pos, this.getUbicacionBean().getUbicacion());
            
            mensaje = "Los datos fueron modificados";
            RequestContext.getCurrentInstance().update("frmUser:dtUbicacion");
            this.getMensajeBean().setTipoIcono('I');;
            this.getMensajeBean().setPagCerrar("PF('dlgUbicacionEditDlg').hide();");
        } catch (Exception ex) {
            this.getMensajeBean().setTipoIcono('E');
            mensaje = "Error: " + ex.getMessage();
        } finally {
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgMensaje').show();");
        }*/
    }

    public void delete() {
        /*String mensaje = "";
        try {
            this.getUbicacionBean().remove();

            System.out.println("elementos: " + this.getUbicacionLstBean().getLstUbicacion());
            //actualizar la tabla
            this.getUbicacionLstBean().getLstUbicacion().remove(this.getUbicacionBean().getUbicacion());
            
            System.out.println("elementos2: " + this.getUbicacionLstBean().getLstUbicacion());
            
            mensaje = "Los datos fueron borrados";
            RequestContext.getCurrentInstance().update("frmUser:dtUbicacion");
            this.getMensajeBean().setTipoIcono('I');
            this.getMensajeBean().setPagCerrar("PF('dlgUbicacionEditDlg').hide();");
        } catch (Exception ex) {
            this.getMensajeBean().setTipoIcono('E');
            mensaje = "Error: " + ex.getMessage();
        } finally {
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgMensaje').show();");
        }*/
    }
    
    

}
