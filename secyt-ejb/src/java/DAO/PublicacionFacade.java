/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyecto.Proyecto;
import entidades.proyecto.resultado.ArticuloRevista;
import entidades.proyecto.resultado.Libro;
import entidades.proyecto.resultado.Publicacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AFerSor
 */
@Stateless
public class PublicacionFacade extends AbstractFacade<Publicacion> implements PublicacionFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicacionFacade() {
        super(Publicacion.class);
    }

    @Override
    public List<Publicacion> findByInvestigador(Long idProyecto,Long idInvestigador, Class tipo) throws Exception {
        
         Query q = em.createNamedQuery("Publicacion.findByInvestigador");  
         q.setParameter("idProyecto",idProyecto);
         q.setParameter("idInvestigador",idInvestigador);
         q.setParameter("tipo", tipo);
         return q.getResultList();

    }//fin finByInvestigador

    @Override
    public void activate(Publicacion pu, Boolean bEstado) {
  Query q = em.createNamedQuery("Publicacion.ActualizarEstado");
        q.setParameter("active", bEstado);
        q.setParameter("id", pu.getId());
       
        q.executeUpdate();
    
    }

    @Override
    public List<Libro> getLibros() throws Exception {
 
         try {
            Query q = em.createNamedQuery("Libro.findByLibro");
            return (List<Libro>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Libro> getLibrosTodos(String texto) throws Exception {
    
        Query quBuscar = em.createQuery("SELECT p FROM Publicacion p WHERE TYPE(p) = Libro AND p.titulo LIKE '%"+texto+"%'");
        
        try {
            if (!quBuscar.getResultList().isEmpty()) {
                return quBuscar.getResultList();
            } else {
                return new ArrayList<>();
            }
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Libro> getLibrosProyecto(Proyecto proyecto) throws Exception {
    
        Query quBuscar = em.createQuery("SELECT p FROM Publicacion p, IN (p.proyectos) pr WHERE TYPE(p) = Libro AND  pr = :proyecto");
        quBuscar.setParameter("proyecto", proyecto);
        return quBuscar.getResultList();
    }
  
    
}//FIN CLASE
