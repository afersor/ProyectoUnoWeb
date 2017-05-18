/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.CorreoElectronico;
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
@ManagedBean(name = "listadoEmailsBean")
@SessionScoped
public class ListadoEmailsBean {

    private List<CorreoElectronico> lstCorreosElectronicos;
    private int iTipoBoton;
    private List<SelectItem> listaTipoTelefonos;
    private DataTable dtCorreo;
    private CorreoElectronico correoElectronico;
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    public CorreoElectronico getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(CorreoElectronico correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public DataTable getDtCorreo() {
        return dtCorreo;
    }

    public void setDtCorreo(DataTable dtCorreo) {
        this.dtCorreo = dtCorreo;
    }

      

    /**
     * Creates a new instance of listadoTelefonosBean
     */
    public ListadoEmailsBean() {
    }

    @PostConstruct
    private void init() {
        this.setLstCorreosElectronicos(new ArrayList<CorreoElectronico>());
        
        this.setCorreoElectronico(new CorreoElectronico());
        //cargarTelefonos();
        //cargarTipoTelefonos();
    }

    public List<CorreoElectronico> getLstCorreosElectronicos() {
        return lstCorreosElectronicos;
    }

    public void setLstCorreosElectronicos(List<CorreoElectronico> lstCorreosElectronicos) {
        this.lstCorreosElectronicos = lstCorreosElectronicos;
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


    public void quitarTablaCorreosElectronicos(CorreoElectronico ce) {
       System.out.println("correo: " + ce);
        
        int tamanio = lstCorreosElectronicos.size();
        for(int i=0; i < tamanio; i++){

            if(lstCorreosElectronicos.get(i).getDireccion().equals(ce.getDireccion())){
                lstCorreosElectronicos.remove(i);
                i=tamanio;
            }//fin if
        }//fin for
        
        
    }//fin quitarTablaTelefonos
    public void cargarTablaCorreosElectronicos() {
        System.out.println("Correo electronico: " + correoElectronico);
        try {
            if (correoElectronico.getDireccion().isEmpty()) {

                throw new Exception("No ingreso la dirección de correo");

            }
            lstCorreosElectronicos.add(correoElectronico);
            this.setCorreoElectronico(new CorreoElectronico());
            
            RequestContext.getCurrentInstance().execute("dlgEmail.hide();");
            
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Error: " + ex.getMessage(), null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
       
    }
    public List<CorreoElectronico> getCorreosInvestigadorLogin(){
        this.setLstCorreosElectronicos(this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getPersona().getCorreosElectronicos());
        return this.getLstCorreosElectronicos();
    }



    
}
