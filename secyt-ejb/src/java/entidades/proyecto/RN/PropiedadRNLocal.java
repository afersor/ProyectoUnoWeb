/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import entidades.proyecto.resultado.Industrial;
import entidades.proyecto.resultado.Propiedad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface PropiedadRNLocal {
    public List<Propiedad> findByTypeYProyecto(Long idProyecto,Long idInvestigador, Class tipo) throws Exception;
    public void create (Propiedad propiedad, String clase) throws Exception;
    public void edit (Propiedad propiedad, String clase) throws Exception;

    public void remove(Propiedad propiedad) throws Exception;
}
