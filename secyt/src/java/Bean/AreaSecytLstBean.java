/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.persona.investigador.AreaSecyt;
import entidades.persona.investigador.RN.AreaSecytRNLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author AFerSor
 */
@ManagedBean
@SessionScoped
public class AreaSecytLstBean {

    private List<SelectItem> lstSIAreaSecyt;
    
    @EJB
    private AreaSecytRNLocal areaSecytRNLocal;
    
    public AreaSecytLstBean() {
    }

    public List<SelectItem> getLstSIAreaSecyt() {
        return lstSIAreaSecyt;
    }

    public void setLstSIAreaSecyt(List<SelectItem> lstSIAreaSecyt) {
        this.lstSIAreaSecyt = lstSIAreaSecyt;
    }
    
    public void cargarAllSIAreaSecyt(){
         this.setLstSIAreaSecyt(new ArrayList<SelectItem>());
         List<AreaSecyt> lstAux = this.areaSecytRNLocal.findAll();
        for(AreaSecyt a : lstAux){

            SelectItem si = new SelectItem(a, a.getDescripcion());
            this.getLstSIAreaSecyt().add(si);

        }//fin for
    }//fin cargarSIAreaSecyt
}
