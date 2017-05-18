/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.Investigador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface InvestigadorFacadeLocal {

    void create(Investigador investigador);

    void edit(Investigador investigador);

    void remove(Investigador investigador);

    Investigador find(Object id);

    List<Investigador> findAll();

    List<Investigador> findRange(int[] range);

    int count();
    
    Investigador findInvestigadorByCUIL(String cuil) throws Exception;
    
    Investigador findInvestigadorByCUILID(String cuil, Long id) throws Exception;
    
    List<Investigador> findLikeNombreyApellido(String cadena) throws Exception;

    
}
