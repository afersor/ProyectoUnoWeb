/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.vinculacion.RN;

import entidades.proyecto.vinculacion.ProyectoVinculacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface ProyectoVinculacionRNLocal {

    public ProyectoVinculacion find(Object id) throws Exception;

    public List<ProyectoVinculacion> findAll() throws Exception;

    public java.lang.String getDirector(ProyectoVinculacion proyecto) throws java.lang.Exception;

}
