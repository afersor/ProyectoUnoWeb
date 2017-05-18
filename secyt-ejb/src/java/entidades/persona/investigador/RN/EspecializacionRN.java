/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.EspecializacionFacadeLocal;
import entidades.persona.investigador.Especializacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author diego
 */
@Stateless
public class EspecializacionRN implements EspecializacionRNLocal {

    @EJB
    private EspecializacionFacadeLocal especializacionFacadeLocal;
    
    @Override
    public void create(Especializacion esp) throws Exception {
        if(esp.getAño() <= 0){
            throw new Exception("No ingreso el año");
        }//fin if
        
        if(especializacionFacadeLocal.findByInvestigadorYEspecializacion(esp)){
            throw new Exception("Ya existe la especialización");
        }//fin if
        
        especializacionFacadeLocal.create(esp);
    }

    @Override
    public void delete(Especializacion esp) throws Exception {
        especializacionFacadeLocal.remove(esp);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Especializacion> findByInvestigador(Long idInvestigador) throws Exception {
        return especializacionFacadeLocal.findByInvestigador(idInvestigador);
    }

}
