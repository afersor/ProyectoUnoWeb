/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.CampoAplicacion;
import java.util.ArrayList;
import java.util.List;
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
public class CampoAplicacionFindDlgBean {

    private String descripcion;
    
    private List<CampoAplicacion> lstCampoAplicacionSelect;
    
    private int tipo;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{campoAplicacionLstBean}")
    private CampoAplicacionLstBean campoAplicacionLstBean;
    
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    public CampoAplicacionFindDlgBean() {
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    public List<CampoAplicacion> getLstCampoAplicacionSelect() {
        return lstCampoAplicacionSelect;
    }

    public void setLstCampoAplicacionSelect(List<CampoAplicacion> lstCampoAplicacionSelect) {
        this.lstCampoAplicacionSelect = lstCampoAplicacionSelect;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public CampoAplicacionLstBean getCampoAplicacionLstBean() {
        return campoAplicacionLstBean;
    }

    public void setCampoAplicacionLstBean(CampoAplicacionLstBean campoAplicacionLstBean) {
        this.campoAplicacionLstBean = campoAplicacionLstBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //para saber que tengo que actualizar en la pantalla
    public void definirComponentesActualizar(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getCamposAplicacion() == null){
            this.getProyectoWebBean().getProyectoWeb().setCamposAplicacion(new ArrayList<CampoAplicacion> ());
        }//fin if
        
        switch(this.getTipo()){
            
            case 0: 
                
                for(CampoAplicacion ca : this.getLstCampoAplicacionSelect()){
                    if(!this.getProyectoWebBean().getProyectoWeb().getCamposAplicacion().contains(ca)){
                        this.getProyectoWebBean().getProyectoWeb().getCamposAplicacion().add(ca);
                    }//fin
                }//fin for
                
                //actualizar
                RequestContext context = RequestContext.getCurrentInstance();  
                context.update("frmUser:dtCampoAplicacion"); 
                break;
        }//fin switch
        
    }//fin definirComponentesActualizar
    
    public void findLikeDescripcion(){
         try {

             if (!this.getDescripcion().isEmpty()) {
                 this.getCampoAplicacionLstBean().findLikeDescripcion(descripcion);

             } else {
                 this.getMensajeBean().setMensaje("Error. No ingreso un valor a buscar.");
                 RequestContext.getCurrentInstance().update("frmUser:dMensaje");
                 RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
             }
         } catch (Exception ex) {
             this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
             RequestContext.getCurrentInstance().update("frmUser:dMensaje");
             RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
         }

    }//fin findLikeNombreApellido
}
