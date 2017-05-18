/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.categorizacion.ValorCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ValorCategoriaFacadeLocal {

    void create(ValorCategoria valorCategoria);

    void edit(ValorCategoria valorCategoria);

    void remove(ValorCategoria valorCategoria);

    ValorCategoria find(Object id);

    List<ValorCategoria> findAll();

    List<ValorCategoria> findRange(int[] range);

    int count();
    
}
