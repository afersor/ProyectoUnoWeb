/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.persona.RN.TipoDocumentoRNLocal;
import entidades.persona.TipoDocumento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class TipoDocumentoLstBean implements Serializable {

    private List<TipoDocumento> lstTipoDocumento;
    
    private List<SelectItem> lstSITipoDocumento;
    
    @EJB
    private TipoDocumentoRNLocal tipoDocumentoRNLocal;
    
    public TipoDocumentoLstBean() {
    }

    public List<TipoDocumento> getLstTipoDocumento() {
        return lstTipoDocumento;
    }

    public void setLstTipoDocumento(List<TipoDocumento> lstTipoDocumento) {
        this.lstTipoDocumento = lstTipoDocumento;
    }

    public List<SelectItem> getLstSITipoDocumento() {
        return lstSITipoDocumento;
    }

    public void setLstSITipoDocumento(List<SelectItem> lstSITipoDocumento) {
        this.lstSITipoDocumento = lstSITipoDocumento;
    }
    
    public void findTipoDocumentos() throws Exception{
        this.setLstTipoDocumento(this.tipoDocumentoRNLocal.findTipoDocumentos());
    }//fin findTipoDocumentos()
    
    public void cargarSITipoDocumentos(){
        this.setLstSITipoDocumento(new ArrayList<SelectItem>());
        for(TipoDocumento sdc : this.getLstTipoDocumento()){
            SelectItem si = new SelectItem(sdc, sdc.getDescripcion());
            this.getLstSITipoDocumento().add(si);
        }//fin for
    }//fin cargarSISubDisciplinasCientificas
    
}
