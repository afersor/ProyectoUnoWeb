/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;


import entidades.categorizacion.Categorizacion;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class CategorizacionLstBean implements Serializable {

    private List<Categorizacion> lstCategorizacion;
    
    public CategorizacionLstBean() {
    }

    public List<Categorizacion> getLstCategorizacion() {
        return lstCategorizacion;
    }

    public void setLstCategorizacion(List<Categorizacion> lstCategorizacion) {
        this.lstCategorizacion = lstCategorizacion;
    }

}
