/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb.RN;

import entidades.proyectoWeb.Convocatoria;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ConvocatoriaRNLocal {
    public List<Convocatoria> findConvocatorias(Date fechaActual) throws Exception;
}
