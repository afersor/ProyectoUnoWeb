/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.resultado.Propiedad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface PropiedadFacadeLocal {

    void create(Propiedad propiedad);

    void edit(Propiedad propiedad);

    void remove(Propiedad propiedad);

    Propiedad find(Object id);

    List<Propiedad> findAll();

    List<Propiedad> findRange(int[] range);

    int count();
    
    public List<Propiedad> findByTypeYProyecto(Long idProyecto,Long idInvestigador, Class tipo) throws Exception;
    
}
