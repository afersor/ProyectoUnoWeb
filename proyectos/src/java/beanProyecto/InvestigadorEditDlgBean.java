/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.persona.CorreoElectronico;
import entidades.persona.DocumentoIdentidad;
import entidades.persona.Domicilio;
import entidades.persona.Persona;
import entidades.persona.Telefono;
import entidades.persona.investigador.Investigador;
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
public class InvestigadorEditDlgBean {
 
    
    private Investigador investigador;
    
    @ManagedProperty("#{tipoDocumentoLstBean}")
    private TipoDocumentoLstBean tipoDocumentoLstBean;
    
    @ManagedProperty("#{sexoLstBean}")
    private SexoLstBean sexoLstBean;
    
    @ManagedProperty("#{provinciaLstBean}")
    private ProvinciaLstBean provinciLstBean;
    
    @ManagedProperty("#{tipoTelefonoLstBean}")
    private TipoTelefonoLstBean tipoTelefonoLstBean;
    
    @ManagedProperty("#{telefonoLstBean}")
    private TelefonoLstBean telefonoLstBean;
    
    @ManagedProperty("#{correoElectronicoLstBean}")
    private CorreoElectronicoLstBean correoElectronicoLstBean;
    
    @ManagedProperty("#{investigadorBean}")
    private InvestigadorBean investigadorBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;

    public InvestigadorEditDlgBean() {
        investigador = new Investigador();
        investigador.setPersona(new Persona());
        investigador.getPersona().setDocumentoIdentidad(new DocumentoIdentidad());
        investigador.getPersona().setDomicilio(new Domicilio());
    }

    public InvestigadorBean getInvestigadorBean() {
        return investigadorBean;
    }

    public void setInvestigadorBean(InvestigadorBean investigadorBean) {
        this.investigadorBean = investigadorBean;
    }

    public TelefonoLstBean getTelefonoLstBean() {
        return telefonoLstBean;
    }

    public void setTelefonoLstBean(TelefonoLstBean telefonoLstBean) {
        this.telefonoLstBean = telefonoLstBean;
    }

    public CorreoElectronicoLstBean getCorreoElectronicoLstBean() {
        return correoElectronicoLstBean;
    }

    public void setCorreoElectronicoLstBean(CorreoElectronicoLstBean correoElectronicoLstBean) {
        this.correoElectronicoLstBean = correoElectronicoLstBean;
    }
    

    public TipoTelefonoLstBean getTipoTelefonoLstBean() {
        return tipoTelefonoLstBean;
    }

    public void setTipoTelefonoLstBean(TipoTelefonoLstBean tipoTelefonoLstBean) {
        this.tipoTelefonoLstBean = tipoTelefonoLstBean;
    }
    
    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
    
    public ProvinciaLstBean getProvinciLstBean() {
        return provinciLstBean;
    }

    public void setProvinciLstBean(ProvinciaLstBean provinciLstBean) {
        this.provinciLstBean = provinciLstBean;
    }
    
    public SexoLstBean getSexoLstBean() {
        return sexoLstBean;
    }

    public void setSexoLstBean(SexoLstBean sexoLstBean) {
        this.sexoLstBean = sexoLstBean;
    }
    
    public TipoDocumentoLstBean getTipoDocumentoLstBean() {
        return tipoDocumentoLstBean;
    }

    public void setTipoDocumentoLstBean(TipoDocumentoLstBean tipoDocumentoLstBean) {
        this.tipoDocumentoLstBean = tipoDocumentoLstBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    public void ini(){
        try {
            //tipo documento
            this.getTipoDocumentoLstBean().findTipoDocumentos();
            this.getTipoDocumentoLstBean().cargarSITipoDocumentos();
            
            //sexo
            this.getSexoLstBean().findSexos();
            this.getSexoLstBean().cargarSISexos();
            
            //provincia
            this.getProvinciLstBean().findProvincias();
            this.getProvinciLstBean().cargarSIProvincias();
            
            //tipo telefonos
//            this.getTipoTelefonoLstBean().findTipoTelefonos();
//            this.getTipoTelefonoLstBean().cargarSITipoTelefonos();
//            
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin ini
    
    public void quitarTelefono(Telefono t){
        this.getTelefonoLstBean().getLstTelefono().remove(t);
    }//fin quitarTelefono
    
    public void quitarCorreoElectronico(CorreoElectronico ce){
        this.getCorreoElectronicoLstBean().getLstCorreoElectronico().remove(ce);
    }//fin quitarCorreoElectronico
    
    public void create(){
        

        String mensaje = "";
        try{
            this.getInvestigadorBean().create(investigador);
            
            mensaje = "El investigador fue guardado";
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }catch(Exception e){
            mensaje = "Error: " + e;
             this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update(":frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
        
    }//fin create
}
