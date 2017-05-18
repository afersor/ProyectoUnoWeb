/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.localidad.RN;

import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface LocalidadRNLocal {

    List<Localidad> findLocalidadesByDpto(Departamento departamento) throws Exception;

    Localidad find(Long id);

}
