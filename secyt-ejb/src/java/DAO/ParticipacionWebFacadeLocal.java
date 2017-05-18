/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.ParticipacionWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface ParticipacionWebFacadeLocal {

    void create(ParticipacionWeb participacionWeb);

    void edit(ParticipacionWeb participacionWeb);

    void remove(ParticipacionWeb participacionWeb);

    ParticipacionWeb find(Object id);

    List<ParticipacionWeb> findAll();

    List<ParticipacionWeb> findRange(int[] range);

    int count();
    
}
