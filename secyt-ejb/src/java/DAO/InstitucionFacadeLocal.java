/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Institucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface InstitucionFacadeLocal {

    void create(Institucion institucion);

    void edit(Institucion institucion);

    void remove(Institucion institucion);

    Institucion find(Object id);

    List<Institucion> findAll();

    List<Institucion> findRange(int[] range);

    int count();

    public List<Institucion> buscarInstituciones()throws Exception;
    
}
