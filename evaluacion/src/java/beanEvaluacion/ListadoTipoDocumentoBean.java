/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

//import Entidades.Persona.TipoDocumento;
//import Entidades.Persona.RN.TipoDocumentoRNLocal;
import entidades.persona.RN.TipoDocumentoRNLocal;
import entidades.persona.TipoDocumento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author hugo
 */
@ManagedBean
@SessionScoped
public class ListadoTipoDocumentoBean {

    @EJB
    private TipoDocumentoRNLocal tipoDocumentoRNLocal;
    private List<SelectItem> lstSITipoDocumento;

    public List<SelectItem> getLstSITipoDocumento() {
        return lstSITipoDocumento;
    }

    public void setLstSITipoDocumento(List<SelectItem> lstSITipoDocumento) {
        this.lstSITipoDocumento = lstSITipoDocumento;
    }
    
    
    /**
     * Creates a new instance of ListadoTipoDocumentoBean
     */
    public ListadoTipoDocumentoBean() {
    }
    
    @PostConstruct
    private void init(){
        cargarSITipoDocumento();
    }
    
    public void cargarSITipoDocumento(){
        try {
            //System.out.println("entra");
            List <TipoDocumento> lstTipoDocAux = this.tipoDocumentoRNLocal.findAll();
            if(this.getLstSITipoDocumento() == null){
                this.setLstSITipoDocumento(new ArrayList<SelectItem>());
            }//fin del if
            
            for(TipoDocumento td : lstTipoDocAux){
                SelectItem si = new SelectItem(td, td.getDescripcion());
                this.getLstSITipoDocumento().add(si);
            }//fin del for

            
        } catch (Exception ex){
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al cargar Tipo de Documentos " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarSITipoDocumento
}
