/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.DepartamentoDocente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface DepartamentoDocenteFacadeLocal {

    void create(DepartamentoDocente departamentoDocente);

    void edit(DepartamentoDocente departamentoDocente);

    void remove(DepartamentoDocente departamentoDocente);

    DepartamentoDocente find(Object id);

    List<DepartamentoDocente> findAll();

    List<DepartamentoDocente> findRange(int[] range);

    int count();
    
}
