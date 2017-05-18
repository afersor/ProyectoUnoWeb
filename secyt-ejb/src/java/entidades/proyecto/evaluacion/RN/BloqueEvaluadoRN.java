/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.evaluacion.RN;

import DAO.BloqueEvaluadoFacadeLocal;
import entidades.proyecto.evaluacion.BloqueEvaluado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class BloqueEvaluadoRN implements BloqueEvaluadoRNLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private BloqueEvaluadoFacadeLocal bloqueEvaluadoFacadeLocal;

    @Override
    public List<BloqueEvaluado> findAll() throws Exception {
        return bloqueEvaluadoFacadeLocal.findAll();
    }

    @Override
    public BloqueEvaluado buscarPorId(Long id) throws Exception {
        return bloqueEvaluadoFacadeLocal.buscarPorId(id);
    }

    @Override
    public void modificar(BloqueEvaluado bloqueEvaluado) throws Exception {
        bloqueEvaluadoFacadeLocal.edit(bloqueEvaluado);
    }

}
