/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.titulo.RN;

import DAO.TituloOtroFacadeLocal;
import entidades.titulo.TituloOtro;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class TituloOtroRN implements TituloOtroRNLocal {
    
    @EJB
    private TituloOtroFacadeLocal tituloOtroFacadeLocal;
    
    @Override
    public List<TituloOtro> buscarTitulosOtro() throws Exception {
        return tituloOtroFacadeLocal.buscarTitulosOtro();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
