/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import entidades.Universidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface UniversidadRNLocal {

    public List<Universidad> buscarUniversidades()throws Exception;
    
}
