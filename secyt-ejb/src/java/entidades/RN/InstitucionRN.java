/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import DAO.InstitucionFacadeLocal;
import entidades.Institucion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hugo
 */
@Stateless
public class InstitucionRN implements InstitucionRNLocal {

    @EJB
    private InstitucionFacadeLocal institucionFacadeLocal;
    
    @Override
    public List<Institucion> buscarInstituciones() throws Exception {
        
        return institucionFacadeLocal.buscarInstituciones();
       
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
