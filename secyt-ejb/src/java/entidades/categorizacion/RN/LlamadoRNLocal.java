/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.categorizacion.RN;

import entidades.categorizacion.Llamado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface LlamadoRNLocal {
    List<Llamado> findAll() throws Exception;
}
