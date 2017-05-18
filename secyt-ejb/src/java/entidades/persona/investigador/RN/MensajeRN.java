/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.persona.investigador.RN;

import DAO.MensajeFacadeLocal;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.Mensaje;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AFerSor
 */
@Stateless
public class MensajeRN implements MensajeRNLocal {

    @EJB
    private MensajeFacadeLocal mensajeFacadeLocal;
    
    @Override
    public void create(Mensaje mensaje) throws Exception {
        this.validar(mensaje);
        mensaje.setFechaEnvio(new Date());
        mensaje.setLeido(Boolean.FALSE);
        mensajeFacadeLocal.create(mensaje);
    }

    @Override
    public List<Mensaje> findAll() throws Exception {
        return mensajeFacadeLocal.findAll();
    }

    private void validar(Mensaje mensaje) throws Exception{
        
        if(mensaje.getAreaSecyt() == null){
            throw new Exception("No seleccionó el área");
        }//fin if
        if(mensaje.getDescripcion().isEmpty()){
            throw new Exception("No ingreso el mensaje");
        }//fin if
    }//fin validar

    @Override
    public List<Mensaje> buscarMensajesRecibidos(Investigador investigador) throws Exception {
        return mensajeFacadeLocal.buscarMensajesRecibidos(investigador);
    }

    @Override
    public void modificar(Mensaje mensaje) throws Exception {
        mensajeFacadeLocal.edit(mensaje);
    }

    @Override
    public List<Mensaje> buscarMensajesEnviados(Investigador investigador) throws Exception {
        return mensajeFacadeLocal.buscarMensajesEnviados(investigador);
    }

    

}//FIN CLASE
