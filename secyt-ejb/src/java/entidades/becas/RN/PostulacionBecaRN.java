/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.becas.RN;

import DAO.PostulacionBecaFacadeLocal;
import entidades.becas.PostulacionBeca;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class PostulacionBecaRN implements PostulacionBecaRNLocal {

    @EJB
    private PostulacionBecaFacadeLocal postulacionBecaFacadeLocal;
    
    @Override
    public List<PostulacionBeca> finByPostulanteAcreditado(Long idPostulante) throws Exception {
        return postulacionBecaFacadeLocal.finByPostulanteAcreditado(idPostulante);
    }

    @Override
    public List<PostulacionBeca> finByDirectorProyecto(Long idPostulante) throws Exception {
        return postulacionBecaFacadeLocal.finByDirectorProyecto(idPostulante);
    }
}
