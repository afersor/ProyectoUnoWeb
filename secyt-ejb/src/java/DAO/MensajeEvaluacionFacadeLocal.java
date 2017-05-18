/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.MensajeEvaluacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface MensajeEvaluacionFacadeLocal {

    void create(MensajeEvaluacion mensajeEvaluacion);

    void edit(MensajeEvaluacion mensajeEvaluacion);

    void remove(MensajeEvaluacion mensajeEvaluacion);

    MensajeEvaluacion find(Object id);

    List<MensajeEvaluacion> findAll();

    List<MensajeEvaluacion> findRange(int[] range);

    int count();

    public int contarNoLeidos(BloqueEvaluado bloqueEvaluado);
    
}
