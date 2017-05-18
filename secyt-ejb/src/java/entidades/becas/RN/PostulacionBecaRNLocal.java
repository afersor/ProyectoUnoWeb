/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.becas.RN;

import entidades.becas.PostulacionBeca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface PostulacionBecaRNLocal {

    public List<PostulacionBeca> finByPostulanteAcreditado(Long idPostulante) throws Exception;

    public List<PostulacionBeca> finByDirectorProyecto(Long idPostulante) throws Exception;
}
