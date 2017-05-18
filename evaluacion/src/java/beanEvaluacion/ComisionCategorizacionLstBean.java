/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.categorizacion.ComisionCategorizacion;
import entidades.categorizacion.RN.ComisionCategorizacionRNLocal;
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
public class ComisionCategorizacionLstBean implements Serializable {

    private List<ComisionCategorizacion> lstComisionCategorizacion;
    private List <SelectItem> lstSIComisionCategorizacion;
    
    @EJB
    private ComisionCategorizacionRNLocal comisionCategorizacionRNLocal;
    
    public ComisionCategorizacionLstBean() {
        lstSIComisionCategorizacion = new ArrayList<SelectItem>();
    }

    public List<ComisionCategorizacion> getLstComisionCategorizacion() {
        return lstComisionCategorizacion;
    }

    public void setLstComisionCategorizacion(List<ComisionCategorizacion> lstComisionCategorizacion) {
        this.lstComisionCategorizacion = lstComisionCategorizacion;
    }

    public List<SelectItem> getLstSIComisionCategorizacion() {
        return lstSIComisionCategorizacion;
    }

    public void setLstSIComisionCategorizacion(List<SelectItem> lstSIComisionCategorizacion) {
        this.lstSIComisionCategorizacion = lstSIComisionCategorizacion;
    }

        
    public void findAllComisionCategorizacion() throws Exception{
        this.setLstComisionCategorizacion(comisionCategorizacionRNLocal.findAll());
    }//fin findUnidadesAcademicas
    
    public void cargarSIComisionCategorizacion(){
        this.setLstSIComisionCategorizacion(new ArrayList<SelectItem>());
        for(ComisionCategorizacion cc : this.getLstComisionCategorizacion()){
            System.out.println("cc: " + cc.getDescripcion());
            SelectItem si = new SelectItem(cc, cc.getDescripcion());
            this.getLstSIComisionCategorizacion().add(si);
        }//fin for
    }//fin cargarSIUnidadesAcademicas
}
