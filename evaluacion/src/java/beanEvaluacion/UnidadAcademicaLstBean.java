/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.RN.UnidadAcademicaRNLocal;
import entidades.UnidadAcademica;
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
public class UnidadAcademicaLstBean implements Serializable {

    private List<UnidadAcademica> lstUnidadAcademica;
    private List <SelectItem> lstSIUnidadAcademica;
    
    @EJB
    private UnidadAcademicaRNLocal unidadAcademicaRNLocal;
    
    public UnidadAcademicaLstBean() {
    }

    public List<UnidadAcademica> getLstUnidadAcademica() {
        return lstUnidadAcademica;
    }

    public void setLstUnidadAcademica(List<UnidadAcademica> lstUnidadAcademica) {
        this.lstUnidadAcademica = lstUnidadAcademica;
    }

    public List<SelectItem> getLstSIUnidadAcademica() {
        return lstSIUnidadAcademica;
    }

    public void setLstSIUnidadAcademica(List<SelectItem> lstSIUnidadAcademica) {
        this.lstSIUnidadAcademica = lstSIUnidadAcademica;
    }
    
    public void findUnidadesAcademicas() throws Exception{
        this.setLstUnidadAcademica(unidadAcademicaRNLocal.findAll());
    }//fin findUnidadesAcademicas
    
    public void cargarSIUnidadesAcademicas(){
        this.setLstSIUnidadAcademica(new ArrayList<SelectItem>());
        for(UnidadAcademica ua : this.getLstUnidadAcademica()){
            System.out.println("Unidad academica: " + ua.getDescripcion());
            SelectItem si = new SelectItem(ua, ua.getDescripcion());
            this.getLstSIUnidadAcademica().add(si);
        }//fin for
    }//fin cargarSIUnidadesAcademicas
    
    
}
