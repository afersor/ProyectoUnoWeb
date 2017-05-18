/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.localidad.Localidad;
import entidades.persona.CorreoElectronico;
import entidades.persona.Domicilio;
import entidades.persona.Persona;
import entidades.persona.Telefono;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author hugo
 */
@ManagedBean(name ="investigadorDatosPersonalesPagBean")
@RequestScoped
public class InvestigadorDatosPersonalesPagBean {

    /**
     * Creates a new instance of InvestigadorDatosPersonalesPagBean
     */
    
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    private Investigador investigador;
    @ManagedProperty(value = "#{investigadorBean}")
    private InvestigadorBean investigadorBean;
    @ManagedProperty(value = "#{domicilioBean}")
    private domicilioBean domicilioBean;
    @ManagedProperty(value = "#{listadoEmailsBean}")
    private ListadoEmailsBean listadoEmailsBean;
    @ManagedProperty(value = "#{listadoTelefonosBean}")
    private ListadoTelefonosBean listadoTelefonosBean;
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    public InvestigadorDatosPersonalesPagBean() {
    //this.setInvestigador(investigadorLoginBean.getInvestigador());
       
    }
    @PostConstruct
    public void init() {
        investigador=new Investigador();
        this.setInvestigador(investigadorLoginBean.getInvestigador());
//       investigador=new Investigador();
//        investigador.setPersona(new Persona());
//        investigador.getPersona().setDomicilio(new Domicilio());
//        investigador.getPersona().getDomicilio().setLocalidad(new Localidad());
        
//        System.out.println("Inv Datos personales:"+this.getInvestigador().getPersona().getDomicilio().getLocalidad());
    }

    public ListadoEmailsBean getListadoEmailsBean() {
        return listadoEmailsBean;
    }

    public void setListadoEmailsBean(ListadoEmailsBean listadoEmailsBean) {
        this.listadoEmailsBean = listadoEmailsBean;
    }

    public ListadoTelefonosBean getListadoTelefonosBean() {
        return listadoTelefonosBean;
    }

    public void setListadoTelefonosBean(ListadoTelefonosBean listadoTelefonosBean) {
        this.listadoTelefonosBean = listadoTelefonosBean;
    }
    
    public Bean.domicilioBean getDomicilioBean() {
        return domicilioBean;
    }

    public void setDomicilioBean(Bean.domicilioBean domicilioBean) {
        this.domicilioBean = domicilioBean;
    }
    
    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    public InvestigadorBean getInvestigadorBean() {
        return investigadorBean;
    }

    public void setInvestigadorBean(InvestigadorBean investigadorBean) {
        this.investigadorBean = investigadorBean;
    }
    public void cargarDlgDatosPersonales(){
        this.setInvestigador(null);
        try {
            this.setInvestigador(investigadorRNLocal.findById(investigadorLoginBean.getInvestigador().getId()));
        } catch (Exception ex) {
            Logger.getLogger(InvestigadorDatosPersonalesPagBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        domicilioBean.cargarDomicilio();
        listadoEmailsBean.setLstCorreosElectronicos(investigador.getPersona().getCorreosElectronicos());
        listadoTelefonosBean.setLstTelefonos(investigador.getPersona().getTelefonos());
    }
    
    public void modificarInvestigador(){
        investigador.getPersona().setCorreosElectronicos(listadoEmailsBean.getLstCorreosElectronicos());
        investigador.getPersona().setTelefonos(listadoTelefonosBean.getLstTelefonos());
        investigadorBean.edit(investigador);
                
    }
    public void cancelarModificacion(){
        System.out.println("Entro a cancelar modificacion ");
        this.setInvestigador(null);
        try {
            this.setInvestigador(investigadorRNLocal.findById(investigadorLoginBean.getInvestigador().getId()));
        } catch (Exception ex) {
            Logger.getLogger(InvestigadorDatosPersonalesPagBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("investig numero calle"+this.getInvestigador().getPersona().getDomicilio().getNumero());
        listadoEmailsBean.setLstCorreosElectronicos(new ArrayList<CorreoElectronico>());
        listadoTelefonosBean.setLstTelefonos(new ArrayList<Telefono>());
        listadoEmailsBean.setDtCorreo(new DataTable());
        listadoTelefonosBean.setDtTelefono(new DataTable());
        domicilioBean.setDomicilio(new Domicilio());
    }
}
