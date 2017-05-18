/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.RN;

import entidades.persona.Sexo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface SexoRNLocal {
    List<Sexo> findSexos() throws Exception;
}
