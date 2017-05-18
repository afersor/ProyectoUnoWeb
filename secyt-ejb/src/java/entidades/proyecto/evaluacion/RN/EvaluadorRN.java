/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import DAO.EvaluadorFacadeLocal;
import entidades.persona.Evaluador;
import entidades.persona.investigador.Investigador;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class EvaluadorRN implements EvaluadorRNLocal {
    
    @EJB
    private EvaluadorFacadeLocal evaluadorFacadeLocal;

    @Override
    public Evaluador buscarXInvestigador(Investigador investigador) throws Exception {
       return evaluadorFacadeLocal.buscarXInvestigador(investigador);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Evaluador findEvaluadorByCUIL(String cuil) throws Exception {
        System.out.println("Entro: " + cuil);
        return evaluadorFacadeLocal.findEvaluadorByCUIL(cuil);
    }

}
