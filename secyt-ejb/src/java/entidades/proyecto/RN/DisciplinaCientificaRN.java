/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyecto.RN;

import DAO.DisciplinaCientificaFacadeLocal;
import entidades.proyecto.AreaTematica;
import entidades.proyecto.DisciplinaCientifica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author franco
 */
@Stateless
public class DisciplinaCientificaRN implements DisciplinaCientificaRNLocal {

    @EJB
    private DisciplinaCientificaFacadeLocal disciplinaCientificaFacadeLocal;

    @Override
    public void create(DisciplinaCientifica disciplinaCientifica) {
        disciplinaCientificaFacadeLocal.create(disciplinaCientifica);
    }

    @Override
    public void edit(DisciplinaCientifica disciplinaCientifica) {
        disciplinaCientificaFacadeLocal.edit(disciplinaCientifica);
    }

    @Override
    public void remove(DisciplinaCientifica disciplinaCientifica) {
        disciplinaCientificaFacadeLocal.remove(disciplinaCientifica);
    }

    @Override
    public DisciplinaCientifica find(Object id) {
        return disciplinaCientificaFacadeLocal.find(id);
    }

    @Override
    public List<DisciplinaCientifica> findAll() {
        return disciplinaCientificaFacadeLocal.findAll();
    }

    @Override
    public List<DisciplinaCientifica> findRange(int[] range) {
        return disciplinaCientificaFacadeLocal.findRange(range);
    }

    @Override
    public int count() {
        return disciplinaCientificaFacadeLocal.count();
    }

    @Override
    public List<DisciplinaCientifica> findDisciplinasCientificasByAreaTematica(AreaTematica areaTematica) throws Exception {
        return disciplinaCientificaFacadeLocal.findDisciplinasCientificasByAreaTematica(areaTematica);
    }

    @Override
    public List<DisciplinaCientifica> findDisciplinasCientificas() throws Exception {
        return disciplinaCientificaFacadeLocal.findDisciplinasCientificas();
    }

}
