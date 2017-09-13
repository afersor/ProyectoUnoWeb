/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.becas.evaluacion.RN;

import DAO.BecasEvaluacionWebFacadeLocal;
import entidades.becas.evaluacion.BecasEvaluacionWeb;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class BecasEvaluacionWebRN implements BecasEvaluacionWebRNLocal {

    @EJB
    private BecasEvaluacionWebFacadeLocal becasEvaluacionWebFacadeLocal;
    
    @Override
    public List<BecasEvaluacionWeb> findByEvaluadorPrincipal(Long idEvaluador)  throws Exception{
        return becasEvaluacionWebFacadeLocal.findByEvaluadorPrincipal(idEvaluador) ;
    }

    @Override
    public void edit(BecasEvaluacionWeb becasEvaluacionWeb) {
        becasEvaluacionWebFacadeLocal.edit(becasEvaluacionWeb);
    }



}
