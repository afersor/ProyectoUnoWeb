/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.RecursoSubsidio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface RecursoSubsidioFacadeLocal {

    void create(RecursoSubsidio recursoSubsidio);

    void edit(RecursoSubsidio recursoSubsidio);

    void remove(RecursoSubsidio recursoSubsidio);

    RecursoSubsidio find(Object id);

    List<RecursoSubsidio> findAll();

    List<RecursoSubsidio> findRange(int[] range);

    int count();
    
}
