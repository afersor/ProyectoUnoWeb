/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import entidades.persona.Evaluador;
import entidades.persona.investigador.Investigador;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface EvaluadorRNLocal {

    public Evaluador buscarXInvestigador(Investigador investigador)throws Exception;
    
    Evaluador findEvaluadorByCUIL(String cuil) throws Exception;
    
}
