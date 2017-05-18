/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.titulo.TituloOtro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface TituloOtroFacadeLocal {

    void create(TituloOtro tituloOtro);

    void edit(TituloOtro tituloOtro);

    void remove(TituloOtro tituloOtro);

    TituloOtro find(Object id);

    List<TituloOtro> findAll();

    List<TituloOtro> findRange(int[] range);

    int count();

    public List<TituloOtro> buscarTitulosOtro();
    
}
