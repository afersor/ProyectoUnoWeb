/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.AreaSecyt;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface AreaSecytFacadeLocal {

    void create(AreaSecyt areaSecyt);

    void edit(AreaSecyt areaSecyt);

    void remove(AreaSecyt areaSecyt);

    AreaSecyt find(Object id);

    List<AreaSecyt> findAll();

    List<AreaSecyt> findRange(int[] range);

    int count();
    
}
