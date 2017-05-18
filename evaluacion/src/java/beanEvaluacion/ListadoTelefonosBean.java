/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.Telefono;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hugo
 */
@ManagedBean(name = "listadoTelefonosBean")
@SessionScoped
public class ListadoTelefonosBean {

    //@EJB
    //private TelefonoRNLocal listadoTelefonosRNLocal;
    private List<Telefono> lstTelefonos;
    private int iTipoBoton;
    private List<SelectItem> listaTipoTelefonos;
    private DataTable dtTelefono;
    private Telefono telefono;
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    
    @ManagedProperty("#{tipoTelefonoLstBean}")
    private TipoTelefonoLstBean tipoTelefonoLstBean;

    public TipoTelefonoLstBean getTipoTelefonoLstBean() {
        return tipoTelefonoLstBean;
    }

    public void setTipoTelefonoLstBean(TipoTelefonoLstBean tipoTelefonoLstBean) {
        this.tipoTelefonoLstBean = tipoTelefonoLstBean;
    }

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public DataTable getDtTelefono() {
        return dtTelefono;
    }

    public void setDtTelefono(DataTable dtTelefono) {
        this.dtTelefono = dtTelefono;
    }

    /**
     * Creates a new instance of listadoTelefonosBean
     */
    public ListadoTelefonosBean() {
    }

    @PostConstruct
    private void init() {
        try{
            this.setLstTelefonos(new ArrayList<Telefono>());
        this.getTipoTelefonoLstBean().findTipoTelefonos();
                this.getTipoTelefonoLstBean().cargarSITipoTelefonos();
        this.setTelefono(new Telefono());
        }catch (Exception ex) {
            Logger.getLogger(ListadoTelefonosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //cargarTelefonos();
        //cargarTipoTelefonos();
    }

    public List<Telefono> getLstTelefonos() {
        return lstTelefonos;
    }

    public void setLstTelefonos(List<Telefono> lstTelefonos) {
        this.lstTelefonos = lstTelefonos;
    }

    public int getiTipoBoton() {
        return iTipoBoton;
    }

    public void setiTipoBoton(int iTipoBoton) {
        this.iTipoBoton = iTipoBoton;
    }

    public List<SelectItem> getListaTipoTelefonos() {
        return listaTipoTelefonos;
    }

    public void setListaTipoTelefonos(List<SelectItem> listaTipoTelefonos) {
        this.listaTipoTelefonos = listaTipoTelefonos;
    }


    public void quitarTablaTelefonos(Telefono tel) {
        //System.out.println("Seleccion: " + " - " + this.getDtTelefono().getRowIndex());
       //Telefono tel = (Telefono) this.getDtTelefono().getSelection();
        int tamanio = lstTelefonos.size();
        for(int i=0; i < tamanio; i++){
            System.out.println(" " + lstTelefonos.get(i).getNumero() + " = " + tel.getNumero());
            if(lstTelefonos.get(i).getNumero().equals(tel.getNumero())){
                lstTelefonos.remove(i);
                i=tamanio;
            }//fin if
        }//fin for
        
        RequestContext.getCurrentInstance().update(":frmUser:dtTelefonos");
        
    }//fin quitarTablaTelefonos
    public void cargarTablaTelefonos() {
        
        try {
            if (telefono.getNumero().isEmpty()) {
                throw new Exception("No ingreso el número de teléfono");
            }
            lstTelefonos.add(telefono);
            this.setTelefono(new Telefono());
            
            RequestContext.getCurrentInstance().execute("dlgTel.hide();");

        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
       
    }
    public List<Telefono> getTelefonosInvestigadorLogin(){
        System.out.println("Entro al get telefono: " + this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getPersona().getTelefonos());
        this.setLstTelefonos(this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getPersona().getTelefonos());
        return this.getLstTelefonos();
    }



    
}
