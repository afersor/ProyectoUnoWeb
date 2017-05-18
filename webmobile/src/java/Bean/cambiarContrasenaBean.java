/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Recursos.Encrypter;
import entidades.persona.investigador.RN.ContrasenaRNLocal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class cambiarContrasenaBean {

    private String sContrasena;
    private String sContrasenaConf;
    
    @ManagedProperty("#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    
    @EJB
    private ContrasenaRNLocal contrasenaRNLocal;
    
    public cambiarContrasenaBean() {
    }

    public String getsContrasena() {
        return sContrasena;
    }

    public void setsContrasena(String sContrasena) {
        this.sContrasena = sContrasena;
    }

    public String getsContrasenaConf() {
        return sContrasenaConf;
    }

    public void setsContrasenaConf(String sContrasenaConf) {
        this.sContrasenaConf = sContrasenaConf;
    }

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    
    
    
    public void cambiarContrasena(){
        
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
          //  this.getProfesional().setLstEspecialidad(this.getAuxBean().getLstEspecialidadesSelect());
            
            this.validar();
            
            //llamar al metodo para guardar la contraseña
            this.contrasenaRNLocal.edit(this.getInvestigadorLoginBean().getInvestigador().getPersona().getCuil(), Encrypter.encriptar(sContrasena));
            
            sMensaje = "La contraseña fue modificada";
            severity = FacesMessage.SEVERITY_INFO;

            this.limpiar();

        } catch (Exception ex) {

            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error al crear: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
        
    }//fin cambiarContrasena
    
     private void validar() throws Exception {
        
        
        if(this.getsContrasena().isEmpty()){
            throw new Exception("No ingreso la contraseña.");
        }//fin if
        
        if(this.getsContrasenaConf().isEmpty()){
            throw new Exception("No ingreso el valor del campo confirma contraseña.");
        }//fin if
        
        if(!this.getsContrasena().equals(this.getsContrasenaConf())){
            throw new Exception("El valor del campo contrasena y confirma contraseña deben ser iguales.");
        }//fin if
        
        
        
    }//fin validar
    
     private void limpiar(){
         this.setsContrasena("");
         this.setsContrasenaConf("");
     }
    
}//fin CLASE
