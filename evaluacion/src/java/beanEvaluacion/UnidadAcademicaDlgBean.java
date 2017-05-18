/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class UnidadAcademicaDlgBean {

    /**
     * Creates a new instance of UnidadAcademicaDlgBean
     */
    @ManagedProperty("#{unidadAcademicaBean}")
    private UnidadAcademicaBean unidadAcademicaBean;
    
    @ManagedProperty("#{unidadAcademicaLstBean}")
    private UnidadAcademicaLstBean unidadAcademicaLstBean;
    
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    
    public UnidadAcademicaDlgBean() {
    }

    public UnidadAcademicaLstBean getUnidadAcademicaLstBean() {
        return unidadAcademicaLstBean;
    }

    public void setUnidadAcademicaLstBean(UnidadAcademicaLstBean unidadAcademicaLstBean) {
        this.unidadAcademicaLstBean = unidadAcademicaLstBean;
    }
    
    public UnidadAcademicaBean getUnidadAcademicaBean() {
        return unidadAcademicaBean;
    }

    public void setUnidadAcademicaBean(UnidadAcademicaBean unidadAcademicaBean) {
        this.unidadAcademicaBean = unidadAcademicaBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }
        
    public void create(){
        try {
            
            this.getUnidadAcademicaBean().create();
            
            System.out.println("paso 1");
            this.getUnidadAcademicaLstBean().findUnidadesAcademicas();
            System.out.println("paso 2");
            this.getUnidadAcademicaLstBean().cargarSIUnidadesAcademicas();
            System.out.println("paso 3");
            
            this.getMensajeBean().setMensaje("El dato fue guardado.");
            System.out.println("paso 4");
            RequestContext.getCurrentInstance().update("frmUser:somUnidadAcademicaCreate");
            System.out.println("paso 5");
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            System.out.println("paso 6");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
            System.out.println("paso 7");
                 
        } catch (Exception ex) {
            
            System.out.println("Error: " + ex);
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
             RequestContext.getCurrentInstance().update("frmUser:dMensaje");
             RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin create
}
