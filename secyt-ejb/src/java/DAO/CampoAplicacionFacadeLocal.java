/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.CampoAplicacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface CampoAplicacionFacadeLocal {

    void create(CampoAplicacion campoAplicacion);

    void edit(CampoAplicacion campoAplicacion);

    void remove(CampoAplicacion campoAplicacion);

    CampoAplicacion find(Object id);

    List<CampoAplicacion> findAll();

    List<CampoAplicacion> findRange(int[] range);

    int count();
    
    List<CampoAplicacion> findLikeDescripcion(String cadena) throws Exception;
    
}
