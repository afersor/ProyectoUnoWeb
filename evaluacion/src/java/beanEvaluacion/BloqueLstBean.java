/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.RN.BloqueRNLocal;
import java.util.Collections;
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
public class BloqueLstBean {

    private List<Bloque> lstBloque;
    
    @EJB
    private BloqueRNLocal bloqueRNLocal;
    
    public BloqueLstBean() {
    }

    public List<Bloque> getLstBloque() {
        return lstBloque;
    }

    public void setLstBloque(List<Bloque> lstBloque) {
        this.lstBloque = lstBloque;
    }
    
    
    public void findBloques() throws Exception{
        this.setLstBloque(bloqueRNLocal.findAll());
        
    }//fin cargarBloques
    
}
