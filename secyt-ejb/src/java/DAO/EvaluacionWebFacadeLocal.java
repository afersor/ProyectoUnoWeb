/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.EvaluacionWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface EvaluacionWebFacadeLocal {

    void create(EvaluacionWeb evaluacionWeb);

    void edit(EvaluacionWeb evaluacionWeb);

    void remove(EvaluacionWeb evaluacionWeb);

    EvaluacionWeb find(Object id);

    List<EvaluacionWeb> findAll();

    List<EvaluacionWeb> findRange(int[] range);

    int count();
    
    List<EvaluacionWeb> findAllByEvaluador(Long idEvaluador) throws Exception ;
    List<EvaluacionWeb> findByProyecto(Long idProyecto) throws Exception ;
    
}
