/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.titulo.TituloGrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface TituloGradoFacadeLocal {

    void create(TituloGrado tituloGrado);

    void edit(TituloGrado tituloGrado);

    void remove(TituloGrado tituloGrado);

    TituloGrado find(Object id);

    List<TituloGrado> findAll();

    List<TituloGrado> findRange(int[] range);

    int count();

    public List<TituloGrado> findTitulosGrado();
    
}
