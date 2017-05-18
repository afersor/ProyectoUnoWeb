/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import entidades.persona.investigador.Especializacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface EspecializacionRNLocal {
    
    public void create(Especializacion esp) throws Exception;
    public void delete(Especializacion esp) throws Exception;
    
    List<Especializacion> findByInvestigador(Long idInvestigador) throws Exception;
    
}
