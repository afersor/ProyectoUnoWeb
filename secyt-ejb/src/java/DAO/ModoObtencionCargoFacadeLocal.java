/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.ModoObtencionCargo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface ModoObtencionCargoFacadeLocal {

    void create(ModoObtencionCargo modoObtencionCargo);

    void edit(ModoObtencionCargo modoObtencionCargo);

    void remove(ModoObtencionCargo modoObtencionCargo);

    ModoObtencionCargo find(Object id);

    List<ModoObtencionCargo> findAll();

    List<ModoObtencionCargo> findRange(int[] range);

    int count();
    
}
