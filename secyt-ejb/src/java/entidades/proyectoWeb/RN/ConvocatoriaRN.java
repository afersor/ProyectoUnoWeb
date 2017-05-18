/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb.RN;

import DAO.ConvocatoriaFacadeLocal;
import entidades.proyectoWeb.Convocatoria;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class ConvocatoriaRN implements ConvocatoriaRNLocal {

    @EJB
    private ConvocatoriaFacadeLocal convocatoriaFacadeLocal;
    
    @Override
    public List<Convocatoria> findConvocatorias(Date fechaActual) throws Exception {
        
        return convocatoriaFacadeLocal.findConvocatorias(fechaActual);
    }//fin findConvocatorias

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
