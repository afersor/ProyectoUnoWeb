/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.proyectoWeb.RN;

import entidades.proyectoWeb.ProyectoWeb;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ProyectoWebRNLocal {

    public void guardar(ProyectoWeb proyectoWeb, int pantalla) throws Exception;

    public void delete(ProyectoWeb proyectoWeb) throws Exception;

    public Long findIdProyectoWebByCodigo(String codigo) throws Exception;

    public List<ProyectoWeb> findProyectoWebByDirector(Long idInvestigador) throws Exception;

    List<ProyectoWeb> findProyectoWebByDirectorYConvocatoria(Long idInvestigador, Long idConvocatoria) throws Exception;

    public List<ProyectoWeb> findAll() throws Exception;
}
