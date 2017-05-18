/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.Especializacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface EspecializacionFacadeLocal {

    void create(Especializacion especializacion);

    void edit(Especializacion especializacion);

    void remove(Especializacion especializacion);

    Especializacion find(Object id);

    List<Especializacion> findAll();

    List<Especializacion> findRange(int[] range);

    int count();
    
    List<Especializacion> findByInvestigador(Long idInvestigador) throws Exception;
    
    Boolean findByInvestigadorYEspecializacion(Especializacion esp) throws Exception;
    
}
