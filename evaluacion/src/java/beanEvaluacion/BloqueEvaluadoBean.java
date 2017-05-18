/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.RN.BloqueEvaluadoRNLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hugo
 */
@ManagedBean(name = "bloqueEvaluadoBean")
@SessionScoped
public class BloqueEvaluadoBean {

    /**
     * Creates a new instance of BloqueEvaluadoBean
     */
    @EJB
    private BloqueEvaluadoRNLocal bloqueEvaluadoRNLocal;
    private BloqueEvaluado bloqueEvaluado;
    public BloqueEvaluadoBean() {
    }

    public BloqueEvaluado getBloqueEvaluado() {
        return bloqueEvaluado;
    }

    public void setBloqueEvaluado(BloqueEvaluado bloqueEvaluado) {
        this.bloqueEvaluado = bloqueEvaluado;
    }
    
    public BloqueEvaluado buscarBloqueEvaluado(Long id) throws Exception{
        return bloqueEvaluadoRNLocal.buscarPorId(id);
    }

    public void modificar(BloqueEvaluado bloqueEvaluado) {
        try {
            bloqueEvaluadoRNLocal.modificar(bloqueEvaluado);
        } catch (Exception ex) {
            Logger.getLogger(BloqueEvaluadoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
