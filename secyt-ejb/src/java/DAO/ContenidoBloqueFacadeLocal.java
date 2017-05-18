/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.evaluacion.Bloque;
import entidades.proyecto.evaluacion.ContenidoBloque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ContenidoBloqueFacadeLocal {

    void create(ContenidoBloque contenidoBloque);

    void edit(ContenidoBloque contenidoBloque);

    void remove(ContenidoBloque contenidoBloque);

    ContenidoBloque find(Object id);

    List<ContenidoBloque> findAll();

    List<ContenidoBloque> findRange(int[] range);

    int count();
    
    List<ContenidoBloque> findByBLoque(Bloque bloque);
    
}
