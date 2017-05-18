/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.proyectoWeb.ProyectoWeb;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author diego
 */
@Stateless
public class ProyectoWebFacade extends AbstractFacade<ProyectoWeb> implements ProyectoWebFacadeLocal {
    @PersistenceContext(unitName = "secyt-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoWebFacade() {
        super(ProyectoWeb.class);
    }

    @Override
    public Boolean findProyectoWebByCodigo(String codigo) throws Exception {
        try{
            Query q = em.createNamedQuery("ProyectoWeb.findProyectoWebByCodigo");
            q.setParameter("codigo", codigo);
            q.getSingleResult();
            return true;
        }catch(NoResultException e){
            return false;
        }
    }

    @Override
    public List<ProyectoWeb> findProyectoWebByDirector(Long idInvestigador) throws Exception {

            Query q = em.createNamedQuery("ProyectoWeb.findProyectoWebByDirector");
            
            System.out.println("idInvestigador: " + idInvestigador);
            q.setParameter("idInvestigador", idInvestigador);
            q.setParameter("rol", "Director");
            
            List <ProyectoWeb> lstP = q.getResultList();
            for(ProyectoWeb pw : lstP){
                em.refresh(pw);
            }//fin for

            return lstP;

    }//fin findProyectoWebByFechas

    @Override
    public Boolean findProyectoWebByTitulo(String titulo, Long id) throws Exception {
        try{
            Query q = null;
            if(id == null){
                q = em.createNamedQuery("ProyectoWeb.findProyectoWebByTitulo");
                
            }else{
                q = em.createNamedQuery("ProyectoWeb.findProyectoWebByTituloID");
                q.setParameter("id", id);
            }//fin if
            q.setParameter("titulo", titulo);
            
            q.getSingleResult();
            return true;
        }catch(NoResultException e){
            return false;
        }
    }

    @Override
    public Long findIdProyectoWebByCodigo(String codigo) throws Exception {
         try{
            Query q = em.createNamedQuery("ProyectoWeb.findProyectoWebByCodigo");
            q.setParameter("codigo", codigo);
            
            return ((ProyectoWeb)q.getSingleResult()).getId();
        }catch(NoResultException e){
            return null;
        }
        
    }//fin findIdProyectoWebByCodigo

    @Override
    public List<ProyectoWeb> findProyectoWebByDirectorYConvocatoria(Long idInvestigador, Long idConvocatoria) throws Exception {
        Query q = em.createNamedQuery("ProyectoWeb.findProyectoWebByDirectorYConvocatoria");
        q.setParameter("idInvestigador", idInvestigador);
        q.setParameter("idConvocatoria", idConvocatoria);
        q.setParameter("rol", "Director");

        return q.getResultList();
    }
    
}//FIN CLASE
