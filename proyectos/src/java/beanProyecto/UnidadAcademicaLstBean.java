/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;


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
    private List<SelectItem> lstSIUnidadAcademica;
    
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
        this.setLstUnidadAcademica(unidadAcademicaRNLocal.findUnidadesAcademicasUNCa());
    }//fin findUnidadesAcademicas
    
    public void cargarSIUnidadesAcademicas() throws Exception{
        
        this.setLstSIUnidadAcademica(new ArrayList<SelectItem>());
        for(UnidadAcademica ua : this.getLstUnidadAcademica()){
            
            //if(!ua.getDescripcion().trim().isEmpty()){
                SelectItem si = new SelectItem(ua, ua.getDescripcion());
                this.getLstSIUnidadAcademica().add(si);
           // }//fin if
            
        }//fin for
    }//fin cargarSIUnidadesAcademicas
}
