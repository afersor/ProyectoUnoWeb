/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.LogProyectoFacadeLocal;
import entidades.proyecto.LogProyecto;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class LogProyectoRN implements LogProyectoRNLocal {

    @EJB
    private LogProyectoFacadeLocal logProyectoFacadeLocal;
    
    @Override
    public void create(LogProyecto logProyecto) throws Exception {
        logProyectoFacadeLocal.create(logProyecto);
    }

    

}
