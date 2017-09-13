/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

import entidades.becas.evaluacion.BecasEvaluacionWeb;
import entidades.becas.evaluacion.RN.BecasEvaluacionWebRNLocal;
import entidades.proyecto.evaluacion.EvaluacionWeb;
import entidades.proyecto.evaluacion.RN.EvaluacionWebRNLocal;
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
public class BecasEvaluacionWebLstBean {

    private List<BecasEvaluacionWeb> lstBecasEvaluacionWeb;
    
    private BecasEvaluacionWeb becasEvaluacionWebSelect;
    @EJB
    private BecasEvaluacionWebRNLocal becasEvaluacionWebRNLocal;
    
    public BecasEvaluacionWebLstBean() {
    }

    public BecasEvaluacionWeb getBecasEvaluacionWebSelect() {
        return becasEvaluacionWebSelect;
    }

    public void setBecasEvaluacionWebSelect(BecasEvaluacionWeb becasEvaluacionWebSelect) {
        this.becasEvaluacionWebSelect = becasEvaluacionWebSelect;
    }

    public List<BecasEvaluacionWeb> getLstBecasEvaluacionWeb() {
        return lstBecasEvaluacionWeb;
    }

    public void setLstBecasEvaluacionWeb(List<BecasEvaluacionWeb> lstBecasEvaluacionWeb) {
        this.lstBecasEvaluacionWeb = lstBecasEvaluacionWeb;
    }

    
    
    public void findAllByEvaluador(Long idEvaluador) throws Exception {
        this.setLstBecasEvaluacionWeb(becasEvaluacionWebRNLocal.findByEvaluadorPrincipal(idEvaluador));
        
        System.out.println("idEvaluador: " + idEvaluador + this.getLstBecasEvaluacionWeb());
        
        /*for(BecasEvaluacionWeb ew : this.getLstBecasEvaluacionWeb()){
            if(ew.getBecaBloquesEvaluados() != null && !ew.getBecaBloquesEvaluados().isEmpty()){
                ew.getBecaBloquesEvaluados().get(0);
            }
        }*/
        
    }
}
