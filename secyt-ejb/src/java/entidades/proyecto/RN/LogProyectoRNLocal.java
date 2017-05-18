/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import entidades.proyecto.LogProyecto;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface LogProyectoRNLocal {
    public void create(LogProyecto logProyecto) throws Exception;
}