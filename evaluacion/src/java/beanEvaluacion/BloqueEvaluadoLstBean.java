/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.RN.BloqueEvaluadoRNLocal;
import java.io.Serializable;
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
public class BloqueEvaluadoLstBean implements Serializable {
    
    
    @EJB
    private  BloqueEvaluadoRNLocal bloqueEvaluadoRNLocal;
    
    private List<BloqueEvaluado> lstBloqueEvaluado;
    
    public BloqueEvaluadoLstBean() {
    }

    public List<BloqueEvaluado> getLstBloqueEvaluado() {
        return lstBloqueEvaluado;
    }

    public void setLstBloqueEvaluado(List<BloqueEvaluado> lstBloqueEvaluado) {
        this.lstBloqueEvaluado = lstBloqueEvaluado;
    }
    public void buscarTodos() throws Exception{
        this.setLstBloqueEvaluado(bloqueEvaluadoRNLocal.findAll());
      
    }
    
}
