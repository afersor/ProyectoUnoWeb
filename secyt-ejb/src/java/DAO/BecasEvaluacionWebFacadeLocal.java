/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.becas.evaluacion.BecasEvaluacionWeb;
import entidades.persona.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface BecasEvaluacionWebFacadeLocal {

    void create(BecasEvaluacionWeb becasEvaluacionWeb);

    void edit(BecasEvaluacionWeb becasEvaluacionWeb);

    void remove(BecasEvaluacionWeb becasEvaluacionWeb);

    BecasEvaluacionWeb find(Object id);

    List<BecasEvaluacionWeb> findAll();

    List<BecasEvaluacionWeb> findRange(int[] range);

    int count();
    
    List<BecasEvaluacionWeb> findByEvaluadorPrincipal(Long idEvaluador);
    
}
