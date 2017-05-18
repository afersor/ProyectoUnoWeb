/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanProyecto;

import entidades.proyectoPidWeb.ConvocatoriaPid;
import entidades.proyectoPidWeb.RN.ConvocatoriaPidRNLocal;
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

    private List<ConvocatoriaPid> lstConvocatoria;
    
    @EJB
    private ConvocatoriaPidRNLocal convocatoriaPidRNLocal;
    
    public ConvocatoriaLstBean() {
    }

    public List<ConvocatoriaPid> getLstConvocatoria() {
        
        return lstConvocatoria;
    }

    public void setLstConvocatoria(List<ConvocatoriaPid> lstConvocatoria) {
        this.lstConvocatoria = lstConvocatoria;
    }
    
    public void findConvocatoriasAbiertas() throws Exception {
       this.setLstConvocatoria(convocatoriaPidRNLocal.findConvocatorias(new Date()));
       
    }//fin findConvocatorias
}
