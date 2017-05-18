/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.MensajeEvaluacion;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface MensajeEvaluacionRNLocal {

    public void create(MensajeEvaluacion mensajeEvaluacion)throws Exception;

    public int contarNoLeidos(BloqueEvaluado bloqueEvaluado);

    public void modificar(MensajeEvaluacion mensajeEvaluacion)throws Exception;
    
}
