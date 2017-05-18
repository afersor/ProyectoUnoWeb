/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.localidad.Departamento;
import entidades.localidad.Localidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface LocalidadFacadeLocal {

    void create(Localidad localidad);

    void edit(Localidad localidad);

    void remove(Localidad localidad);

    Localidad find(Object id);

    List<Localidad> findAll();

    List<Localidad> findRange(int[] range);

    int count();
    
    List<Localidad> findLocalidadesByDpto(Departamento departamento) throws Exception;
    
}
