/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.LineaInvestigacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface LineaInvestigacionFacadeLocal {

    void create(LineaInvestigacion lineaInvestigacion);

    void edit(LineaInvestigacion lineaInvestigacion);

    void remove(LineaInvestigacion lineaInvestigacion);

    LineaInvestigacion find(Object id);

    List<LineaInvestigacion> findAll();

    List<LineaInvestigacion> findRange(int[] range);

    int count();
    
    List<LineaInvestigacion> findLineasInvestigacion() throws Exception;
    
}
