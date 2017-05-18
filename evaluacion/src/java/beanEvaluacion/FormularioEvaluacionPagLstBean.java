/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.proyecto.evaluacion.EvaluacionWeb;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class FormularioEvaluacionPagLstBean implements Serializable {

    private EvaluacionWeb evaluacionWebSelect;
    
    public FormularioEvaluacionPagLstBean() {
    }

    public EvaluacionWeb getEvaluacionWebSelect() {
        return evaluacionWebSelect;
    }

    public void setEvaluacionWebSelect(EvaluacionWeb evaluacionWebSelect) {
        this.evaluacionWebSelect = evaluacionWebSelect;
    }
    
}
