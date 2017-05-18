/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.Contrasena;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface ContrasenaFacadeLocal {

    void create(Contrasena contrasena);

    void edit(Contrasena contrasena);

    void remove(Contrasena contrasena);

    Contrasena find(Object id);

    List<Contrasena> findAll();

    List<Contrasena> findRange(int[] range);

    int count();
    
    Boolean bFindByInvestigador(String cuil) throws Exception;
    
    Boolean bFindByInvestigadorYcontrasena(String cuil, String contrasena) throws Exception;
    
    void updateContrasena(String cuil, String contrasena) throws Exception;
        
}
