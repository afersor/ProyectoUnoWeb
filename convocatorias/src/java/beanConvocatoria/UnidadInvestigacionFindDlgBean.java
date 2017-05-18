/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.UnidadInvestigacion;
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
public class UnidadInvestigacionFindDlgBean {

    private String descripcion;
    
    private UnidadInvestigacion unidadInvestigacionSelect;
    
    private List<UnidadInvestigacion> lstUnidadInvestigacionSelect;
    
    @ManagedProperty("#{unidadInvestigacionLstBean}")
    private UnidadInvestigacionLstBean unidadInvestigacionLstBean;
    
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    private int tipo;
    
    public UnidadInvestigacionFindDlgBean() {
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }

    public List<UnidadInvestigacion> getLstUnidadInvestigacionSelect() {
        return lstUnidadInvestigacionSelect;
    }

    public void setLstUnidadInvestigacionSelect(List<UnidadInvestigacion> lstUnidadInvestigacionSelect) {
        this.lstUnidadInvestigacionSelect = lstUnidadInvestigacionSelect;
    } 

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UnidadInvestigacion getUnidadInvestigacionSelect() {
        return unidadInvestigacionSelect;
    }

    public void setUnidadInvestigacionSelect(UnidadInvestigacion unidadInvestigacionSelect) {
        this.unidadInvestigacionSelect = unidadInvestigacionSelect;
    }

    public UnidadInvestigacionLstBean getUnidadInvestigacionLstBean() {
        return unidadInvestigacionLstBean;
    }

    public void setUnidadInvestigacionLstBean(UnidadInvestigacionLstBean unidadInvestigacionLstBean) {
        this.unidadInvestigacionLstBean = unidadInvestigacionLstBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
    
    public void abrirDialog(){
        
        try{

            if(!this.getProyectoWebBean().getProyectoWeb().getLocalizaciones().isEmpty()){
            
                throw new Exception("Solo puede agregar un dato");
            }//fin if
            
            RequestContext.getCurrentInstance().execute("dlgFindUnidadInvestigacion.show()");
        }catch(Exception ex){

            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
 
    }//fin abrirDialog
    
    //para saber que tengo que actualizar en la pantalla
    public void definirComponentesActualizar(){
        
        if (this.getProyectoWebBean().getProyectoWeb().getLocalizaciones() == null) {
            this.getProyectoWebBean().getProyectoWeb().setLocalizaciones(new ArrayList<UnidadInvestigacion>());
        }//fin if
        
        switch(this.getTipo()){
            
            case 0: //pagina proyecto
                
                for(UnidadInvestigacion ui : this.getLstUnidadInvestigacionSelect()){
                    if(!this.getProyectoWebBean().getProyectoWeb().getLocalizaciones().contains(ui)){
                        this.getProyectoWebBean().getProyectoWeb().getLocalizaciones().add(ui);
                    }//fin
                }//fin for
                
                //actualiza.
                RequestContext context = RequestContext.getCurrentInstance();  
                context.update("frmUser:dtUnidadInvestigacion"); 
                break;

        }//fin switch
        
    }//fin definirComponentesActualizar
    
    public void findLikeDescripcion(){
         try {

             if (!this.getDescripcion().isEmpty()) {
                 this.getUnidadInvestigacionLstBean().findLikeDescripcion(descripcion);

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
