/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import recursos.Encrypter;
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
    
    @ManagedProperty(value="#{navegarBean}")
    private NavegarBean navegarBean;
    
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    @EJB
    private ContrasenaRNLocal contrasenaRNLocal;
    
    @EJB
    private AccesoRNLocal accesoRNLocal;
    
    public LoginBean() {
    }

    public NavegarBean getNavegarBean() {
        return navegarBean;
    }

    public void setNavegarBean(NavegarBean navegarBean) {
        this.navegarBean = navegarBean;
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
    
    public String loginInvestigador(){
        try {
            
            if(this.getInvestigadorLoginBean().getCantLogin() == 3){
                throw new Exception("Ha caducado la cantidad de intentos permitidos. "
                        + "Debera esperar treinta minutos para intentar nuevamente");
            }//fin if

            Investigador inv = investigadorRNLocal.findInvestigadorByCUIL(cuil);           

            if(inv == null){
                FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontro el investigador",null);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, fm);
                this.getInvestigadorLoginBean().setCantLogin(this.getInvestigadorLoginBean().getCantLogin()+1);
            }else{
                
                this.validarContrasena(inv);
                this.getInvestigadorLoginBean().setInvestigador(inv);
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("user_rol", "1"); 
                 this.getInvestigadorLoginBean().setCantLogin(0);
                return this.getNavegarBean().entrarPagConvocatorias();
            }//fin if-else
            
            
            
        } catch (Exception ex) {
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }//fin try-catch
        
        return null;
        
    }//fin loginInvestigador
    
    private void validarContrasena(Investigador inv) throws Exception{
        
        System.out.println("COntraseña encriptada: " + inv.getId() + "  " + Encrypter.encriptar(contrasena));
        
         if(!this.contrasenaRNLocal.bFindByInvestigadorYcontrasena(cuil, Encrypter.encriptar(contrasena))){
             this.getInvestigadorLoginBean().setCantLogin(this.getInvestigadorLoginBean().getCantLogin()+1);
             throw new Exception("La contraseña es incorrecta");
         }//fin if
    }//fin validarContrasena
    
}//fin loginBean
