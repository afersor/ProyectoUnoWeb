/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.titulo.RN;

import DAO.TituloGradoFacade;
import DAO.TituloGradoFacadeLocal;
import entidades.titulo.TituloGrado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class TituloGradoRN implements TituloGradoRNLocal {
    
    @EJB
    private TituloGradoFacadeLocal tituloGradoFacadeLocal;
    @Override
    public List<TituloGrado> buscarTitulos() throws Exception {
       
       return tituloGradoFacadeLocal.findTitulosGrado();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
