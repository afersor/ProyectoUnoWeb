/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import entidades.persona.investigador.Investigador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface InvestigadorRNLocal {
    public Investigador findInvestigadorByCUIL(String cuil) throws Exception;
    public Investigador findById(Long id) throws Exception;
    public void edit(Investigador investigador) throws Exception;
    public void create(Investigador investigador) throws Exception;
    List<Investigador> findLikeNombreyApellido(String cadena) throws Exception;
    Investigador find(Object id)throws Exception;
}//FIN CLASE
