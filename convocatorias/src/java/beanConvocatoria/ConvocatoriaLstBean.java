/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanConvocatoria;

import entidades.proyectoWeb.Convocatoria;
import entidades.proyectoWeb.RN.ConvocatoriaRNLocal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class ConvocatoriaLstBean implements Serializable {

    private List<Convocatoria> lstConvocatoria;
    
    @EJB
    private ConvocatoriaRNLocal convocatoriaRNLocal;
    
    public ConvocatoriaLstBean() {
    }

    public List<Convocatoria> getLstConvocatoria() {
        
        return lstConvocatoria;
    }

    public void setLstConvocatoria(List<Convocatoria> lstConvocatoria) {
        this.lstConvocatoria = lstConvocatoria;
    }
    
    public void findConvocatoriasAbiertas() throws Exception {
       this.setLstConvocatoria(convocatoriaRNLocal.findConvocatorias(new Date()));
       
    }//fin findConvocatorias
}
