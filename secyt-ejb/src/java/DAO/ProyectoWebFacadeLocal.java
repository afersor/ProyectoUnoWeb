/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.ProyectoWeb;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ProyectoWebFacadeLocal {

    void create(ProyectoWeb proyectoWeb);

    void edit(ProyectoWeb proyectoWeb);

    void remove(ProyectoWeb proyectoWeb);

    ProyectoWeb find(Object id);

    List<ProyectoWeb> findAll();

    List<ProyectoWeb> findRange(int[] range);

    int count();
    
    Boolean findProyectoWebByTitulo(String titulo, Long id) throws Exception;
    
    Boolean findProyectoWebByCodigo(String codigo) throws Exception;
    
    Long findIdProyectoWebByCodigo(String codigo) throws Exception;
    
    List<ProyectoWeb> findProyectoWebByDirector(Long idInvestigador) throws Exception;
    
    List<ProyectoWeb> findProyectoWebByDirectorYConvocatoria(Long idInvestigador, Long idConvocatoria) throws Exception;
    
}
