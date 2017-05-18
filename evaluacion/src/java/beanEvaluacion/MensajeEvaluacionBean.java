/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.EvaluacionWeb;
import entidades.proyecto.evaluacion.RN.EvaluacionWebRNLocal;
import entidades.proyecto.evaluacion.RN.MensajeEvaluacionRNLocal;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.context.RequestContext;

/**
 *
 * @author hugo
 */
@ManagedBean(name = "mensajeEvaluacionBean")
@SessionScoped
public class MensajeEvaluacionBean implements Serializable {

    /**
     * Creates a new instance of MensajeEvaluacionBean
     */
    private int cantMensajesNoLeidos;
    private String mensaje;
    private List<EvaluacionWeb> listaEvaluacionesWeb=new ArrayList<EvaluacionWeb>();
    @EJB
    private MensajeEvaluacionRNLocal mensajeEvaluacionRNLocal;
    @EJB
    private EvaluacionWebRNLocal evaluacionWebRNLocal;
    @ManagedProperty("#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }
    
    public List<EvaluacionWeb> getListaEvaluacionesWeb() {
        return listaEvaluacionesWeb;
    }

    public void setListaEvaluacionesWeb(List<EvaluacionWeb> listaEvaluacionesWeb) {
        this.listaEvaluacionesWeb = listaEvaluacionesWeb;
    }
    
    

    public int getCantMensajesNoLeidos() {
        return cantMensajesNoLeidos;
    }

    public void setCantMensajesNoLeidos(int cantMensajesNoLeidos) {
        this.cantMensajesNoLeidos = cantMensajesNoLeidos;
    }
    
    
    public MensajeEvaluacionBean() {
    }

    @PostConstruct
    public void init() {
        cantMensajesNoLeidos=0;
        cargarMensajesNoLeidos();
        
        }

    public void cargarMensajesNoLeidos() {
        cantMensajesNoLeidos=0;
        RequestContext context = RequestContext.getCurrentInstance();
        try {
            this.setListaEvaluacionesWeb(evaluacionWebRNLocal.findAllByEvaluador(evaluadorLoginBean.getEvaluador().getId()));
            System.out.println("Mostrando evaluacionesWEbfacADE:  "+this.getListaEvaluacionesWeb());
            
        } catch (Exception ex) {
            Logger.getLogger(MensajeEvaluacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(EvaluacionWeb evaluacionWeb:this.getListaEvaluacionesWeb()){
            for(BloqueEvaluado bloqueEvaluado:evaluacionWeb.getBloquesEvaluados()){
                cantMensajesNoLeidos=cantMensajesNoLeidos+mensajeEvaluacionRNLocal.contarNoLeidos(bloqueEvaluado);
                System.out.println("cantidad mensajes no leidos"+cantMensajesNoLeidos);
                
            }
        }
        System.out.println("cantidad de no leidos::::"+this.getCantMensajesNoLeidos());
        this.setMensaje("Foro de Evaluaciones ("+this.getCantMensajesNoLeidos()+" No leídos)");
        context.update(":frmUser:mIMensaje");

        
    }
    
}
