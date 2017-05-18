/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.Mensaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AFerSor
 */
@Local
public interface MensajeRNLocal {
    void create(Mensaje mensaje) throws Exception;
    List<Mensaje> findAll() throws Exception;
    List<Mensaje> buscarMensajesRecibidos(Investigador investigador) throws Exception;
    void modificar(Mensaje mensaje)throws Exception;
    List<Mensaje> buscarMensajesEnviados(Investigador investigador)throws Exception;
}
