/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.Proyecto;
import entidades.proyecto.evaluacion.EvaluacionWeb;
import entidades.proyecto.evaluacion.RN.EvaluacionWebRNLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author diego
 */
@ManagedBean
@RequestScoped
public class EvaluacionWebBean {

    private EvaluacionWeb evaluacionWeb;
    
    @EJB
    private EvaluacionWebRNLocal evaluacionWebRNLocal;
    
    public EvaluacionWebBean() {
        evaluacionWeb = new EvaluacionWeb();
        evaluacionWeb.setProyecto(new Proyecto());
    }

    public EvaluacionWeb getEvaluacionWeb() {
        return evaluacionWeb;
    }

    public void setEvaluacionWeb(EvaluacionWeb evaluacionWeb) {
        this.evaluacionWeb = evaluacionWeb;
    }
    
    public void create() throws Exception{
        evaluacionWebRNLocal.create(evaluacionWeb);
    }//fin create
    
    public void edit() throws Exception{
        evaluacionWebRNLocal.edit(evaluacionWeb);
    }//fin create
    public boolean calificacionVerificada(EvaluacionWeb evaluacionWeb) throws Exception{
        boolean flag=true;
        for (EvaluacionWeb ew:evaluacionWebRNLocal.findByProyecto(evaluacionWeb.getProyecto().getId())){
            if(ew.getCalificacionGlobal().compareTo(evaluacionWeb.getCalificacionGlobal())!=0){
                flag=false;
                
             
            }
        }
        return flag;
    }
}
