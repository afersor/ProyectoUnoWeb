/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import entidades.proyecto.AreaTematica;
import entidades.proyecto.DisciplinaCientifica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author franco
 */
@Local
public interface DisciplinaCientificaRNLocal {

    void create(DisciplinaCientifica disciplinaCientifica);

    void edit(DisciplinaCientifica disciplinaCientifica);

    void remove(DisciplinaCientifica disciplinaCientifica);

    DisciplinaCientifica find(Object id);

    List<DisciplinaCientifica> findAll();

    List<DisciplinaCientifica> findRange(int[] range);

    int count();

    public List<DisciplinaCientifica> findDisciplinasCientificasByAreaTematica(AreaTematica areaTematica) throws Exception;

    public List<DisciplinaCientifica> findDisciplinasCientificas() throws Exception;

}
