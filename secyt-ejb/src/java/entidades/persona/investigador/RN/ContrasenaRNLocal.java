/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface ContrasenaRNLocal {
    public void create(String cuil, String contrasena) throws Exception;
    public void edit(String cuil, String contrasena) throws Exception;
    public Boolean bFindByInvestigadorYcontrasena(String cuil, String contrasena) throws Exception;
}
