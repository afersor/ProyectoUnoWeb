/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import entidades.persona.investigador.AreaSecyt;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface AreaSecytRNLocal {
    List<AreaSecyt> findAll();
}
