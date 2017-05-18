/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.titulo.RN;

import entidades.titulo.TituloPosgrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface TituloPosgradoRNLocal {

    public List<TituloPosgrado> buscarTitulosPosgrado()throws Exception;

    
    
}
