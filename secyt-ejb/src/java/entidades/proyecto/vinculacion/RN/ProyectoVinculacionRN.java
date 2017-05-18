/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.vinculacion.RN;

import entidades.proyecto.RN.*;
import DAO.ProyectoFacadeLocal;
import DAO.ProyectoVinculacionFacadeLocal;
import entidades.economico.PagoEconomico;
import entidades.economico.Rendicion;
import entidades.proyecto.Proyecto;
import entidades.proyecto.vinculacion.ProyectoVinculacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class ProyectoVinculacionRN implements ProyectoVinculacionRNLocal {

    @EJB
    private ProyectoVinculacionFacadeLocal proyectoFacadeLocal;

    @Override
    public ProyectoVinculacion find(Object id) throws Exception {
        return  proyectoFacadeLocal.find(id);
    }

    @Override
    public List<ProyectoVinculacion> findAll() throws Exception {
        return  proyectoFacadeLocal.findAll();
    }

  

    @Override
    public String getDirector(ProyectoVinculacion proyecto) throws Exception {
        return  proyectoFacadeLocal.getDirector(proyecto);
    }


 
}
