/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.becas.evaluacion.RN;


import entidades.becas.evaluacion.BecasEvaluacionWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface BecasEvaluacionWebRNLocal {
    void edit(BecasEvaluacionWeb becasEvaluacionWeb);
    List<BecasEvaluacionWeb> findByEvaluadorPrincipal(Long idEvaluador)  throws Exception;
}
