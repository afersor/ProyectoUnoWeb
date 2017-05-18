/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.becas.PostulacionBeca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface PostulacionBecaFacadeLocal {

    void create(PostulacionBeca postulacionBeca);

    void edit(PostulacionBeca postulacionBeca);

    void remove(PostulacionBeca postulacionBeca);

    PostulacionBeca find(Object id);

    List<PostulacionBeca> findAll();

    List<PostulacionBeca> findRange(int[] range);

    int count();
    
    public List<PostulacionBeca> finByPostulanteAcreditado(Long idPostulante) throws Exception;

    public List<PostulacionBeca> finByDirectorProyecto(Long idPostulante) throws Exception;
    
}
