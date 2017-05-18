/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyecto.SubDisciplinaCientifica;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class SubDisciplinaCientificaLstBean {

    private List<SubDisciplinaCientifica> lstSubDisciplinaCientifica;
    
    private List<SelectItem> lstSISubDisciplinaCientifica;
    
    public SubDisciplinaCientificaLstBean() {
    }

    public List<SelectItem> getLstSISubDisciplinaCientifica() {
        return lstSISubDisciplinaCientifica;
    }

    public void setLstSISubDisciplinaCientifica(List<SelectItem> lstSISubDisciplinaCientifica) {
        this.lstSISubDisciplinaCientifica = lstSISubDisciplinaCientifica;
    }

    public List<SubDisciplinaCientifica> getLstSubDisciplinaCientifica() {
        return lstSubDisciplinaCientifica;
    }

    public void setLstSubDisciplinaCientifica(List<SubDisciplinaCientifica> lstSubDisciplinaCientifica) {
        this.lstSubDisciplinaCientifica = lstSubDisciplinaCientifica;
    }
    
    public void cargarSISubDisciplinasCientificas(){
        this.setLstSISubDisciplinaCientifica(new ArrayList<SelectItem>());
        for(SubDisciplinaCientifica sdc : this.getLstSubDisciplinaCientifica()){
            SelectItem si = new SelectItem(sdc, sdc.getDescripcion());
            this.getLstSISubDisciplinaCientifica().add(si);
        }//fin for
    }//fin cargarSISubDisciplinasCientificas
    
}
