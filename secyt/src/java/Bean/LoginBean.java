/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Recursos.Encrypter;
import entidades.persona.investigador.Acceso;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.AccesoRNLocal;
import entidades.persona.investigador.RN.ContrasenaRNLocal;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AFerSor
 */
@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {

    private String cuil;
    private String contrasena;
    
    @ManagedProperty(value="#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    @ManagedProperty(value="#{navegarUser}")
    private NavegarUser navegarUser;
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    @EJB
    private ContrasenaRNLocal contrasenaRNLocal;
    
    @EJB
    private AccesoRNLocal accesoRNLocal;
    
    public LoginBean() {
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    public NavegarUser getNavegarUser() {
        return navegarUser;
    }

    public void setNavegarUser(NavegarUser navegarUser) {
        this.navegarUser = navegarUser;
    }
    
    public String loginInvestigador(){
        try {
            
            //entityManagerRNLocal.open();
            Investigador inv = investigadorRNLocal.findInvestigadorByCUIL(cuil); 
            System.out.println("investigadorlogeinbeannn: "+inv.getPersona().getDomicilio().getLocalidad());

            if(inv == null){
                FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontro el investigador",null);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, fm);
            }else{
                
                this.validarContrasena(inv);
                this.getInvestigadorLoginBean().setInvestigador(inv);
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("user_rol", "1"); 
                
                //GUARDO DATOS DE INGRESO
                Acceso acceso = new Acceso();
                acceso.setFecha(new Date());
                acceso.setInvestigador(inv);
                accesoRNLocal.create(acceso);
                return "Usuario/"+navegarUser.pInvestigadorDatosPersonales();
                //return "Usuario/investigadorDatosPersonales.xhtml?faces-redirect=true";
            }//fin if-else
            
        } catch (Exception ex) {
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }//fin try-catch
        
        return null;
        
    }//fin loginInvestigador
    
    private void validarContrasena(Investigador inv) throws Exception{
        
System.out.println("validar contrasena: " + this.contrasenaRNLocal.bFindByInvestigadorYcontrasena(cuil, Encrypter.encriptar(contrasena)));
         if(!this.contrasenaRNLocal.bFindByInvestigadorYcontrasena(cuil, Encrypter.encriptar(contrasena))){
             throw new Exception("La contraseña es incorrecta");
         }//fin if
    }//fin validarContrasena
    
}//fin loginBean
