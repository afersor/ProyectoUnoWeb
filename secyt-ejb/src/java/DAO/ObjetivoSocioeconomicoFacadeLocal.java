/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.AreaTematica;
import entidades.proyecto.ObjetivoSocioeconomico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ObjetivoSocioeconomicoFacadeLocal {

    void create(ObjetivoSocioeconomico objetivoSocioeconomico);

    void edit(ObjetivoSocioeconomico objetivoSocioeconomico);

    void remove(ObjetivoSocioeconomico objetivoSocioeconomico);

    ObjetivoSocioeconomico find(Object id);

    List<ObjetivoSocioeconomico> findAll();

    List<ObjetivoSocioeconomico> findRange(int[] range);

    int count();
    
    List<ObjetivoSocioeconomico> findObjetivosSocioeconomicos() throws Exception;
    
}
