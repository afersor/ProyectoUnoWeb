/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyectoPidWeb.RecursoSubsidioPid;
import java.util.ArrayList;
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
public class RecursoSubsidioFindDlgBean {

    private RecursoSubsidioPid recursoSubsidioPid;
    
    private int tipo;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    @ManagedProperty("#{entidadSubsidioLstBean}")
     private EntidadSubsidioLstBean entidadSubsidioLstBean;
    
    public RecursoSubsidioFindDlgBean() {
        recursoSubsidioPid = new RecursoSubsidioPid();
    }

    public EntidadSubsidioLstBean getEntidadSubsidioLstBean() {
        return entidadSubsidioLstBean;
    }

    public void setEntidadSubsidioLstBean(EntidadSubsidioLstBean entidadSubsidioLstBean) {
        this.entidadSubsidioLstBean = entidadSubsidioLstBean;
    }

    public RecursoSubsidioPid getRecursoSubsidio() {
        return recursoSubsidioPid;
    }

    public void setRecursoSubsidio(RecursoSubsidioPid recursoSubsidio) {
        this.recursoSubsidioPid = recursoSubsidio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
    
    public void init(int tipo){
        
        try {
            this.setTipo(tipo);

            this.getEntidadSubsidioLstBean().findEntidadesSubsidios();
            this.getEntidadSubsidioLstBean().cargarSIEntidadesSubsidios();

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
        
    }//fin init
    
    
    
     public void definirComponentesActualizar() {
        try {

            if (this.getRecursoSubsidio().getAnio() <= 0) {
                throw new Exception("Debe ingresar el año.");
            }//fin if
            
            if (this.getRecursoSubsidio().getNombreApellido().isEmpty()) {
                throw new Exception("Debe ingresar el Nombre y Apellido.");
            }//fin if
            
            if (this.getRecursoSubsidio().getEntidadSubsidio() == null) {
                throw new Exception("Debe seleccionar la entidad.");
            }//fin if
            
            if (this.getRecursoSubsidio().getMonto() == null) {
                throw new Exception("Debe ingresar el monto.");
            }//fin if

            RequestContext context = RequestContext.getCurrentInstance();

            switch (this.getTipo()) {
                case 0:

                    if (this.getProyectoWebBean().getProyectoWeb().getRecursosSubsidios() == null) {
                        this.getProyectoWebBean().getProyectoWeb().setRecursosSubsidios(new ArrayList<RecursoSubsidioPid>());
                    }//fin if


                    this.getProyectoWebBean().getProyectoWeb().getRecursosSubsidios().add(this.getRecursoSubsidio());


                    context.update("frmUser:dtRecursoSubsidio");
                    break;
            
            }//fin switch

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }

    }//fin definirComponentesActualizar
}//FIN CLASE
