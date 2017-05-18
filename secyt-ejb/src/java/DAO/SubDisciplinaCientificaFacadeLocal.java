/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.SubDisciplinaCientifica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author franco
 */
@Local
public interface SubDisciplinaCientificaFacadeLocal {

    void create(SubDisciplinaCientifica subDisciplinaCientifica);

    void edit(SubDisciplinaCientifica subDisciplinaCientifica);

    void remove(SubDisciplinaCientifica subDisciplinaCientifica);

    SubDisciplinaCientifica find(Object id);

    List<SubDisciplinaCientifica> findAll();

    List<SubDisciplinaCientifica> findRange(int[] range);

    int count();

    public List<SubDisciplinaCientifica> findConLatLong() throws Exception;

}
