/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import entidades.localidad.Provincia;
import entidades.localidad.RN.DepartamentoRNLocal;
import entidades.localidad.RN.LocalidadRNLocal;
import entidades.localidad.RN.ProvinciaRNLocal;
import entidades.persona.Domicilio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.sound.midi.SysexMessage;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hugo
 */
@ManagedBean(name = "domicilioBean")
@SessionScoped
public class domicilioBean {

    //@EJB
    //private DomicilioRNLocal domicilioRNLocal;
    @EJB
    private ProvinciaRNLocal provinciaRNLocal;
    @EJB
    private DepartamentoRNLocal departamentoRNLocal;
    @EJB
    private LocalidadRNLocal localidadRNLocal;
    private List<SelectItem> listaPais;
    private List<SelectItem> listaProvincias;
    private List<SelectItem> listaDepartamentos;
    private List<SelectItem> listaLocalidades;
    private Domicilio domicilio;
    private Provincia provincia;
    private Departamento departamento;
    private Localidad localidad;
    private List<Domicilio> lstDomicilio;
    //para crear una localidad nueva
    private Localidad nuevaLocalidad;
    private String tipoOperacionLocalidad;
    private String stringLocalidad;
    private Departamento nuevoDepartamento;
    private String stringDepartamento;
    private String tipoOperacionDepartamento;
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    public Departamento getNuevoDepartamento() {
        return nuevoDepartamento;
    }

    public void setNuevoDepartamento(Departamento nuevoDepartamento) {
        this.nuevoDepartamento = nuevoDepartamento;
    }

    public String getTipoOperacionDepartamento() {
        return tipoOperacionDepartamento;
    }

    public void setTipoOperacionDepartamento(String tipoOperacionDepartamento) {
        this.tipoOperacionDepartamento = tipoOperacionDepartamento;
    }

    public String getStringDepartamento() {
        return stringDepartamento;
    }

    public void setStringDepartamento(String stringDepartamento) {
        this.stringDepartamento = stringDepartamento;
    }

    public String getStringLocalidad() {
        return stringLocalidad;
    }

    public void setStringLocalidad(String stringLocalidad) {
        this.stringLocalidad = stringLocalidad;
    }

    public Localidad getNuevaLocalidad() {
        return nuevaLocalidad;
    }

    public void setNuevaLocalidad(Localidad nuevaLocalidad) {
        this.nuevaLocalidad = nuevaLocalidad;
    }

    public String getTipoOperacionLocalidad() {
        return tipoOperacionLocalidad;
    }

    public void setTipoOperacionLocalidad(String tipoOperacionLocalidad) {
        this.tipoOperacionLocalidad = tipoOperacionLocalidad;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<SelectItem> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(List<SelectItem> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    public List<SelectItem> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<SelectItem> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<SelectItem> getListaLocalidades() {
        return listaLocalidades;
    }

    public void setListaLocalidades(List<SelectItem> listaLocalidades) {
        this.listaLocalidades = listaLocalidades;
    }

    public List<Domicilio> getLstDomicilio() {
        return lstDomicilio;
    }

    public void setLstDomicilio(List<Domicilio> lstDomicilio) {
        this.lstDomicilio = lstDomicilio;
    }

    /**
     * Creates a new instance of domicilioBean
     */
    /* public domicilioBean(Domicilio domicilio, DomicilioRNLocal domicilioRNLocal) {
     this.domicilio=domicilio;
     this.domicilioRNLocal=domicilioRNLocal;
     }*/
    public domicilioBean() {
    }

    @PostConstruct
    private void inicializarComponentes() {
        domicilio = new Domicilio();
        provincia = new Provincia();
        departamento = new Departamento();
        localidad = new Localidad();
        localidad.setDepartamento(new Departamento());
        departamento.setProvincia(new Provincia());

    }

    public void cargarProvincias() {
        try {

            listaProvincias = new ArrayList<SelectItem>();
            List<Provincia> provincias = provinciaRNLocal.findProvincias();
            for (Provincia prov : provincias) {
                listaProvincias.add(new SelectItem(prov, prov.toString()));
            }
        } catch (Exception ex) {

            Logger.getLogger(domicilioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarDepartamentos() {
        System.out.println("paso por departamentos");

        try {
            listaDepartamentos = new ArrayList<SelectItem>();

            for (Departamento depto : departamentoRNLocal.findDepartamentosByProvincia(provincia)) {
                listaDepartamentos.add(new SelectItem(depto, depto.toString()));

            }
            System.out.println("paso por departamentos con provincias: " + listaDepartamentos);
        } catch (Exception ex) {
            Logger.getLogger(domicilioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarLocalidades() {

        try {
            listaLocalidades = new ArrayList<SelectItem>();
            for (Localidad loc : localidadRNLocal.findLocalidadesByDpto(departamento)) {
                listaLocalidades.add(new SelectItem(loc, loc.toString()));

            }
        } catch (Exception ex) {
            Logger.getLogger(domicilioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarDomicilio() {
        cargarProvincias();
////        System.out.println("Personaaaaaaaa  "+this.getInvestigadorLoginBean().getInvestigador().getPersona().getDomicilio().getLocalidad().getDepartamento().getProvincia());
        try {
            this.setProvincia(this.getInvestigadorLoginBean().getInvestigador().getPersona().getDomicilio().getLocalidad().getDepartamento().getProvincia());
            this.cargarDepartamentos();
            this.setDepartamento(this.getInvestigadorLoginBean().getInvestigador().getPersona().getDomicilio().getLocalidad().getDepartamento());
            this.cargarLocalidades();
            this.setLocalidad(this.getInvestigadorLoginBean().getInvestigador().getPersona().getDomicilio().getLocalidad());
        } catch (Exception e) {

        }

    }
}
