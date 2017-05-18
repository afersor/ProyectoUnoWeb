/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;


import entidades.localidad.Departamento;
import entidades.localidad.Provincia;
import entidades.proyectoWeb.Ubicacion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;



/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class UbicacionDlgBean {

    private Provincia provinciaSelect;
    private Departamento departamentoSelect;
    
    private Ubicacion ubicacion;
    
    private int pantalla;
    
    @ManagedProperty("#{provinciaLstBean}")
    private ProvinciaLstBean provinciaLstBean;
    
    @ManagedProperty("#{departamentoLstBean}")
    private DepartamentoLstBean departamentoLstBean;
    
    @ManagedProperty("#{localidadLstBean}")
    private LocalidadLstBean localidadLstBean;
    
    @ManagedProperty("#{ubicacionLstBean}")
    private UbicacionLstBean ubicacionLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    
    public UbicacionDlgBean() {
        ubicacion = new Ubicacion();
    }

    public UbicacionLstBean getUbicacionLstBean() {
        return ubicacionLstBean;
    }

    public void setUbicacionLstBean(UbicacionLstBean ubicacionLstBean) {
        this.ubicacionLstBean = ubicacionLstBean;
    }
    
    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
   
    
    public ProvinciaLstBean getProvinciaLstBean() {
        return provinciaLstBean;
    }

    public void setProvinciaLstBean(ProvinciaLstBean provinciaLstBean) {
        this.provinciaLstBean = provinciaLstBean;
    }

    
    public int getPantalla() {
        return pantalla;
    }

    public void setPantalla(int pantalla) {
        this.pantalla = pantalla;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public LocalidadLstBean getLocalidadLstBean() {
        return localidadLstBean;
    }

    public void setLocalidadLstBean(LocalidadLstBean localidadLstBean) {
        this.localidadLstBean = localidadLstBean;
    }

    public Departamento getDepartamentoSelect() {
        return departamentoSelect;
    }

    public void setDepartamentoSelect(Departamento departamentoSelect) {
        this.departamentoSelect = departamentoSelect;
    }
    
    public DepartamentoLstBean getDepartamentoLstBean() {
        return departamentoLstBean;
    }

    public void setDepartamentoLstBean(DepartamentoLstBean departamentoLstBean) {
        this.departamentoLstBean = departamentoLstBean;
    }

    public Provincia getProvinciaSelect() {
        return provinciaSelect;
    }

    public void setProvinciaSelect(Provincia provinciaSelect) {
        this.provinciaSelect = provinciaSelect;
    }
    
    public void cargarDepartamentos(){
        String mensaje = "";
        try{
            this.getDepartamentoLstBean().cargarSIByProvincia(provinciaSelect);
        } catch (Exception ex) {
            mensaje = "Error: " + ex.getMessage();
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgMensaje').show();");
        }
    }//fin cargarDepartamentos
    
    public void cargarLocalidades(){
        String mensaje = "";
        try{
            this.getLocalidadLstBean().cargarSIByLocalidad(departamentoSelect);
        } catch (Exception ex) {
            mensaje = "Error: " + ex.getMessage();
            this.getMensajeBean().setMensaje(mensaje);
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgMensaje').show();");
        }
    }//fin cargarLocalidades
    
    public void entrar(int pantalla) throws Exception{
            
        
       /* if(ubicacion.getId() != null){
            this.setUbicacion(ubicacion);

            this.setDepartamentoSelect(ubicacion.getLocalidad().getDepartamento());

            this.setProvinciaSelect(ubicacion.getLocalidad().getDepartamento().getProvincia());
            //cargar los departamentos de la provincia seleccionada
            
            departamentoLstBean.cargarSIByProvincia(provinciaSelect);
            localidadLstBean.cargarSIByLocalidad(departamentoSelect);
        }else{*/
            provinciaLstBean.findProvincias();
            provinciaLstBean.cargarSIProvincias();
        //}
        
        this.setPantalla(pantalla);
        RequestContext.getCurrentInstance().update("frmUser:dUbicacionEditDlg");
        RequestContext.getCurrentInstance().execute("dlgUbicacionEditDlg.show();");
        
    }//fin entrar
    
    public void aceptar(){
        

        System.out.println("pantalla: " + pantalla + " domici: " + ubicacion);
        switch(pantalla){
            case 1: //convocatoria-pantallaI
                //this.getPersonaBean().getPersona().setUbicacion(ubicacion);
                RequestContext.getCurrentInstance().update("frmUser:pgUbicacionPED");
                break;
                
            
        }//fin switch
        
        RequestContext.getCurrentInstance().execute("dlgUbicacionEditDlg.hide();");
        
        
        
        /*RequestContext.getCurrentInstance().update("frmAdmin:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");*/
    }//fin salir
    
    //es la localizacion
    public void quitarUbicacion(Ubicacion u) {
        
        //validar si hay una igual cargada
        int cant = this.getUbicacionLstBean().getLstUbicacion().size();
        for(int  i = 0; i < cant; i++){
            if (u.getLocalidad() == this.getUbicacionLstBean().getLstUbicacion().get(i).getLocalidad()
                    && u.getLatitud() == this.getUbicacionLstBean().getLstUbicacion().get(i).getLatitud()
                    && u.getLongitud() == this.getUbicacionLstBean().getLstUbicacion().get(i).getLongitud()) {
                this.getUbicacionLstBean().getLstUbicacion().remove(i);
                break;
            }//fin if
        }//fin for
    }//fin quitarUnidadInvestigacion
}
