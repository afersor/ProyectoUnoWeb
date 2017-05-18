/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.titulo.RN;

import DAO.TituloPosgradoFacadeLocal;
import entidades.titulo.TituloPosgrado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class TituloPosgradoRN implements TituloPosgradoRNLocal {
    
    @EJB
    private TituloPosgradoFacadeLocal tituloPosgradoFacadeLocal;

    @Override
    public List<TituloPosgrado> buscarTitulosPosgrado() throws Exception {
        return tituloPosgradoFacadeLocal.buscarTitulosPosgrado();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
