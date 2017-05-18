/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import entidades.proyecto.evaluacion.EvaluacionWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface EvaluacionWebRNLocal {
    void create(EvaluacionWeb evaluacionWeb) throws Exception;
    void edit(EvaluacionWeb evaluacionWeb) throws Exception;
    List<EvaluacionWeb> findAllByEvaluador(Long idEvaluador) throws Exception ;
    List<EvaluacionWeb> findByProyecto(Long idProyecto) throws Exception ;
}
