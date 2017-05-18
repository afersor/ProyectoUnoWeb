/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

//import Entidades.Persona.TipoDocumento;
//import Entidades.Persona.RN.TipoDocumentoRNLocal;
import entidades.persona.RN.SexoRNLocal;
import entidades.persona.RN.TipoDocumentoRNLocal;
import entidades.persona.Sexo;
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
public class ListadoSexoBean {

    @EJB
    private SexoRNLocal sexoRNLocal;
    private List<SelectItem> lstSISexo;

    public List<SelectItem> getLstSISexo() {
        return lstSISexo;
    }

    public void setLstSISexo(List<SelectItem> lstSISexo) {
        this.lstSISexo = lstSISexo;
    }

    
    
    
    /**
     * Creates a new instance of listadoTipoDocumentoBean
     */
    public ListadoSexoBean() {
    }
    
    @PostConstruct
    private void init(){
        cargarSISexo();
    }
    
    public void cargarSISexo(){
        try {
            //System.out.println("entra");
            List <Sexo> lstSexoAux = this.sexoRNLocal.findSexos();
            if(this.getLstSISexo() == null){
                this.setLstSISexo(new ArrayList<SelectItem>());
            }//fin del if
            
            for(Sexo td : lstSexoAux){
                SelectItem si = new SelectItem(td, td.getDescripcion());
                this.getLstSISexo().add(si);
            }//fin del for

            
        } catch (Exception ex){
            FacesMessage fm = new  FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al cargar Sexos " + ex.getMessage(),null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarSISexo
}
