/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

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
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP() != null){
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getAntecedentes()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getAntecedentes().isEmpty()){
                return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getObjetivoGral()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getObjetivoGral().isEmpty()){
                return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getObjetivoEspecificoHipotesis()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getObjetivoEspecificoHipotesis().isEmpty()){
                return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getRelevanciaProblema()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getRelevanciaProblema().isEmpty()){
            return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getMetodologia()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getMetodologia().isEmpty()){
            return "Con Datos";
            }
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getCronogramaTrabajo()==null){
            return "Sin Datos";
        }else{
           if(!this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getCronogramaTrabajo().isEmpty()){
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
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP()!=null){
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getCapacitacionFormacionRH()==null){
            return "Sin Datos";
        }else{
            if(!this.getProyectoWebBean().getProyectoWeb().getProyectoWebFGP().getCapacitacionFormacionRH().isEmpty()){
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
    
    public String obtenerEstadoPagVIII(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getBibliografia() != null &&  
                !this.getProyectoWebBean().getProyectoWeb().getBibliografia().isEmpty()){
            System.out.println("Entro al if");
            return "Con Datos";
        }//fin if
        
        return "Sin Datos";
    }//fin if
    
    public String obtenerEstadoPagIX(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti() == null){
            return "Sin Datos";
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getEticoSeguridad() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getComprendeInvestigacionHumana() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getEstudioFarmaTecno() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getEstudioClinQuiruBasi() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getEstudioEpideSociaPsico()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getEquipamientoMedico()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getEquipamientoImgRadia()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getUsoHistoClinica()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getUsoMuestBiolog() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getEstudioComunAborig() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebAspEti().getInformePlanInv() != null){
            return "Con Datos";
        }//fin if
        
        return "Sin Datos";
    }//fin if
    
    public String obtenerEstadoPagX(){
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg() == null){
            return "Sin Datos";
        }
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getIncluyeTareaCampo() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getCuentraProfesional() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getExisteComiteSegBioseg() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getRiesgosFisicos() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getSustanciasQuimicas()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getSustancias()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getCampanaExtraccion()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getRiesgosBiologicos()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getNivelSeguridadInstalaciones()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getAprobadoComite()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getRealizaInmunizacion()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getAdvertenciaRiesgoMujeres()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getExisteGestionResiduos()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getPersonalCapacitadoPrevencion()!= null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getCantPersEspacioTrabajo() != null){
            return "Con Datos";
        }//fin if
        
        if(this.getProyectoWebBean().getProyectoWeb().getProyectoWebSegSaludBioseg().getMtsCantPersonas() != null){
            return "Con Datos";
        }//fin if
        
        return "Sin Datos";
    }//fin if
}
