/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.Sexo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface SexoFacadeLocal {

    void create(Sexo sexo);

    void edit(Sexo sexo);

    void remove(Sexo sexo);

    Sexo find(Object id);

    List<Sexo> findAll();

    List<Sexo> findRange(int[] range);

    int count();
    
    List<Sexo> findSexos() throws Exception;
    
}
