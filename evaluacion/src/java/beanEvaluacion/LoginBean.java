/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.persona.Evaluador;
import recursos.Encrypter;
import entidades.persona.investigador.Acceso;
import entidades.persona.investigador.Docencia;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.AccesoRNLocal;
import entidades.persona.investigador.RN.ContrasenaRNLocal;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import entidades.proyecto.evaluacion.RN.EvaluadorRNLocal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
    
    @ManagedProperty(value="#{evaluadorLoginBean}")
    private EvaluadorLoginBean evaluadorLoginBean;
    
    @ManagedProperty(value="#{navegarBean}")
    private NavegarBean navegarBean;
    
    @ManagedProperty(value="#{tituloGradoLstBean}")
    private TituloGradoLstBean tituloGradoLstBean;
    
    @ManagedProperty(value="#{universidadlstBean}")
    private UniversidadlstBean universidadlstBean;
    
    @ManagedProperty(value="#{institucionLstBean}")
    private InstitucionLstBean institucionLstBean;
    
    @EJB
    private EvaluadorRNLocal evaluadorRNLocal;
    
    @EJB
    private ContrasenaRNLocal contrasenaRNLocal;
    
    @EJB
    private AccesoRNLocal accesoRNLocal;
    
    public LoginBean() {
    }

    public InstitucionLstBean getInstitucionLstBean() {
        return institucionLstBean;
    }

    public void setInstitucionLstBean(InstitucionLstBean institucionLstBean) {
        this.institucionLstBean = institucionLstBean;
    }
    

    public TituloGradoLstBean getTituloGradoLstBean() {
        return tituloGradoLstBean;
    }

    public void setTituloGradoLstBean(TituloGradoLstBean tituloGradoLstBean) {
        this.tituloGradoLstBean = tituloGradoLstBean;
    }

    public UniversidadlstBean getUniversidadlstBean() {
        return universidadlstBean;
    }

    public void setUniversidadlstBean(UniversidadlstBean universidadlstBean) {
        this.universidadlstBean = universidadlstBean;
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

    public EvaluadorLoginBean getEvaluadorLoginBean() {
        return evaluadorLoginBean;
    }

    public void setEvaluadorLoginBean(EvaluadorLoginBean evaluadorLoginBean) {
        this.evaluadorLoginBean = evaluadorLoginBean;
    }

    
    
    public String loginEvaluador(){
        try {
            
            System.out.println("cant login " + this.getEvaluadorLoginBean().getCantLogin());
            if(this.getEvaluadorLoginBean().getCantLogin() == 3){
                throw new Exception("Ha caducado la cantidad de intentos permitidos. "
                        + "Debera esperar treinta minutos para intentar nuevamente");
            }//fin if
            
            
            Evaluador ev = evaluadorRNLocal.findEvaluadorByCUIL(cuil);      
            

            if(ev == null){
                FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontro el evaluador",null);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, fm);
                this.getEvaluadorLoginBean().setCantLogin(this.getEvaluadorLoginBean().getCantLogin()+1);
            }else{
                
                System.out.println("Else");
                System.out.println("Else: " + this.getEvaluadorLoginBean().getEvaluador());
                if (ev.getInvestigador().getDocencias() != null && 
                     !ev.getInvestigador().getDocencias().isEmpty()) {
                    
                    
                 
                    List<Docencia> lstDocAux = ev.getInvestigador().getDocencias();
                    
                    //System.out.println("Docencias: " + lstDocAux);
                    Collections.sort(lstDocAux);
                    
                 //System.out.println("Docencias: " + lstDocAux);
                 
                 ev.getInvestigador().setDocencias(lstDocAux);
                 
                 if (ev.getInvestigador().getDocencias().get(
                         ev.getInvestigador().getDocencias().size()-1).getUniversidad()== null) {
                     throw new Exception("No tiene una universidad asignada. No puede entrar");
                 }
                 
                 this.getEvaluadorLoginBean().setIdUniversidad(ev.getInvestigador().getDocencias().get(
                         ev.getInvestigador().getDocencias().size()-1).getUniversidad().getId());
             }else{
                 throw new Exception("No tiene una universidad asignada. No puede entrar");
             }
                
                
                System.out.println("Else1");
                this.validarContrasena(ev.getInvestigador());
                
                System.out.println("Else2");
                this.getEvaluadorLoginBean().setEvaluador(ev);
                
                System.out.println("Else3");
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("user_rol", "1"); 
                this.getEvaluadorLoginBean().setCantLogin(0);
                
                //cargar formacionAcademica y Universidades
                this.getUniversidadlstBean().cargarUniversidades();
                System.out.println("Else4");
                this.getTituloGradoLstBean().cargarTitulosGrado();
                System.out.println("Else5");
                this.getInstitucionLstBean().cargarInstituciones();
                System.out.println("Else6");
                
                return this.getNavegarBean().entrarPagPri();
            }//fin if-else
            
            
            
        } catch (Exception ex) {
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }//fin try-catch
        
        return null;
        
    }//fin loginInvestigador
    
    private void validarContrasena(Investigador inv) throws Exception{
        
    
        
         if(!this.contrasenaRNLocal.bFindByInvestigadorYcontrasena(cuil, Encrypter.encriptar(contrasena))){
             this.getEvaluadorLoginBean().setCantLogin(this.getEvaluadorLoginBean().getCantLogin()+1);
             throw new Exception("La contraseña es incorrecta");
         }//fin if
    }//fin validarContrasena
    
}//fin loginBean
