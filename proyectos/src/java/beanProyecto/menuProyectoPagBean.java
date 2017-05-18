/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author diego
 */

@ManagedBean
@RequestScoped
public class menuProyectoPagBean {

    @ManagedProperty("#{proyectoWebBean}")
    private ProyectoWebBean proyectoWebBean;
    
    public menuProyectoPagBean() {
    }

    public ProyectoWebBean getProyectoWebBean() {
        return proyectoWebBean;
    }

    public void setProyectoWebBean(ProyectoWebBean proyectoWebBean) {
        this.proyectoWebBean = proyectoWebBean;
    }
        
    public String obtenerEstadoPagII(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getResumen()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getResumen().isEmpty()){
                return "Con Datos";
            }
        }
        
        if(!this.getProyectoWebBean().getProyectoWeb().getPalabrasClaves().isEmpty()){
            return "Con Datos";
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getTitle()==null){
            return "Sin Datos";
        }else{
           if(!this.getProyectoWebBean().getProyectoWeb().getTitle().isEmpty()){
            return "Con Datos";
        } 
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getSummary() == null){
            return "Sin Datos";
        }else{
           if(!this.getProyectoWebBean().getProyectoWeb().getSummary().isEmpty()){
            return "Con Datos";
            } 
        }
        
        if(!this.getProyectoWebBean().getProyectoWeb().getKeywords().isEmpty()){
            return "Con Datos";
        }//fin if
        
        return "Sin Datos";
        
    }//fin if
    
    public String obtenerEstadoPagIII(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP() != null){
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getAntecedentes()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getAntecedentes().isEmpty()){
                return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getObjetivoGral()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getObjetivoGral().isEmpty()){
                return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getObjetivoEspecificoHipotesis()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getObjetivoEspecificoHipotesis().isEmpty()){
                return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getRelevanciaProblema()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getRelevanciaProblema().isEmpty()){
            return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getMetodologia()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getMetodologia().isEmpty()){
            return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getCronogramaTrabajo()==null){
            return "Sin Datos";
        }else{
           if(!this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getCronogramaTrabajo().isEmpty()){
                return "Con Datos";
            } 
        }
        }
        
        return "Sin Datos";
    }//fin if
    
    public String obtenerEstadoPagIV(){
        
        if(!this.getProyectoWebBean().getProyectoWeb().getParticipacionesWeb().isEmpty()){
            return "Con Datos";
        }//fin if
        
        return "Sin Datos";
        
    }//fin if
    
    public String obtenerEstadoPagV(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWeb()!=null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getPresupuestoWebAnioUno()!=null){
            return "Con Datos";
        }//fin if
        
        if(!this.getProyectoWebBean().getProyectoWeb().getRecursosSubsidios().isEmpty()){
            return "Con Datos";
        }//fin if
        
        return "Sin Datos";
    }//fin if
    
    public String obtenerEstadoPagVI(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP()!=null){
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getCapacitacionFormacionRH()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoPidWebFGP().getCapacitacionFormacionRH().isEmpty()){
                return "Con Datos";
            }
        }
        }
        
        return "Sin Datos";
    }//fin if
    
    public String obtenerEstadoPagVII(){
        
        if(!this.getProyectoWebBean().getProyectoWeb().getLstArchivoWeb().isEmpty()){
            return "Con Datos";
        }//fin if
        
        return "Sin Datos";
    }//fin if
}
