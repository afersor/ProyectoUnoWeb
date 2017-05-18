/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.Acceso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface AccesoFacadeLocal {

    void create(Acceso acceso);

    void edit(Acceso acceso);

    void remove(Acceso acceso);

    Acceso find(Object id);

    List<Acceso> findAll();

    List<Acceso> findRange(int[] range);

    int count();
    
}
