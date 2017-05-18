/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import com.sun.faces.taglib.html_basic.InputHiddenTag;
import entidades.persona.Evaluador;
import entidades.proyecto.Proyecto;
import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.EvaluacionWeb;
import entidades.proyecto.evaluacion.MensajeEvaluacion;
import entidades.proyecto.evaluacion.RN.BloqueEvaluadoRNLocal;
import entidades.proyecto.evaluacion.RN.EvaluacionWebRNLocal;
import entidades.proyecto.evaluacion.RN.EvaluadorRNLocal;
import entidades.proyecto.evaluacion.RN.MensajeEvaluacionRNLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.event.ActionEvent;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import recursos.MensajeBean;

/**
 *
 * @author hugo
 */
@ManagedBean(name = "foroEvaluacionPagBean")
@SessionScoped
public class foroEvaluacionPagBean {

    /**
     * Creates a new instance of FormularioEvaluacionPagBean
     */
    @ManagedProperty("#{bloqueLstBean}")
    private BloqueLstBean bloqueLstBean;
    @ManagedProperty("#{bloqueEvaluadoLstBean}")
    private BloqueEvaluadoLstBean bloqueEvaluadoLstBean;
    @ManagedProperty("#{contenidoBloqueLstBean}")
    private ContenidoBloqueLstBean contenidoBloqueLstBean;
    @ManagedProperty("#{mensajeBean}")
    private MensajeBean mensajeBean;
    @ManagedProperty("#{bloqueEvaluadoBean}")
    private BloqueEvaluadoBean bloqueEvaluadoBean;
    @ManagedProperty("#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    @ManagedProperty("#{evaluacionWebLstBean}")
    private EvaluacionWebLstBean evaluacionWebLstBean;
    @ManagedProperty("#{mensajeEvaluacionBean}")
    private MensajeEvaluacionBean mensajeEvaluacionBean;
    private CommandButton botonSeleccionado;
    private String tipoOperacionMensaje;
    private Long idBloque;
    private CommandButton cbAgregarMensajeBloque1;
    private HtmlInputHidden ihBloque;
    private MensajeEvaluacion mensajeEvaluacion;
    private BloqueEvaluado bloqueEvaluado;
    @EJB
    private BloqueEvaluadoRNLocal bloqueEvaluadoRNLocal;
    @EJB
    private MensajeEvaluacionRNLocal mensajeEvaluacionRNLocal;
    @EJB
    private EvaluadorRNLocal evaluadorRNLocal;
    @EJB
    private EvaluacionWebRNLocal evaluacionWebRNLocal;
    private DataTable dtBloque;
    private Evaluador evaluador;
    private Proyecto proyecto;
    private EvaluacionWeb evaluacionWeb;
    private String sOcultarAcordinPanel = "false";
    private boolean renderedAcordionPanel;
    private List<EvaluacionWeb> listaEvaluacionesWeb = new ArrayList<>();

    public foroEvaluacionPagBean() {
    }

    public boolean isRenderedAcordionPanel() {
        return renderedAcordionPanel;
    }

    public void setRenderedAcordionPanel(boolean renderedAcordionPanel) {
        this.renderedAcordionPanel = renderedAcordionPanel;
    }

    public MensajeEvaluacionBean getMensajeEvaluacionBean() {
        return mensajeEvaluacionBean;
    }

    public void setMensajeEvaluacionBean(MensajeEvaluacionBean mensajeEvaluacionBean) {
        this.mensajeEvaluacionBean = mensajeEvaluacionBean;
    }

    public List<EvaluacionWeb> getListaEvaluacionesWeb() {
        return listaEvaluacionesWeb;
    }

    public void setListaEvaluacionesWeb(List<EvaluacionWeb> listaEvaluacionesWeb) {
        this.listaEvaluacionesWeb = listaEvaluacionesWeb;
    }

    public EvaluacionWebLstBean getEvaluacionWebLstBean() {
        return evaluacionWebLstBean;
    }

    public void setEvaluacionWebLstBean(EvaluacionWebLstBean evaluacionWebLstBean) {
        this.evaluacionWebLstBean = evaluacionWebLstBean;
    }

    public EvaluacionWeb getEvaluacionWeb() {
        return evaluacionWeb;
    }

    public String getsOcultarAcordinPanel() {
        return sOcultarAcordinPanel;
    }

    public void setsOcultarAcordinPanel(String sOcultarAcordinPanel) {
        this.sOcultarAcordinPanel = sOcultarAcordinPanel;
    }

    public void setEvaluacionWeb(EvaluacionWeb evaluacionWeb) {
        this.evaluacionWeb = evaluacionWeb;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public DataTable getDtBloque() {
        return dtBloque;
    }

    public void setDtBloque(DataTable dtBloque) {
        this.dtBloque = dtBloque;
    }

    public BloqueEvaluado getBloqueEvaluado() {
        return bloqueEvaluado;
    }

    public void setBloqueEvaluado(BloqueEvaluado bloqueEvaluado) {
        this.bloqueEvaluado = bloqueEvaluado;
    }

    @PostConstruct
    public void init() {
        tipoOperacionMensaje = "Alta";
        proyecto = new Proyecto();
        evaluacionWeb = new EvaluacionWeb();
        evaluacionWeb.setBloquesEvaluados(new ArrayList<BloqueEvaluado>());
        bloqueEvaluado = new BloqueEvaluado();
        mensajeEvaluacion = new MensajeEvaluacion();
        
        try {
            this.setListaEvaluacionesWeb(evaluacionWebRNLocal.findAllByEvaluador(evaluadorLoginBean.getEvaluador().getId()));
            System.out.println("Mostrando evaluacionesWEb:  " + this.getListaEvaluacionesWeb());
            //bloqueEvaluado.setMensajes(new ArrayList<MensajeEvaluacion>());
        } catch (Exception ex) {
            Logger.getLogger(foroEvaluacionPagBean.class.getName()).log(Level.SEVERE, null, ex);
        }
//        mensajeEvaluacion.setEvaluador(evaluadorLoginBean.getEvaluador());
//        mensajeEvaluacion.setBloqueEvaluado(bloqueEvaluado);
//        mensajeEvaluacion.setFecha(new Date());
//        mensajeEvaluacion.setLeido(false);
//        mensajeEvaluacion.setMensaje("hollaaa");
//        try {
//            mensajeEvaluacionRNLocal.create(mensajeEvaluacion);
//        } catch (Exception ex) {
//            Logger.getLogger(foroEvaluacionPagBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public BloqueEvaluadoBean getBloqueEvaluadoBean() {
        return bloqueEvaluadoBean;
    }

    public void setBloqueEvaluadoBean(BloqueEvaluadoBean bloqueEvaluadoBean) {
        this.bloqueEvaluadoBean = bloqueEvaluadoBean;
    }

    public MensajeEvaluacion getMensajeEvaluacion() {
        return mensajeEvaluacion;
    }

    public void setMensajeEvaluacion(MensajeEvaluacion mensajeEvaluacion) {
        this.mensajeEvaluacion = mensajeEvaluacion;
    }

    public BloqueEvaluadoLstBean getBloqueEvaluadoLstBean() {
        return bloqueEvaluadoLstBean;
    }

    public void setBloqueEvaluadoLstBean(BloqueEvaluadoLstBean bloqueEvaluadoLstBean) {
        this.bloqueEvaluadoLstBean = bloqueEvaluadoLstBean;
    }

    public HtmlInputHidden getIhBloque() {
        return ihBloque;
    }

    public void setIhBloque(HtmlInputHidden ihBloque) {
        this.ihBloque = ihBloque;
    }

    public CommandButton getCbAgregarMensajeBloque1() {
        return cbAgregarMensajeBloque1;
    }

    public void setCbAgregarMensajeBloque1(CommandButton cbAgregarMensajeBloque1) {
        this.cbAgregarMensajeBloque1 = cbAgregarMensajeBloque1;
    }

    public Long getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(Long idBloque) {
        this.idBloque = idBloque;
    }

    public String getTipoOperacionMensaje() {
        return tipoOperacionMensaje;
    }

    public void setTipoOperacionMensaje(String tipoOperacionMensaje) {
        this.tipoOperacionMensaje = tipoOperacionMensaje;
    }

    public CommandButton getBotonSeleccionado() {
        return botonSeleccionado;
    }

    public void setBotonSeleccionado(CommandButton botonSeleccionado) {
        this.botonSeleccionado = botonSeleccionado;
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

    public void accion() {

        RequestContext context = RequestContext.getCurrentInstance();
        this.setMensajeEvaluacion(new MensajeEvaluacion());
        this.setIdBloque(Long.parseLong(String.valueOf(this.getIhBloque().getValue())));
        try {
            this.setBloqueEvaluado(bloqueEvaluadoRNLocal.buscarPorId(idBloque));
            //bloqueEvaluado=this.getBloqueEvaluadoBean().buscarBloqueEvaluado(this.getIdBloque());
        } catch (Exception ex) {
            Logger.getLogger(foroEvaluacionPagBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.execute("dlgMensajeBloque.show();");

    }

    public void verMensaje() throws Exception {
        // Actualizamos el contador de mensajes
        mensajeEvaluacionBean.cargarMensajesNoLeidos();
        //
        RequestContext context = RequestContext.getCurrentInstance();
        this.setMensajeEvaluacion((MensajeEvaluacion) this.getDtBloque().getRowData());
        this.getMensajeEvaluacion().setLeido(Boolean.TRUE);
        mensajeEvaluacionRNLocal.modificar(this.getMensajeEvaluacion());
        context.update(":frmUser:dlgVerMensajeBloque");
        context.execute("dlgVerMensajeBloque.show();");

    }

    public void guardarMensaje() throws Exception {
        this.getMensajeEvaluacion().setBloqueEvaluado(bloqueEvaluado);
        this.setEvaluador(this.getEvaluadorLoginBean().getEvaluador());
        this.getMensajeEvaluacion().setEvaluador(this.getEvaluador());
        this.getMensajeEvaluacion().setLeido(Boolean.FALSE);
        this.getMensajeEvaluacion().setFecha(new Date());
        System.out.println("el Evaluador" + this.getEvaluador());
        try {
            mensajeEvaluacionRNLocal.create(this.getMensajeEvaluacion());
        } catch (Exception ex) {
            Logger.getLogger(MensajeEvaluacionDlgBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getBloqueEvaluado().getMensajes().add(mensajeEvaluacion);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("dlgMensajeBloque.hide();");
        bloqueEvaluadoLstBean.buscarTodos();
        context.update(":frmUser:apForoEvaluacion");
        this.setMensajeEvaluacion(new MensajeEvaluacion());

    }

    public void cerrarVerMensaje() throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("dlgVerMensajeBloque.hide();");
    }

    public void cargarAcordionPanel(EvaluacionWeb eval) {
        sOcultarAcordinPanel = "visible;";
        this.setRenderedAcordionPanel(Boolean.TRUE);
        this.setEvaluacionWeb(eval);
        System.out.println("rendered: " + this.isRenderedAcordionPanel());
//        //System.out.println(evaluacionWeb.getBloquesEvaluados().get(0).getId());
        RequestContext context = RequestContext.getCurrentInstance();
        context.update(":frmUser:apForoEvaluacion");
        context.update(":frmUser:apForoEvaluacion:dtBloque");

    }

    public void renderizarAcordionPanel(boolean flag) {
        this.setRenderedAcordionPanel(flag);
        RequestContext context = RequestContext.getCurrentInstance();
        context.update(":frmUser:apForoEvaluacion");
    }
}
