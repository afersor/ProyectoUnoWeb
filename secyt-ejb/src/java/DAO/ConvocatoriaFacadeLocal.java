/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.Convocatoria;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ConvocatoriaFacadeLocal {

    void create(Convocatoria convocatoria);

    void edit(Convocatoria convocatoria);

    void remove(Convocatoria convocatoria);

    Convocatoria find(Object id);

    List<Convocatoria> findAll();

    List<Convocatoria> findRange(int[] range);

    int count();
    
    List<Convocatoria> findConvocatorias(Date fechaActual) throws Exception;
    
}
