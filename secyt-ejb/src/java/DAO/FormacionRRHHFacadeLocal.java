/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.resultado.FormacionRRHH;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface FormacionRRHHFacadeLocal {

    void create(FormacionRRHH formacionRRHH);

    void edit(FormacionRRHH formacionRRHH);

    void remove(FormacionRRHH formacionRRHH);

    FormacionRRHH find(Object id);

    List<FormacionRRHH> findAll();

    List<FormacionRRHH> findRange(int[] range);

    int count();
     public List<FormacionRRHH> findByTypeYProyecto(Long idProyecto,Long idInvestigador) throws Exception;
    
}
