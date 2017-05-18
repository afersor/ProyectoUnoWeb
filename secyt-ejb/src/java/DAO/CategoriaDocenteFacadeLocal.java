/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.CategoriaDocente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface CategoriaDocenteFacadeLocal {

    void create(CategoriaDocente categoriaDocente);

    void edit(CategoriaDocente categoriaDocente);

    void remove(CategoriaDocente categoriaDocente);

    CategoriaDocente find(Object id);

    List<CategoriaDocente> findAll();

    List<CategoriaDocente> findRange(int[] range);

    int count();
    
}
