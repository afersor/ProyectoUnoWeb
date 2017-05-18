/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.titulo.TituloPosgrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface TituloPosgradoFacadeLocal {

    void create(TituloPosgrado tituloPosgrado);

    void edit(TituloPosgrado tituloPosgrado);

    void remove(TituloPosgrado tituloPosgrado);

    TituloPosgrado find(Object id);

    List<TituloPosgrado> findAll();

    List<TituloPosgrado> findRange(int[] range);

    int count();

    public List<TituloPosgrado> buscarTitulosPosgrado();
    
}
