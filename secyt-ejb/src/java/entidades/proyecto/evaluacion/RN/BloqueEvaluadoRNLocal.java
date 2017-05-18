/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface BloqueEvaluadoRNLocal {
    List<BloqueEvaluado> findAll() throws Exception;

    public BloqueEvaluado buscarPorId(Long id) throws Exception;

    public void modificar(BloqueEvaluado bloqueEvaluado)throws Exception;
    
    
}
