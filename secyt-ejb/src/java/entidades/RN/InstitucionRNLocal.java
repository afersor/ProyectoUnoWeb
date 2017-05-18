/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.RN;

import entidades.Institucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface InstitucionRNLocal {

    public List<Institucion> buscarInstituciones() throws Exception;
    
}
