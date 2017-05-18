/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.persona.Telefono;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;


/**
 *
 * @author diego
 */

@ManagedBean
@RequestScoped
public class TelefonoFindDlgBean {

    private Telefono telefono;
    
    private int tipo;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{telefonoLstBean}")
    private TelefonoLstBean telefonoLstBean;
    
    @ManagedProperty("#{tipoTelefonoLstBean}")
    private TipoTelefonoLstBean tipoTelefonoLstBean;
    
    public TelefonoFindDlgBean() {
        telefono = new Telefono();
    }

    public TipoTelefonoLstBean getTipoTelefonoLstBean() {
        return tipoTelefonoLstBean;
    }

    public void setTipoTelefonoLstBean(TipoTelefonoLstBean tipoTelefonoLstBean) {
        this.tipoTelefonoLstBean = tipoTelefonoLstBean;
    }
    
    public TelefonoLstBean getTelefonoLstBean() {
        return telefonoLstBean;
    }

    public void setTelefonoLstBean(TelefonoLstBean telefonoLstBean) {
        this.telefonoLstBean = telefonoLstBean;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
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
    
    public void init(int tipo){
        //cargar tipoTelefono
        try {

            this.getTipoTelefonoLstBean().findTipoTelefonos();
            this.getTipoTelefonoLstBean().cargarSITipoTelefonos();
            
            this.setTipo(tipo);

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin init
    
    
    public void definirComponentesActualizar() {
        try {

            if (this.getTelefono().getNumero().isEmpty()) {
                throw new Exception("Debe ingresar el número.");
            }//fin if

            RequestContext context = RequestContext.getCurrentInstance();

            switch (this.getTipo()) {
                case 0:

                    if (this.getTelefonoLstBean().getLstTelefono() == null) {
                        this.getTelefonoLstBean().setLstTelefono(new ArrayList<Telefono>());
                    }//fin if

                    for (Telefono t : this.getTelefonoLstBean().getLstTelefono()) {
                        if (t.getNumero().trim().toLowerCase().equals(this.getTelefono().getNumero().trim().toLowerCase())) {
                            throw new Exception("El teléfono ya fue ingresado.");
                        }//fin if
                    }//fin for

                    this.getTelefonoLstBean().getLstTelefono().add(this.getTelefono());


                    context.update("frmUser:dtTelefono");
                    break;

            }//fin switch

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar
    
    
}
