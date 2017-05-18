/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import DAO.MensajeEvaluacionFacadeLocal;
import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.MensajeEvaluacion;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class MensajeEvaluacionRN implements MensajeEvaluacionRNLocal {
    
    @EJB
    private MensajeEvaluacionFacadeLocal mensajeEvaluacionFacadeLocal;

    @Override
    public void create(MensajeEvaluacion mensajeEvaluacion)throws Exception{
        mensajeEvaluacionFacadeLocal.create(mensajeEvaluacion);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int contarNoLeidos(BloqueEvaluado bloqueEvaluado) {
        return mensajeEvaluacionFacadeLocal.contarNoLeidos(bloqueEvaluado);
        
    }

    @Override
    public void modificar(MensajeEvaluacion mensajeEvaluacion)throws Exception{
        mensajeEvaluacionFacadeLocal.edit(mensajeEvaluacion);
    }

}
