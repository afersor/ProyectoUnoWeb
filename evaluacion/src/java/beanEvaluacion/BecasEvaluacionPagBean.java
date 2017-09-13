/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.becas.PostulacionBeca;
import entidades.becas.evaluacion.BecasEvaluacionWeb;
import entidades.becas.evaluacion.BecasEvaluacionWebBecasItemEvaluar;
import entidades.becas.evaluacion.BecasItemCalificacion;
import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.CalificacionGlobal;
import entidades.proyecto.evaluacion.CalificacionWeb;
import entidades.proyecto.evaluacion.ContenidoBloque;
import entidades.proyecto.evaluacion.DetalleEvaluado;
import entidades.proyecto.evaluacion.EvaluacionWeb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import recursos.GenerarReportesBean;
import recursos.MensajeBean;

/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class BecasEvaluacionPagBean {

    private HtmlInputHidden hihContenidoBLoqueCalificacion;

    private HtmlInputHidden hihContenidoBLoque;

    private HtmlInputHidden hihBLoque;

    private int posBloque = -1;
    private Long idBloque;


    @ManagedProperty(value = "#{becasItemCalificacionLstBean}")
    private BecasItemCalificacionLstBean becasItemCalificacionLstBean;
    
    @ManagedProperty(value = "#{becasCalificacionGlobalLstBean}")
    private BecasCalificacionGlobalLstBean becasCalificacionGlobalLstBean;
    
    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;

    @ManagedProperty("#{becasEvaluacionWebBean}")
    private BecasEvaluacionWebBean becasEvaluacionWebBean;

    @ManagedProperty("#{becasEvaluacionWebLstBean}")
    private BecasEvaluacionWebLstBean becasEvaluacionWebLstBean;

    @ManagedProperty(value = "#{investigadorLoginBean}")
    private EvaluadorLoginBean investigadorLoginBean;

    @ManagedProperty("#{generarReportesBean}")
    private GenerarReportesBean generarReportesBean;

    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;

    public BecasEvaluacionPagBean() {
    }

    public BecasCalificacionGlobalLstBean getBecasCalificacionGlobalLstBean() {
        return becasCalificacionGlobalLstBean;
    }

    public void setBecasCalificacionGlobalLstBean(BecasCalificacionGlobalLstBean becasCalificacionGlobalLstBean) {
        this.becasCalificacionGlobalLstBean = becasCalificacionGlobalLstBean;
    }

    public BecasItemCalificacionLstBean getBecasItemCalificacionLstBean() {
        return becasItemCalificacionLstBean;
    }

    public void setBecasItemCalificacionLstBean(BecasItemCalificacionLstBean becasItemCalificacionLstBean) {
        this.becasItemCalificacionLstBean = becasItemCalificacionLstBean;
    }
    
    public GenerarReportesBean getGenerarReportesBean() {
        return generarReportesBean;
    }

    public void setGenerarReportesBean(GenerarReportesBean generarReportesBean) {
        this.generarReportesBean = generarReportesBean;
    }

    

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    public EvaluadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(EvaluadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    

    public HtmlInputHidden getHihContenidoBLoqueCalificacion() {
        return hihContenidoBLoqueCalificacion;
    }

    public void setHihContenidoBLoqueCalificacion(HtmlInputHidden hihContenidoBLoqueCalificacion) {
        this.hihContenidoBLoqueCalificacion = hihContenidoBLoqueCalificacion;
    }

   

    public HtmlInputHidden getHihBLoque() {
        return hihBLoque;
    }

    public void setHihBLoque(HtmlInputHidden hihBLoque) {
        this.hihBLoque = hihBLoque;
    }

    public HtmlInputHidden getHihContenidoBLoque() {
        return hihContenidoBLoque;
    }

    public void setHihContenidoBLoque(HtmlInputHidden hihContenidoBLoque) {
        this.hihContenidoBLoque = hihContenidoBLoque;
    }


    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public int getPosBloque() {
        return posBloque;
    }

    public void setPosBloque(int posBloque) {
        this.posBloque = posBloque;
    }

    public Long getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(Long idBloque) {
        this.idBloque = idBloque;
    }

    
    public BecasEvaluacionWebBean getBecasEvaluacionWebBean() {
        return becasEvaluacionWebBean;
    }

    public void setBecasEvaluacionWebBean(BecasEvaluacionWebBean becasEvaluacionWebBean) {
        this.becasEvaluacionWebBean = becasEvaluacionWebBean;
    }

    public BecasEvaluacionWebLstBean getBecasEvaluacionWebLstBean() {
        return becasEvaluacionWebLstBean;
    }

    public void setBecasEvaluacionWebLstBean(BecasEvaluacionWebLstBean becasEvaluacionWebLstBean) {
        this.becasEvaluacionWebLstBean = becasEvaluacionWebLstBean;
    }

    

     public void eventChange(ValueChangeEvent event) {


        String sIdBoton = ((SelectOneRadio) event.getComponent()).getId();
        
        System.out.println("Evento id: " + sIdBoton);

       
    }//fin eventChange
     

    public void guardar(Boolean finaliza) {
        
        try {
            
            if (this.getBecasEvaluacionWebLstBean().getBecasEvaluacionWebSelect().getFechaFinalizacion() != null) {
                throw new Exception("No puede realizar cambios. Ya fue finalizado");
            }//fin if


            if (finaliza) {
                int posicion = 1;
                for (BecasEvaluacionWebBecasItemEvaluar be : 
                        this.getBecasEvaluacionWebLstBean().getBecasEvaluacionWebSelect().getBecasEvaluacionWebBecasItemEvaluar()) {

                    
                        if (be.getBecasItemCalificacion() == null) {
                            throw new Exception("No calificó el item " + posicion);
                        }//fin if
            

                    
                    
                    posicion++;

                }//fin for

                if (this.getBecasEvaluacionWebLstBean().getBecasEvaluacionWebSelect().getBecasCalificacionGlobal() == null) {
                    throw new Exception("No completo la calificación global total de los item");
                }//fin if
                //

                this.getBecasEvaluacionWebLstBean().getBecasEvaluacionWebSelect().setFechaFinalizacion(new Date());
                
                int pos = this.getBecasEvaluacionWebLstBean().getLstBecasEvaluacionWeb().indexOf(
                        this.getBecasEvaluacionWebLstBean().getBecasEvaluacionWebSelect());

                System.out.println("posicion: " + pos);

                this.getBecasEvaluacionWebLstBean().getLstBecasEvaluacionWeb().remove(pos);
                this.getBecasEvaluacionWebLstBean().getLstBecasEvaluacionWeb().add(pos,
                        this.getBecasEvaluacionWebLstBean().getBecasEvaluacionWebSelect());
            }//fin if

            
            //verificar calificacion que sea la misma
            this.getBecasEvaluacionWebBean().edit();

            this.getMensajeBean().setMensaje("El dato fue guardado");
            this.getMensajeBean().setPagCerrar("dlgBecasEvaluacionWebDlg.hide()");
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().update("frmUser:dtBeca");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin guardar

    public void verVistaPrevia() {
        RequestContext.getCurrentInstance().execute("dlgFormularioEvaluacionVistaPrevia.show()");
    }//fin vistaPrevia

    public void entrar(BecasEvaluacionWeb e) {
        try {

            System.out.println("Item a evaluar: " + e.getBecasEvaluacionWebBecasItemEvaluar().get(0));
            this.getBecasEvaluacionWebLstBean().setBecasEvaluacionWebSelect(e);

            //cargar las calificacionesItem
            this.getBecasItemCalificacionLstBean().cargarSI();
            
            this.getBecasCalificacionGlobalLstBean().cargarSI();
            
            

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin entrar

    public void generarReporte(int tipoReporte) {

        /*try {

            HashMap hm = new HashMap();

            //ver si es una actuacion 
            String nombreReporte = "";

            switch (tipoReporte) {
                case 0: //vista previa
                    nombreReporte = "formularioEvaluacion.jasper";
                    hm.put("vista", "vp");
                    break;
                case 1: //reporte final
                    nombreReporte = "formularioEvaluacion.jasper";
                    hm.put("vista", "o");
                    break;
            }//fin switch

            System.out.println("Nombre reporte: " + nombreReporte);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("secyt-ejbPU");
            EntityManager em = emf.createEntityManager();
            String image = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/unca.jpg");
            hm.put("IMAGEN", image);
            //"JPA_ENTITY_MANAGER"
            hm.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, em);


            hm.put("idEvaluacionWeb", this.getFormularioBecasEvaluacionPagLstBean().getBecasEvaluacionWebSelect().getId());
            
            hm.put("institucion", 
                    this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().get(
                         this.getEvaluadorLoginBean().getEvaluador().getInvestigador().getDocencias().size()-1).getUniversidad().getDescripcion());

            this.getGenerarReportesBean().generar(hm, nombreReporte);
        } catch (Exception ex) {
            //mostrar mensaje
            this.getMensajeBean().setMensaje("Error: " + ex.getMessage());
            System.out.println(ex);
            RequestContext.getCurrentInstance().update("frmAdmin:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }*/

    }//fin imprimirCaratulaReporte
}
