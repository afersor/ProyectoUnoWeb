/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.titulo.RN;

import entidades.titulo.TituloGrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface TituloGradoRNLocal {

    public List<TituloGrado> buscarTitulos()throws Exception;
    
}
