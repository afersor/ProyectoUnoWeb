/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.Evaluador;
import entidades.persona.investigador.Investigador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface EvaluadorFacadeLocal {

    void create(Evaluador evaluador);

    void edit(Evaluador evaluador);

    void remove(Evaluador evaluador);

    Evaluador find(Object id);

    List<Evaluador> findAll();

    List<Evaluador> findRange(int[] range);

    int count();

    public Evaluador buscarXInvestigador(Investigador investigador);
    
    Evaluador findEvaluadorByCUIL(String cuil) throws Exception;
    
}
