/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.persona.CorreoElectronico;
import entidades.persona.Telefono;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    
    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
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


    public void quitarTablaCorreosElectronicos() {
        CorreoElectronico correo = (CorreoElectronico) this.getDtCorreo().getRowData();
        lstCorreosElectronicos.remove(correo);
        
    }//fin quitarTablaTelefonos
    public void cargarTablaCorreosElectronicos() {
        lstCorreosElectronicos.add(correoElectronico);
        this.setCorreoElectronico(new CorreoElectronico());
       
    }
    public List<CorreoElectronico> getCorreosInvestigadorLogin(){
        this.setLstCorreosElectronicos(this.getInvestigadorLoginBean().getInvestigador().getPersona().getCorreosElectronicos());
        return this.getLstCorreosElectronicos();
    }



    
}
