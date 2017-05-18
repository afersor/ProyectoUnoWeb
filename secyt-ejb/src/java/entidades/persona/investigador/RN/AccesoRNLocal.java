/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import entidades.persona.investigador.Acceso;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface AccesoRNLocal {
    void create(Acceso acceso) throws Exception;
    
}
