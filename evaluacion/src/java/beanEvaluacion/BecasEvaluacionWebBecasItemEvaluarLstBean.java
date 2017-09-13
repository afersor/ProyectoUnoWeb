/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.becas.evaluacion.BecasEvaluacionWeb;
import entidades.becas.evaluacion.BecasEvaluacionWebBecasItemEvaluar;
import entidades.proyecto.evaluacion.EvaluacionWeb;
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
public class BecasEvaluacionWebBecasItemEvaluarLstBean implements Serializable {

    private List<BecasEvaluacionWebBecasItemEvaluar>  lstBecasEvaluacionWebBecasItemEvaluar;
    
    public BecasEvaluacionWebBecasItemEvaluarLstBean() {
        
    }
    
    public List<BecasEvaluacionWebBecasItemEvaluar> getLstBecasEvaluacionWebBecasItemEvaluar() {
        return lstBecasEvaluacionWebBecasItemEvaluar;
    }

    public void setLstBecasEvaluacionWebBecasItemEvaluar(List<BecasEvaluacionWebBecasItemEvaluar> lstBecasEvaluacionWebBecasItemEvaluar) {
        this.lstBecasEvaluacionWebBecasItemEvaluar = lstBecasEvaluacionWebBecasItemEvaluar;
    }
    
    

    

    
    
}
