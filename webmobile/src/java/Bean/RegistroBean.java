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
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class RegistroBean {

    @EJB
    private ContrasenaRNLocal contrasenaRNLocal;
    
    private String sCuil;
    private String sContrasena;
    private String sContrasenaConf;
    
    public RegistroBean() {
    }

    public String getsCuil() {
        return sCuil;
    }

    public void setsCuil(String sCuil) {
        this.sCuil = sCuil;
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
    
    public void create(){
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            
            this.validar();
            
            this.contrasenaRNLocal.create(this.getsCuil(), Encrypter.encriptar(this.getsContrasena()));
            
            //Muestra el dialog si esta todo bien
            RequestContext.getCurrentInstance().execute("dlgConfirmacion.show();");
            

        } catch (Exception ex) {

            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);

        } 

    }//fin create
    
    public void edit(){
        
    }//fin edit
    
    private void validar() throws Exception {
        
        if(this.getsCuil().isEmpty()){
            throw new Exception("No ingreso el cuil.");
        }//fin if
        
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
    
    
}//FIN CLASE
