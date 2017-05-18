/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AFerSor
 */
@ManagedBean(name = "sessionControlerBean")
@RequestScoped
public class SessionControlerBean implements Serializable {

    private int iTimeSession;

    public SessionControlerBean() {
    }

    public int getiTimeSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);        
        if(session == null){
            session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        }
        return session.getMaxInactiveInterval();
    }

    public void setiTimeSession(int iTimeSession) {
        this.iTimeSession = iTimeSession;
    }

    public String cerrarSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            try {
                session.invalidate();
                return "./../finalizado.xhtml?faces-redirect=true";
            } //fin if
            catch (Exception ex) {
                Logger.getLogger(SessionControlerBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//fin if

        return "";
    }//fin cerrarSession

    public String cerrarSessionLogin() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            try {
                session.invalidate();
                return "./finalizado.xhtml?faces-redirect=true";
            } //fin if
            catch (Exception ex) {
                Logger.getLogger(SessionControlerBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//fin if

        return "";
    }//fin cerrarSession

    public String createSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        /*session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
         if(session != null){
         session.invalidate();
         }//fin */

        return "./../login.xhtml?faces-redirect=true";
    }//fin abrirSession
}//FIN CLASE
