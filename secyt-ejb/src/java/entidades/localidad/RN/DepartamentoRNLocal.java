/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.localidad.RN;

import entidades.localidad.Departamento;
import entidades.localidad.Provincia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface DepartamentoRNLocal {

    List<Departamento> findDepartamentosByProvincia(Provincia provincia) throws Exception;

    public List<Departamento> findDepartamentosCatamarca() throws Exception;

    public Departamento find(Long id);
}
