/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.RN.InvestigadorRNLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@RequestScoped
public class NavegarUser {

    
    @ManagedProperty(value="#{postulacionBecasLstBean}")
    private PostulacionBecasLstBean postulacionBecasLstBean;
    
    @ManagedProperty(value="#{proyectoLstBean}")
    private ProyectoLstBean proyectoLstBean;
    
    @ManagedProperty(value="#{areaSecytLstBean}")
    private AreaSecytLstBean areaSecytLstBean;
    
    @ManagedProperty(value="#{participacionVinculacionLstBean}")
    private ParticipacionVinculacionLstBean participacionVinculacionLstBean;
    
    @ManagedProperty(value="#{investigadorLoginBean}")
    private InvestigadorLoginBean investigadorLoginBean;
    
    @ManagedProperty(value="#{investigadorDatosPersonalesPagBean}")
    private InvestigadorDatosPersonalesPagBean investigadorDatosPersonalesPagBean;
    @ManagedProperty(value="#{investigadorProduccionBean}")
    private InvestigadorProduccionBean investigadorProduccionBean;
    @EJB
    private InvestigadorRNLocal investigadorRNLocal;
    
    public NavegarUser() {
    }

    public InvestigadorDatosPersonalesPagBean getInvestigadorDatosPersonalesPagBean() {
        return investigadorDatosPersonalesPagBean;
    }

    public void setInvestigadorDatosPersonalesPagBean(InvestigadorDatosPersonalesPagBean investigadorDatosPersonalesPagBean) {
        this.investigadorDatosPersonalesPagBean = investigadorDatosPersonalesPagBean;
    }
    
    public AreaSecytLstBean getAreaSecytLstBean() {
        return areaSecytLstBean;
    }

    public void setAreaSecytLstBean(AreaSecytLstBean areaSecytLstBean) {
        this.areaSecytLstBean = areaSecytLstBean;
    }

    public ParticipacionVinculacionLstBean getParticipacionVinculacionLstBean() {
        return participacionVinculacionLstBean;
    }

    public void setParticipacionVinculacionLstBean(ParticipacionVinculacionLstBean participacionVinculacionLstBean) {
        this.participacionVinculacionLstBean = participacionVinculacionLstBean;
    }

    public InvestigadorLoginBean getInvestigadorLoginBean() {
        return investigadorLoginBean;
    }

    public void setInvestigadorLoginBean(InvestigadorLoginBean investigadorLoginBean) {
        this.investigadorLoginBean = investigadorLoginBean;
    }

    public PostulacionBecasLstBean getPostulacionBecasLstBean() {
        return postulacionBecasLstBean;
    }

    public void setPostulacionBecasLstBean(PostulacionBecasLstBean postulacionBecasLstBean) {
        this.postulacionBecasLstBean = postulacionBecasLstBean;
    }

    public ProyectoLstBean getProyectoLstBean() {
        return proyectoLstBean;
    }

    public void setProyectoLstBean(ProyectoLstBean proyectoLstBean) {
        this.proyectoLstBean = proyectoLstBean;
    }

    public InvestigadorProduccionBean getInvestigadorProduccionBean() {
        return investigadorProduccionBean;
    }

    public void setInvestigadorProduccionBean(InvestigadorProduccionBean investigadorProduccionBean) {
        this.investigadorProduccionBean = investigadorProduccionBean;
    }
    
    public String pInvestigadorDatosPersonales(){
      return "investigadorDatosPersonales.xhtml?faces-redirect=true";
    }//fin pInvestigadorDatosPersonales
    
    public String pInvestigadorFormacionAcademica(){
        return "investigadorFormacionAcademica.xhtml";
    }//fin pInvestigadorFormacionAcademica
    
    public String pInvestigadorDocencia(){
        return "investigadorDocencia.xhtml";
    }//fin pInvestigadorDocencia
    
    public String pInvestigadorCursos(){
        return "investigadorCursos.xhtml";
    }//fin pInvestigadorCursos
    
    public String pInvestigadorConduccion(){
        return "investigadorConduccion.xhtml";
    }//fin pInvestigadorConduccion
    
    public String pInvestigadorEspecializacion(){
        return "investigadorEspecializacion.xhtml";
    }//fin pInvestigadorEspecializacion
    
    public String pInvestigadorParticipacionesProyectos(){
        return "investigadorParticipacionesProyectos.xhtml";
    }//fin pInvestigadorParticipacionesProyectos
    
    public String pInvestigadorCateforizacion(){
        return "investigadorCategorizacion.xhtml";
    }//fin pInvestigadorCateforizacion
    
    public String pInvestigadorCambiarContrasena(){
        return "investigadorCambiarContrasena.xhtml";
    }
    
    public String pInvestigadorPostulacionBecas(){
        this.getPostulacionBecasLstBean().cargarPostulacionBecas();
        return "investigadorPostulacionBecas.xhtml";
    }
    
    public String pInvestigadorMensaje(){
        this.getAreaSecytLstBean().cargarAllSIAreaSecyt();
        return "investigadorMensaje.xhtml";
    }//fin pInvestigadorMensaje
    
    public String pInvestigadorProduccion(){
        
        //this.getPublicacionLstBean().cargarPublicacionesByInvestigador();
     //   this.getInvestigadorProduccionBean().limpiarObjetos();
        this.getProyectoLstBean().cargarProyectosByPublicacionYInvestigador();
        return "investigadorProduccion.xhtml";
    }//fin pInvestigadorProduccion
    
    public String pInvestigadorArchivo(){
        return "investigadorArchivo.xhtml";
    }//fin pInvestigadorArchivo
    
    public String pInvestigadorRendicion(){
        this.getProyectoLstBean().cargarProyectosByIngestigadorYRol();
        return "investigadorRendicion.xhtml";
    }//fin pInvestigadorArchivo
    
    public String pInvestigadorParticipacionVinculacion(){
        this.getParticipacionVinculacionLstBean().cargarParticipacionVinculacionByInvestigador(
                this.getInvestigadorLoginBean().getInvestigador().getId());
        return "investigadorParticipacionesVinculacion.xhtml";
    }//fin pInvestigadorArchivo
}//FIN CLASE