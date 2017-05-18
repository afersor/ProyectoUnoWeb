/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.RN.UniversidadRNLocal;
import entidades.Universidad;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author hugo
 */
@ManagedBean
@SessionScoped
public class UniversidadlstBean implements Serializable {

    /**
     * Creates a new instance of UniversidadlstBean
     */
    @EJB
    private UniversidadRNLocal universidadRNLocal;
    private List<SelectItem> lstSIUniversidad;
    private List<Universidad> listaUniversidad;
    private Universidad universidad;
    
    public UniversidadlstBean() {
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    
    public List<SelectItem> getLstSIUniversidad() {
        return lstSIUniversidad;
    }

    public void setLstSIUniversidad(List<SelectItem> lstSIUniversidad) {
        this.lstSIUniversidad = lstSIUniversidad;
    }

    public List<Universidad> getListaUniversidad() {
        return listaUniversidad;
    }

    public void setListaUniversidad(List<Universidad> listaUniversidad) {
        this.listaUniversidad = listaUniversidad;
    }
    /*@PostConstruct
    private void init(){
        listaUniversidad=new ArrayList<>();
        cargarUniversidades();
    }*/

    public void cargarUniversidades() {
        try {
            this.setListaUniversidad(universidadRNLocal.buscarUniversidades());
            lstSIUniversidad =new ArrayList<>();
            for (Universidad univ : this.getListaUniversidad()) {
                lstSIUniversidad.add(new SelectItem(univ, univ.toString()));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UniversidadlstBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
