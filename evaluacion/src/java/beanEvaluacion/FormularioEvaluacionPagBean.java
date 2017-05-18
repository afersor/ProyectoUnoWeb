/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

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
public class FormularioEvaluacionPagBean {

    private CalificacionGlobal calificacionGlobalSelect;
    private CalificacionWeb calificacionWebSelect;
    private HtmlInputHidden hihContenidoBLoqueCalificacion;

    private HtmlInputHidden hihContenidoBLoque;

    private HtmlInputHidden hihBLoque;

    private int posBloque = -1;
    private Long idBloque;

    @ManagedProperty("#{formularioEvaluacionPagLstBean}")
    private FormularioEvaluacionPagLstBean formularioEvaluacionPagLstBean;

    @ManagedProperty("#{calificacionWebLstBean}")
    private CalificacionWebLstBean calificacionWebLstBean;

    @ManagedProperty("#{calificacionGlobalLstBean}")
    private CalificacionGlobalLstBean calificacionGlobalLstBean;

    @ManagedProperty(value = "#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;

    @ManagedProperty("#{evaluacionWebBean}")
    private EvaluacionWebBean evaluacionWebBean;

    @ManagedProperty("#{evaluacionWebLstBean}")
    private EvaluacionWebLstBean evaluacionWebLstBean;

    @ManagedProperty("#{bloqueEvaluadoLstBean}")
    private BloqueEvaluadoLstBean bloqueEvaluadoLstBean;

    @ManagedProperty("#{bloqueLstBean}")
    private BloqueLstBean bloqueLstBean;

    @ManagedProperty("#{contenidoBloqueLstBean}")
    private ContenidoBloqueLstBean contenidoBloqueLstBean;

    @ManagedProperty(value = "#{investigadorLoginBean}")
    private EvaluadorLoginBean investigadorLoginBean;

    @ManagedProperty("#{generarReportesBean}")
    private GenerarReportesBean generarReportesBean;

    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;

    public FormularioEvaluacionPagBean() {
    }

    public GenerarReportesBean getGenerarReportesBean() {
        return generarReportesBean;
    }

    public void setGenerarReportesBean(GenerarReportesBean generarReportesBean) {
        this.generarReportesBean = generarReportesBean;
    }

    public EvaluacionWebLstBean getEvaluacionWebLstBean() {
        return evaluacionWebLstBean;
    }

    public void setEvaluacionWebLstBean(EvaluacionWebLstBean evaluacionWebLstBean) {
        this.evaluacionWebLstBean = evaluacionWebLstBean;
    }

    public FormularioEvaluacionPagLstBean getFormularioEvaluacionPagLstBean() {
        return formularioEvaluacionPagLstBean;
    }

    public void setFormularioEvaluacionPagLstBean(FormularioEvaluacionPagLstBean formularioEvaluacionPagLstBean) {
        this.formularioEvaluacionPagLstBean = formularioEvaluacionPagLstBean;
    }

    public CalificacionGlobalLstBean getCalificacionGlobalLstBean() {
        return calificacionGlobalLstBean;
    }

    public void setCalificacionGlobalLstBean(CalificacionGlobalLstBean calificacionGlobalLstBean) {
        this.calificacionGlobalLstBean = calificacionGlobalLstBean;
    }

    public CalificacionWebLstBean getCalificacionWebLstBean() {
        return calificacionWebLstBean;
    }

    public void setCalificacionWebLstBean(CalificacionWebLstBean calificacionWebLstBean) {
        this.calificacionWebLstBean = calificacionWebLstBean;
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

    public EvaluacionWebBean getEvaluacionWebBean() {
        return evaluacionWebBean;
    }

    public void setEvaluacionWebBean(EvaluacionWebBean evaluacionWebBean) {
        this.evaluacionWebBean = evaluacionWebBean;
    }

    public CalificacionGlobal getCalificacionGlobalSelect() {
        return calificacionGlobalSelect;
    }

    public void setCalificacionGlobalSelect(CalificacionGlobal calificacionGlobalSelect) {
        this.calificacionGlobalSelect = calificacionGlobalSelect;
    }

    public CalificacionWeb getCalificacionWebSelect() {
        return calificacionWebSelect;
    }

    public void setCalificacionWebSelect(CalificacionWeb calificacionWebSelect) {
        this.calificacionWebSelect = calificacionWebSelect;
    }

    public HtmlInputHidden getHihContenidoBLoqueCalificacion() {
        return hihContenidoBLoqueCalificacion;
    }

    public void setHihContenidoBLoqueCalificacion(HtmlInputHidden hihContenidoBLoqueCalificacion) {
        this.hihContenidoBLoqueCalificacion = hihContenidoBLoqueCalificacion;
    }

    public BloqueEvaluadoLstBean getBloqueEvaluadoLstBean() {
        return bloqueEvaluadoLstBean;
    }

    public void setBloqueEvaluadoLstBean(BloqueEvaluadoLstBean bloqueEvaluadoLstBean) {
        this.bloqueEvaluadoLstBean = bloqueEvaluadoLstBean;
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

    public ContenidoBloqueLstBean getContenidoBloqueLstBean() {
        return contenidoBloqueLstBean;
    }

    public void setContenidoBloqueLstBean(ContenidoBloqueLstBean contenidoBloqueLstBean) {
        this.contenidoBloqueLstBean = contenidoBloqueLstBean;
    }

    public MensajeBean getMensajeBean() {
        return mensajeBean;
    }

    public void setMensajeBean(MensajeBean mensajeBean) {
        this.mensajeBean = mensajeBean;
    }

    public BloqueLstBean getBloqueLstBean() {
        return bloqueLstBean;
    }

    public void setBloqueLstBean(BloqueLstBean bloqueLstBean) {
        this.bloqueLstBean = bloqueLstBean;
    }

    public String optenerContenidoBloque(Bloque bloque) {

        System.out.println("Bloque id: " + bloque.getId() + " = " + idBloque);
        System.out.println("Bloque id: " + bloque.getDescripcion() + " = " + idBloque);
        if (idBloque != bloque.getId()) {
            idBloque = bloque.getId();
            posBloque = -1;
            System.out.println("Entro : " + idBloque + " - " + posBloque);
        }
        posBloque += 1;

        System.out.println("cantidad bloques: " + bloque.getLstContenidoBloque() + " " + posBloque);
        return bloque.getLstContenidoBloque().get(posBloque).getDescripcion();
    }//fin optenerContenidoBloque

    public void eventChange(ValueChangeEvent event) {

        System.out.println("Entro");

        String sIdBoton = ((SelectOneRadio) event.getComponent()).getId();

        Long idBloque = Long.parseLong(String.valueOf(this.getHihBLoque().getValue()));

        Long idContenidoBLoque = null;

        int pos = -1;
        int tamanio = this.getFormularioEvaluacionPagLstBean().getEvaluacionWebSelect().getBloquesEvaluados().size();

        for (int i = 0; i < tamanio; i++) {
            if (this.getFormularioEvaluacionPagLstBean().getEvaluacionWebSelect().getBloquesEvaluados().get(i).
                    getBloque().getId() == idBloque) {
                pos = i;
            }//fin if
        }//fin for

        System.out.println("posicion: " + pos);

        BloqueEvaluado bloqueEvaluadoAux = this.getFormularioEvaluacionPagLstBean().getEvaluacionWebSelect().getBloquesEvaluados().get(pos);

        if (!sIdBoton.equals("sorCGB")) {

            idContenidoBLoque = Long.parseLong(String.valueOf(this.getHihContenidoBLoque().getValue()));

            int posDE = -1;
            int tamanioDE = bloqueEvaluadoAux.getDetallesEvaluados().size();
            for (int i = 0; i < tamanioDE; i++) {
                if (bloqueEvaluadoAux.getDetallesEvaluados().get(i).getContenidoBloque().getId() == idContenidoBLoque) {
                    posDE = i;
                }//fin if
            }//fin for

            bloqueEvaluadoAux.getDetallesEvaluados().get(posDE).setCalificacion((CalificacionWeb) event.getNewValue());

            /*DetalleEvaluado detalleEvaluadoAux = new DetalleEvaluado();
             detalleEvaluadoAux.setContenidoBloque(new ContenidoBloque());
             detalleEvaluadoAux.getContenidoBloque().setId(idContenidoBLoque);
             detalleEvaluadoAux.getContenidoBloque().setDescripcion(contenidoBLoqueDescripcion);

             detalleEvaluadoAux.setCalificacion((CalificacionWeb) event.getNewValue());*/
            /*if (posDE == -1) {
             this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado().get(pos).getDetallesEvaluados().add(detalleEvaluadoAux);
             } else {*/
            //this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado().get(pos).getDetallesEvaluados().get(posDE).setCalificacion((CalificacionWeb) event.getNewValue());
        }//fin if

             //PARA VER LA SALIDA
        /*System.out.println("-------------------");
         for(BloqueEvaluado be : this.getFormularioEvaluacionPagLstBean().getEvaluacionWebSelect().getBloquesEvaluados()){
         System.out.println("Bloque: " + be.getBloque().getDescripcion());
         System.out.println("Detalle");
         for(DetalleEvaluado de : be.getDetallesEvaluados()){
                
         System.out.println("ContenidoBloque: " + de.getContenidoBloque().getDescripcion());
         System.out.println("Calificacion: " + de.getCalificacion().getNombre());
                
         }//fin for
         System.out.println("Calificacion global: " + be.getCalificacion().getNombre());
         }//fin for*/
    }//fin eventChange

    /*this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado().get(pos).getDetallesEvaluados().remove(posDE);
     this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado().get(pos).getDetallesEvaluados().add(posDE, detalleEvaluadoAux);
     //}//fin if-else

     }else{
     this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado().get(pos).setCalificacion((CalificacionWeb) event.getNewValue());
     }//fin else-if
            
  
            
     }//fin if-else
        
        
     //PARA VER LA SALIDA
     System.out.println("-------------------");
     for(BloqueEvaluado be : this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado()){
     System.out.println("Bloque: " + be.getBloque().getId());
     System.out.println("Detalle");
     for(DetalleEvaluado de : be.getDetallesEvaluados()){
     System.out.println("Calificacion: " + de.getCalificacion().getNombre());
     System.out.println("ContenidoBloque: " + de.getContenidoBloque().getId());
     }//fin for
     System.out.println("Calificacion global: " + be.getCalificacion().getNombre());
     }//fin for
        

     //System.out.println("event: " + ((CalificacionWeb) event.getNewValue()).getBloque());
        
     }//fin eventChange
    
     /*public void onTabChange(TabChangeEvent event) { 
     System.out.println("evento: " +  event.getTab().getId());
     //buscar el contenido del bloque
     try{
     this.getContenidoBloqueLstBean().findAllByBloque((Bloque)event.getData());
            
     System.out.println("datos: " + this.getContenidoBloqueLstBean().getLstContenidoBloque());
     } catch (Exception ex) {
     this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
     RequestContext.getCurrentInstance().update("frmUser:dMensaje");
     RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
     }
     }//fin onTabChange*/
    public void entrarPag() {
        try {
            this.bloqueLstBean.findBloques();
        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin entrarPag

    public void guardar(Boolean finaliza) {
        try {

            //falta relacionr el proyecto
            /*for(BloqueEvaluado be : getBloqueEvaluadoLstBean().getLstBloqueEvaluado()){
             be.setDetallesEvaluados(null);
             }*/
            System.out.println("Proyecto: " + this.getEvaluacionWebBean().getEvaluacionWeb().getProyecto());
            System.out.println("Proyecto: " + this.getEvaluacionWebBean().getEvaluacionWeb().getProyecto());

            this.getEvaluacionWebBean().setEvaluacionWeb(this.getFormularioEvaluacionPagLstBean().getEvaluacionWebSelect());

            if (finaliza) {

                for (BloqueEvaluado be : this.getEvaluacionWebBean().getEvaluacionWeb().getBloquesEvaluados()) {
                    System.out.println("Bloque: " + be.getBloque().getId());
                    System.out.println("Detalle");

                    for (DetalleEvaluado de : be.getDetallesEvaluados()) {
                        if (de.getCalificacion() == null) {
                            throw new Exception("No calificó el contenido del bloque '"
                                    + de.getContenidoBloque().getDescripcion() + "'");
                        }//fin if
                    }//fin for

                    if (be.getCalificacion() == null) {
                        throw new Exception("No completo la califición global del bloque '"
                                + be.getBloque().getDescripcion() + "'");
                    }//fin if

                }//fin for

                if (this.getEvaluacionWebBean().getEvaluacionWeb().getCalificacionGlobal() == null) {
                    throw new Exception("No completo la calificación global total del proyecto");
                }//fin if
                //
                if(!this.getEvaluacionWebBean().calificacionVerificada(this.getEvaluacionWebBean().getEvaluacionWeb())){
                   throw new Exception("Calificacion diferente de la existente, por favor contáctese a través del foro para determinar la calificacion"); 
                }

                this.getEvaluacionWebBean().getEvaluacionWeb().setFinalizado(Boolean.TRUE);
                int pos = this.getEvaluacionWebLstBean().getLstEvaluacionWeb().indexOf(
                        this.getEvaluacionWebBean().getEvaluacionWeb());

                System.out.println("posicion: " + pos);

                this.getEvaluacionWebLstBean().getLstEvaluacionWeb().remove(pos);
                this.getEvaluacionWebLstBean().getLstEvaluacionWeb().add(pos,
                        this.getEvaluacionWebBean().getEvaluacionWeb());
            }//fin if

            if (!finaliza && this.getEvaluacionWebBean().getEvaluacionWeb().getFinalizado()) {
                throw new Exception("No puede realizar cambios en el proyecto. Ya fue finalizado");
            }//fin if
            //verificar calificacion que sea la misma
            this.getEvaluacionWebBean().edit();

            this.getMensajeBean().setMensaje("El dato fue guardado");
            this.getMensajeBean().setPagCerrar("dlgFormularioEvaluacion.hide()");
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().update("frmUser:dtProyecto");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin guardar

    public void verVistaPrevia() {
        /* Collections.sort(this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado());
        
         for(BloqueEvaluado be : this.getBloqueEvaluadoLstBean().getLstBloqueEvaluado()){
         Collections.sort(be.getDetallesEvaluados());
         }//fin for*/

        RequestContext.getCurrentInstance().execute("dlgFormularioEvaluacionVistaPrevia.show()");
    }//fin vistaPrevia

    public void entrar(EvaluacionWeb e) {
        try {
            System.out.println("proyecto: " + e.getProyecto());
            System.out.println("bloque: " + e.getBloquesEvaluados().size());
            this.getFormularioEvaluacionPagLstBean().setEvaluacionWebSelect(e);

            this.bloqueLstBean.findBloques();
            //Collections.sort(this.getBloqueLstBean().getLstBloque());
            this.getCalificacionWebLstBean().findAll();
            this.getCalificacionWebLstBean().cargarSI();
            //this.getBloqueEvaluadoLstBean().setLstBloqueEvaluado(new ArrayList<BloqueEvaluado>());
            this.getCalificacionGlobalLstBean().cargarSI();
            //this.getBloqueEvaluadoLstBean().buscarTodos();

        } catch (Exception ex) {
            this.getMensajeBean().setMensaje("Error. " + ex.getMessage());
            RequestContext.getCurrentInstance().update("frmUser:dMensaje");
            RequestContext.getCurrentInstance().execute("dlgMensaje.show()");
        }
    }//fin entrar

    public void generarReporte(int tipoReporte) {

        try {

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

            System.out.println("id evaluacion: " + this.getEvaluacionWebBean().getEvaluacionWeb().getId());

            hm.put("idEvaluacionWeb", this.getFormularioEvaluacionPagLstBean().getEvaluacionWebSelect().getId());
            
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
        }

    }//fin imprimirCaratulaReporte
}
