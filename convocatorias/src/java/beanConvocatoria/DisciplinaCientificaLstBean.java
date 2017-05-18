/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.DisciplinaCientifica;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class DisciplinaCientificaLstBean implements Serializable {

    private List<DisciplinaCientifica> lstDisciplinaCientifica;
    
    private List<SelectItem> lstSIDisciplinaCientifica;
    
    public DisciplinaCientificaLstBean() {
    }

    public List<SelectItem> getLstSIDisciplinaCientifica() {
        return lstSIDisciplinaCientifica;
    }

    public void setLstSIDisciplinaCientifica(List<SelectItem> lstSIDisciplinaCientifica) {
        this.lstSIDisciplinaCientifica = lstSIDisciplinaCientifica;
    }

    public List<DisciplinaCientifica> getLstDisciplinaCientifica() {
        return lstDisciplinaCientifica;
    }

    public void setLstDisciplinaCientifica(List<DisciplinaCientifica> lstDisciplinaCientifica) {
        this.lstDisciplinaCientifica = lstDisciplinaCientifica;
    }
    
    public void cargarSIDisplinasCientificas(){
        this.setLstSIDisciplinaCientifica(new ArrayList<SelectItem>());
        for(DisciplinaCientifica dc : this.getLstDisciplinaCientifica()){
            SelectItem si = new SelectItem(dc, dc.getDescripcion());
            this.getLstSIDisciplinaCientifica().add(si);
        }//fin for
    }//fin cargar cargarSIDisplinasCientificas
   
}
