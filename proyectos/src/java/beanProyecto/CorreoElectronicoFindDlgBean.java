/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.persona.CorreoElectronico;
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
public class CorreoElectronicoFindDlgBean {

    private CorreoElectronico correoElectronico;
    
    private int tipo;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{correoElectronicoLstBean}")
    private CorreoElectronicoLstBean correoElectronicoLstBean;
    
    
    public CorreoElectronicoFindDlgBean() {
        correoElectronico = new CorreoElectronico();
    }

    public CorreoElectronico getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(CorreoElectronico correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public CorreoElectronicoLstBean getCorreoElectronicoLstBean() {
        return correoElectronicoLstBean;
    }

    public void setCorreoElectronicoLstBean(CorreoElectronicoLstBean correoElectronicoLstBean) {
        this.correoElectronicoLstBean = correoElectronicoLstBean;
    }
    
    
    public void definirComponentesActualizar() {
        try {

            if (this.getCorreoElectronico().getDireccion().isEmpty()) {
                throw new Exception("Debe ingresar la dirección.");
            }//fin if

            RequestContext context = RequestContext.getCurrentInstance();

            switch (this.getTipo()) {
                case 0:

                    if (this.getCorreoElectronicoLstBean().getLstCorreoElectronico() == null) {
                        this.getCorreoElectronicoLstBean().setLstCorreoElectronico(new ArrayList<CorreoElectronico>());
                    }//fin if

                    for (CorreoElectronico ce : this.getCorreoElectronicoLstBean().getLstCorreoElectronico()) {
                        if (ce.getDireccion().trim().toLowerCase().equals(this.getCorreoElectronico().getDireccion().trim().toLowerCase())) {
                            throw new Exception("La dirección ya fue ingresada.");
                        }//fin if
                    }//fin for

                    this.getCorreoElectronicoLstBean().getLstCorreoElectronico().add(this.getCorreoElectronico());


                    context.update("frmUser:dtCorreoElectronico");
                    break;

            }//fin switch

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar
}
