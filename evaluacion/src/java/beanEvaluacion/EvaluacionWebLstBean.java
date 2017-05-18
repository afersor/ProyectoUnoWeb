/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanEvaluacion;

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
public class EvaluacionWebLstBean {

    private List<EvaluacionWeb> lstEvaluacionWeb;
    @EJB
    private EvaluacionWebRNLocal evaluacionWebRNLocal;
    
    public EvaluacionWebLstBean() {
    }

    public List<EvaluacionWeb> getLstEvaluacionWeb() {
        return lstEvaluacionWeb;
    }

    public void setLstEvaluacionWeb(List<EvaluacionWeb> lstEvaluacionWeb) {
        this.lstEvaluacionWeb = lstEvaluacionWeb;
    }
    
    public void findAllByEvaluador(Long idEvaluador) throws Exception {
        System.out.println("id evaluador: " + idEvaluador);
        this.setLstEvaluacionWeb(evaluacionWebRNLocal.findAllByEvaluador(idEvaluador));
        
        for(EvaluacionWeb ew : this.getLstEvaluacionWeb()){
            System.out.println("Evaluaciones: " + (ew.getDocumentos()!=null?ew.getDocumentos().size():""));
            
            if(ew.getBloquesEvaluados() != null && !ew.getBloquesEvaluados().isEmpty()){
                ew.getBloquesEvaluados().get(0);
            }
            System.out.println("asd: " + ew.getBloquesEvaluados());
        }
        
        System.out.println("datos : " + this.getLstEvaluacionWeb());
    }
}
