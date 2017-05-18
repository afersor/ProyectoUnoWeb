/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.ObjetivoSocioeconomicoFacadeLocal;
import entidades.proyecto.ObjetivoSocioeconomico;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class ObjetivoSocioEconomicoRN implements ObjetivoSocioEconomicoRNLocal {

    @EJB
    private ObjetivoSocioeconomicoFacadeLocal objetivoSocioEconomicoFacadeLocal;
    @Override
    public List<ObjetivoSocioeconomico> findObjetivosSocioeconomicos() throws Exception {
        return objetivoSocioEconomicoFacadeLocal.findObjetivosSocioeconomicos();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
