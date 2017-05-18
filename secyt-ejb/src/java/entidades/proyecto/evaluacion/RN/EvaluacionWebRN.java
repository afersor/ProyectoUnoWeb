/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import DAO.EvaluacionWebFacadeLocal;
import entidades.proyecto.evaluacion.BloqueEvaluado;
import entidades.proyecto.evaluacion.DetalleEvaluado;
import entidades.proyecto.evaluacion.EvaluacionWeb;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class EvaluacionWebRN implements EvaluacionWebRNLocal {

    @EJB
    private EvaluacionWebFacadeLocal evaluacionWebFacadeLocal;
    
    @Override
    public void create(EvaluacionWeb evaluacionWeb) throws Exception {
        evaluacionWebFacadeLocal.create(evaluacionWeb);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<EvaluacionWeb> findAllByEvaluador(Long idEvaluador) throws Exception {
        return evaluacionWebFacadeLocal.findAllByEvaluador(idEvaluador);
    }

    @Override
    public void edit(EvaluacionWeb evaluacionWeb) throws Exception {
        evaluacionWebFacadeLocal.edit(evaluacionWeb);
    }
    
    private void validar(EvaluacionWeb evaluacionWeb) throws Exception{
        
        for(BloqueEvaluado be : evaluacionWeb.getBloquesEvaluados()){
            if(be.getCalificacion() == null){
                throw new Exception("Debe completar la calificación global de todos los bloques");
            }//fin if
            
            for(DetalleEvaluado de : be.getDetallesEvaluados()){
                
                if(de.getCalificacion() == null){
                    throw new Exception("Debe completar la calificación de todos los bloques");
                }//fin if
 
            }//fin for
        }//fin for
        
        if(evaluacionWeb.getCalificacionGlobal() == null){
            throw new Exception("Debe completar la calificación globar");
        }//fin if
    }//fin validar

    @Override
    public List<EvaluacionWeb> findByProyecto(Long idProyecto) throws Exception {
        return evaluacionWebFacadeLocal.findByProyecto(idProyecto);
    }
    
    }