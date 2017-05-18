/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.vinculacion.ParticipacionVinculacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface ParticipacionVinculacionFacadeLocal {

    void create(ParticipacionVinculacion participacionVinculacion);

    void edit(ParticipacionVinculacion participacionVinculacion);

    void remove(ParticipacionVinculacion participacionVinculacion);

    ParticipacionVinculacion find(Object id);

    List<ParticipacionVinculacion> findAll();

    List<ParticipacionVinculacion> findRange(int[] range);

    int count();
    
    List<ParticipacionVinculacion> findByInvestigador(Long idInvestigador) throws Exception;
}
