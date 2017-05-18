/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import entidades.proyecto.ObjetivoSocioeconomico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ObjetivoSocioEconomicoRNLocal {
    List<ObjetivoSocioeconomico> findObjetivosSocioeconomicos() throws Exception;
}
