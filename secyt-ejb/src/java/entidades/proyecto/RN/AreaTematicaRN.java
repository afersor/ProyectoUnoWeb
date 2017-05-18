/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.AreaTematicaFacadeLocal;
import entidades.proyecto.AreaTematica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class AreaTematicaRN implements AreaTematicaRNLocal {
    
    @EJB
    private AreaTematicaFacadeLocal areaTematicaFacadeLocal;
    
    @Override
    public List<AreaTematica> findAreasTematicas() throws Exception {
        return areaTematicaFacadeLocal.findAreasTematicas();
    }

    @Override
    public AreaTematica find(Long id) {
        return areaTematicaFacadeLocal.find(id);
    }

}
