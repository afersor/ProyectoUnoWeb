/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.BloqueEvaluado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hugo
 */
@Local
public interface BloqueEvaluadoFacadeLocal {

    void create(BloqueEvaluado bloqueEvaluado);

    void edit(BloqueEvaluado bloqueEvaluado);

    void remove(BloqueEvaluado bloqueEvaluado);

    BloqueEvaluado find(Object id);

    List<BloqueEvaluado> findAll();

    List<BloqueEvaluado> findRange(int[] range);

    int count();

    public BloqueEvaluado buscarPorId(Long id);

    }
