/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.persona.Telefono;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@ManagedBean
@SessionScoped
public class ListadoTelefonosBean {

    //@EJB
    //private TelefonoRNLocal listadoTelefonosRNLocal;
    private List<Telefono> lstTelefonos;
    private int iTipoBoton;
    private List<SelectItem> listaTipoTelefonos;
    private DataTable dtTelefono;
    private Telefono telefono;
    @ManagedProperty(value = "#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    
    @ManagedProperty("#{tipoTelefonoLstBean}")
    private TipoTelefonoLstBean tipoTelefonoLstBean;

    public TipoTelefonoLstBean getTipoTelefonoLstBean() {
        return tipoTelefonoLstBean;
    }

    public void setTipoTelefonoLstBean(TipoTelefonoLstBean tipoTelefonoLstBean) {
        this.tipoTelefonoLstBean = tipoTelefonoLstBean;
    }   
        
    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
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
        try {
            this.setLstTelefonos(new ArrayList<Telefono>());
            
            this.setTelefono(new Telefono());
            this.getTipoTelefonoLstBean().findTipoTelefonos();
                this.getTipoTelefonoLstBean().cargarSITipoTelefonos();
            //cargarTipoTelefonos();
            //cargarTipoTelefonos();
        } catch (Exception ex) {
            Logger.getLogger(ListadoTelefonosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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


    public void quitarTablaTelefonos() {
        Telefono tel = (Telefono) this.getDtTelefono().getRowData();
        lstTelefonos.remove(tel);
        
    }//fin quitarTablaTelefonos
    public void cargarTablaTelefonos() {
        System.out.println("Telefonooo: "+telefono);
        lstTelefonos.add(telefono);
        this.setTelefono(new Telefono());
       
    }
    public List<Telefono> getTelefonosInvestigadorLogin(){
        System.out.println("Lista telefonoes INvestt"+this.getInvestigadorLoginBean().getInvestigador().getPersona().getTelefonos());
        
        //this.setLstTelefonos(new ArrayList<Telefono>());
        for(Telefono tel:this.getInvestigadorLoginBean().getInvestigador().getPersona().getTelefonos()){
            this.getLstTelefonos().add(tel);
        }
        //this.setLstTelefonos(this.getInvestigadorLoginBean().getInvestigador().getPersona().getTelefonos());
        return this.getLstTelefonos();
    }



    
}
