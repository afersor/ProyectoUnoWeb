/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.persona.investigador.Destinatario;
import entidades.persona.investigador.Investigador;
import entidades.persona.investigador.Mensaje;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> implements MensajeFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }

    @Override
    public List<Mensaje> buscarMensajesRecibidos(Investigador investigador) {
        Query q = em.createQuery("SELECT m FROM Mensaje m WHERE m.investigador=:investigador "
                + "AND m.destinatario=:destinatario Order by m.fechaEnvio DESC");
        q.setParameter("investigador",investigador);
        q.setParameter("destinatario", Destinatario.INVESTIGADOR);
        return q.getResultList();
    }

    @Override
    public List<Mensaje> buscarMensajesEnviados(Investigador investigador) {
        Query q = em.createQuery("SELECT m FROM Mensaje m WHERE m.investigador=:investigador "
                + "AND m.destinatario=:destinatario Order by m.fechaEnvio DESC");
        q.setParameter("investigador",investigador);
        q.setParameter("destinatario", Destinatario.AREASECYT);
        return q.getResultList();
    }

    
    
}
